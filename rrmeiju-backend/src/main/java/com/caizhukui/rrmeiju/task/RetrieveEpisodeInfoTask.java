package com.caizhukui.rrmeiju.task;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.common.util.FileUtils;
import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * Retrieve Episode Info Task
 * 
 * @author caizhukui
 * @date 2017/1/13
 */
@Component
@PropertySource("classpath:properties/config.properties")
public class RetrieveEpisodeInfoTask implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(RetrieveEpisodeInfoTask.class);
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	@Value("${retrieveEpisodeInfo.localSavePath}")
	private String localSavePath;
	
	/**
	 * 定时任务获取每集标题<br>
	 * fixedDelay - 等上一次运行结束才开始下一次运行<br>
	 * fixedRate - 不等上一次运行结束就开始下一次运行
	 * 
	 * @throws IOException 
	 * @author caizhukui
	 * @date 2017年1月13日
	 */
	@Scheduled(cron = "${cron.retrieveEpisodeInfo}")
	public void retrieveEpisodeInfo() throws IOException {
		Files.deleteIfExists(Paths.get(localSavePath));
		List<String> allInsertScripts = serviceFacade.getEpguidesService().getInsertScriptsOfAll();
		FileUtils.appendToFile(allInsertScripts, localSavePath);
			/*int seasonIndex = 1, episodeIndex = 1;
			List<Episode> episodes = new ArrayList<Episode>();
			for (List<String> episodeNamesBySeason : episodeNames) {
				for (String episodeName : episodeNamesBySeason) {
					Episode episode = new Episode();
					episode.setEpisodeIndex(episodeIndex++);
					episode.setEpisodeName(episodeName);
					episode.setSeasonId(seasons.get(seasonIndex - 1).getSeasonId());
					episodes.add(episode);
				}
				if (seasonIndex++ == seasons.size()) {
					break;
				}
				episodeIndex = 1;
			}
			serviceFacade.getEpisodeService().batchAdd(episodes);*/
	}

}
