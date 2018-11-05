package com.caizhukui.rrmeiju.task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.common.util.ChineseUtils;
import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.SubtitleFile;
import com.caizhukui.rrmeiju.service.ServiceFacade;
import com.caizhukui.rrmeiju.test.ChainRunner;

/**
 * 定时任务
 * 
 * @author caizhukui
 * @date 2017年1月11日
 */
//@Component
public class ScheduledTasks implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    
    @Autowired
	private ServiceFacade serviceFacade;
    
    @Autowired
	private ChainRunner chainRunner;
    
    /**
     * 给没有海报的美剧季设置默认海报
     * 
     * @author caizhukui
     * @date 2017年3月29日
     */
    @Scheduled(fixedDelayString = "${fixedDelay.setDefaultPosterUrl}", initialDelayString = "${initialDelay.setDefaultPosterUrl}")
    public void setDefaultPosterUrlOfAll() {
        serviceFacade.getSeasonService().setDefaultPosterUrlOfAll();
    }
    
    /**
     * 
     * 
     * @author caizhukui
     * @date 2017年6月10日
     */
    @Scheduled(cron = "${cron.addEpisode}")
    public void addEpisode() {
    	int pageSize = 50, pageIndex = 1;
		List<Season> seasons = null;
		do {
			seasons = serviceFacade.getSeasonService().getAllByPagination(pageSize, pageIndex++);
			for (Season season : seasons) {
				String seasonUuid = season.getUuid();
				List<Episode> episodes = serviceFacade.getEpisodeService().getBySeasonUuid(seasonUuid);
				if (CollectionUtils.isNotEmpty(episodes)) {
					Collections.sort(episodes);
					if (episodes.get(0).getEpisodeIndex() != 0) {
						Episode episode = new Episode();
						episode.setUuid(UuidUtils.getUuid());
						episode.setEpisodeIndex(0);
						episode.setEpisodeName("");
						episode.setSeasonUuid(seasonUuid);
						serviceFacade.getEpisodeService().add(episode);
					}
				}
			}
		} while (CollectionUtils.isNotEmpty(seasons));
    }
    
    /**
     * 检测subtitle_file表的file_name字段是否包含乱码
     * 
     * @author caizhukui
     * @date 2017年7月12日
     */
    @Scheduled(cron = "${cron.checkSubtitleFileMessyCode}")
    public void checkSubtitleFileMessyCode() {
    	int pageSize = 50, pageIndex = 1;
    	List<String> subtitleIds = new ArrayList<String>();
		List<Subtitle> subtitles = null;
		do {
			subtitles = serviceFacade.getSubtitleService().getAllByPagination(pageSize, pageIndex++);
			for (Subtitle subtitle : subtitles) {
				String subtitleUuid = subtitle.getUuid();
				List<SubtitleFile> subtitleFiles = serviceFacade.getSubtitleFileService().getBySubtitleUuid(subtitleUuid);
				if (CollectionUtils.isNotEmpty(subtitleFiles)) {
					for (SubtitleFile subtitleFile : subtitleFiles) {
						if (ChineseUtils.hasMessyCode(subtitleFile.getFileName())) {
							logger.info("检测到含有乱码的字幕文件 - subtitleUuid = {}", subtitleUuid);
							subtitleIds.add(subtitleUuid);
							break;
						}
					}
				}
			}
		} while (CollectionUtils.isNotEmpty(subtitles));
		logger.info("含有乱码的字幕文件 - subtitleIds = {}", subtitleIds);
    }

    /**
     * 
     * 
     * @author caizhukui
     * @date 2017年3月17日
     */
    @Scheduled(fixedRate = 3600000)
    public void reportCurrentTime() {
        logger.info("The time is now {}", DATE_FORMAT.format(new Date()));
    }
    
    /**
     * 
     * 
     * @author caizhukui
     * @date 2017年3月17日
     */
    @Scheduled(initialDelay = 5000, fixedRate = 43200000)
    public void driveTheChain() {
    	System.out.println("Starting up...      [Ok]");
		chainRunner.runChain("pingPongChain");
		System.out.println("Finised...          [Ok]");
    }

}
