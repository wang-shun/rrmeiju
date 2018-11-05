package com.caizhukui.rrmeiju.task;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年1月18日
 */
//@Component
public class CompleteEpisodeDataTask implements ScheduledTask {

    private static final Logger logger = LoggerFactory.getLogger(CompleteEpisodeDataTask.class);
    
    @Autowired
    private ServiceFacade serviceFacade;
    
    @Scheduled(cron = "${cron.completeEpisodeData}")
    public void completeEpisodeData() throws Exception {
        int pageSize = 50, pageIndex = 1;
        List<Serial> serials = null;
        do {
            serials = serviceFacade.getSerialService().getAllByPagination(pageSize, pageIndex++);
            for (Serial serial : serials) {
                Integer tvmazeId = serial.getTvmazeId();
                if (tvmazeId == null) {
                    continue;
                }
                List<Season> seasons = serviceFacade.getSeasonService().getBySerialUuid(serial.getUuid());
                if (CollectionUtils.isEmpty(seasons)) {
                    continue;
                }
                for (Season season : seasons) {
                    Integer seasonIndex = season.getSeasonIndex();
                    List<Episode> episodes = serviceFacade.getEpisodeService().getBySeasonUuid(season.getUuid());
                    if (CollectionUtils.isEmpty(episodes)) {
                        continue;
                    }
                    for (Episode episode : episodes) {
                        episode.setTvmazeShowId(tvmazeId);
                        episode.setSeasonIndex(seasonIndex);
                        logger.info("completeEpisodeData - id = {}", episode.getId());
                        serviceFacade.getEpisodeService().updateByUuid(episode);
                    }
                }
            }
        } while (CollectionUtils.isNotEmpty(serials));
    }
    
}
