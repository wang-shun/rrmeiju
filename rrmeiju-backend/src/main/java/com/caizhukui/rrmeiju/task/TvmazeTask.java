package com.caizhukui.rrmeiju.task;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.common.enums.WeekEnum;
import com.caizhukui.common.util.CollectionUtils;
import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.service.ServiceFacade;
import com.caizhukui.rrmeiju.tvmaze.dto.ExternalDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeCountryDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeEpisodeDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeImageDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeNetworkDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeRatingDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeScheduleDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeShowDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeWebChannelDTO;
import com.caizhukui.rrmeiju.tvmaze.enums.TvmazeShowGenresEnum;
import com.caizhukui.rrmeiju.tvmaze.enums.TvmazeShowStatusEnum;
import com.caizhukui.rrmeiju.tvmaze.enums.TvmazeShowTypeEnum;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年1月2日
 */
//@Component
public class TvmazeTask implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(TvmazeTask.class);
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	@Scheduled(cron = "${cron.tvmaze.episodebynumber}")
    public void episodeByNumber() throws Exception {
        int pageSize = 50, pageIndex = 1;
        List<Episode> episodes = null;
        do {
            episodes = serviceFacade.getEpisodeService().getAllByPagination(pageSize, pageIndex++);
            for (Episode episode : episodes) {
                Integer tvmazeShowId = episode.getTvmazeShowId();
                Integer seasonIndex = episode.getSeasonIndex();
                Integer episodeIndex = episode.getEpisodeIndex();
                if (tvmazeShowId == null || seasonIndex == null || episodeIndex == null
                        || seasonIndex <= 0 || episodeIndex <= 0) {
                    continue;
                }
                TvmazeEpisodeDTO tvmazeEpisodeDTO = null;
                try {
                    tvmazeEpisodeDTO = serviceFacade.getTvmazeService().episodeByNumber(tvmazeShowId, seasonIndex, episodeIndex);
                } catch (Exception e) {
                    logger.error("", e);
                }
                if (tvmazeEpisodeDTO == null) {
                    continue;
                }
                episode.setAirTime(tvmazeEpisodeDTO.getAirTime());
                episode.setAirStamp(tvmazeEpisodeDTO.getAirStamp());
                if (episode.getAirDate() == null) {
                    episode.setAirDate(tvmazeEpisodeDTO.getAirDate());
                }
                episode.setEnglishSummary(tvmazeEpisodeDTO.getSummary());
                episode.setTvmazeUrl(tvmazeEpisodeDTO.getUrl());
                episode.setRuntime(tvmazeEpisodeDTO.getRuntime());
                if (episode.getEpisodeName() == null) {
                    episode.setEpisodeName(tvmazeEpisodeDTO.getName());
                }
                episode.setGmtModified(new Date());
                serviceFacade.getEpisodeService().updateByUuid(episode);
            }
        } while (CollectionUtils.isNotEmpty(episodes));
	}
	
	@Scheduled(cron = "${cron.tvmaze.episodes}")
	public void episodes() throws Exception {
	    int pageSize = 50, pageIndex = 1;
        List<Serial> serials = null;
        do {
            serials = serviceFacade.getSerialService().getAllByPagination(pageSize, pageIndex++);
            for (Serial serial : serials) {
                Integer tvmazeId = serial.getTvmazeId();
                if (tvmazeId == null) {
                    continue;
                }
                List<TvmazeEpisodeDTO> tvmazeEpisodeDTOs = null;
                try {
                    tvmazeEpisodeDTOs = serviceFacade.getTvmazeService().showEpisodeList(tvmazeId);
                } catch (Exception e) {
                    logger.error("", e);
                }
                if (CollectionUtils.isEmpty(tvmazeEpisodeDTOs)) {
                    continue;
                }
                for (TvmazeEpisodeDTO tvmazeEpisodeDTO : tvmazeEpisodeDTOs) {
                    tvmazeEpisodeDTO.getAirDate();
                    tvmazeEpisodeDTO.getAirStamp();
                    tvmazeEpisodeDTO.getAirTime();
                    tvmazeEpisodeDTO.getRuntime();
                    tvmazeEpisodeDTO.getSeason();
                    tvmazeEpisodeDTO.getNumber();
                    tvmazeEpisodeDTO.getSummary();
                    tvmazeEpisodeDTO.getUrl();
                    tvmazeEpisodeDTO.getName();
                }
            }
        } while (CollectionUtils.isNotEmpty(serials));
	}
	
	@Scheduled(cron = "${cron.tvmaze.showSingleSearch}")
    public void showSingleSearch() throws Exception {
	    int pageSize = 50, pageIndex = 1;
        List<Serial> serials = null;
	    do {
            serials = serviceFacade.getSerialService().getAllByPagination(pageSize, pageIndex++);
            for (Serial serial : serials) {
                TvmazeShowDTO tvmazeShowDTO = null;
                try {
                    tvmazeShowDTO = serviceFacade.getTvmazeService().showSingleSearch(serial.getEnglishName());
                } catch (Exception e) {
                    logger.error("", e);
                }
                if (tvmazeShowDTO == null) {
                    continue;
                }
                // 传统电视台
                TvmazeNetworkDTO tvmazeNetworkDTO = tvmazeShowDTO.getNetwork();
                if (tvmazeNetworkDTO != null) {
                    TvmazeCountryDTO tvmazeCountryDTO = tvmazeNetworkDTO.getCountry();
                    Integer tvmazeNetworkId = tvmazeNetworkDTO.getId();
                    String networkName = tvmazeNetworkDTO.getName();
                }
                // 流媒体
                TvmazeWebChannelDTO tvmazeWebChannelDTO = tvmazeShowDTO.getWebChannel();
                if (tvmazeWebChannelDTO != null) {
                    TvmazeCountryDTO tvmazeCountryDTO = tvmazeWebChannelDTO.getCountry();
                    Integer tvmazeWebChannelId = tvmazeWebChannelDTO.getId();
                    String webChannelName = tvmazeWebChannelDTO.getName();
                }
                // 电视剧信息
                serial.setOriginalName(serial.getEnglishName());
                serial.setOfficialSiteUrl(tvmazeShowDTO.getOfficialSite());
                serial.setEnglishSummary(tvmazeShowDTO.getSummary());
                serial.setLanguage(tvmazeShowDTO.getLanguage());
                String englishType = tvmazeShowDTO.getType();
                serial.setEnglishType(englishType);
                serial.setChineseType(TvmazeShowTypeEnum.getChineseByEnglish(englishType));
                String englishStatus = tvmazeShowDTO.getStatus();
                serial.setEnglishStatus(englishStatus);
                serial.setChineseStatus(TvmazeShowStatusEnum.getChineseByEnglish(englishStatus));
                List<String> englishGenres = tvmazeShowDTO.getGenres();
                if (CollectionUtils.isNotEmpty(englishGenres)) {
                    StringBuffer sb1 = new StringBuffer();
                    StringBuffer sb2 = new StringBuffer();
                    for (String englishGenre : englishGenres) {
                        sb1.append(englishGenre);
                        sb1.append(",");
                        sb2.append(TvmazeShowGenresEnum.getChineseByEnglish(englishGenre));
                        sb2.append(",");
                    }
                    String englishGenresStr = sb1.toString();
                    englishGenresStr = englishGenresStr.substring(0, englishGenresStr.length() - 1);
                    String chineseGenresStr = sb2.toString();
                    chineseGenresStr = chineseGenresStr.substring(0, chineseGenresStr.length() - 1);
                    serial.setEnglishGenres(englishGenresStr);
                    serial.setChineseGenres(chineseGenresStr);
                }
                TvmazeScheduleDTO tvmazeScheduleDTO = tvmazeShowDTO.getSchedule();
                if (tvmazeScheduleDTO != null) {
                    List<String> scheduleDays = tvmazeScheduleDTO.getDays();
                    if (CollectionUtils.isNotEmpty(scheduleDays)) {
                        StringBuffer sb = new StringBuffer();
                        for (String scheduleDay : scheduleDays) {
                            sb.append(WeekEnum.getIndexByEnglish(scheduleDay));
                            sb.append(",");
                        }
                        String scheduleDaysStr = sb.toString();
                        scheduleDaysStr = scheduleDaysStr.substring(0, scheduleDaysStr.length() - 1);
                        serial.setScheduleDays(scheduleDaysStr);
                    }
                    serial.setScheduleTime(tvmazeScheduleDTO.getTime());
                }
                ExternalDTO externalDTO = tvmazeShowDTO.getExternals();
                if (externalDTO != null) {
                    serial.setImdbId(externalDTO.getImdb());
                    serial.setThetvdbId(externalDTO.getThetvdb());
                    serial.setTvrageId(externalDTO.getTvrage());
                }
                TvmazeRatingDTO tvmazeRatingDTO = tvmazeShowDTO.getRating();
                if (tvmazeRatingDTO != null) {
                    serial.setTvmazeAverageRating(tvmazeRatingDTO.getAverage());
                }
                TvmazeImageDTO tvmazeImageDTO = tvmazeShowDTO.getImage();
                if (tvmazeImageDTO != null) {
                    serial.setTvmazeMediumImageUrl(tvmazeImageDTO.getMedium());
                    serial.setTvmazeOriginalImageUrl(tvmazeImageDTO.getOriginal());
                }
                serial.setPremiereDate(tvmazeShowDTO.getPremiered());
                serial.setTvmazeId(tvmazeShowDTO.getId());
                serial.setTvmazeUrl(tvmazeShowDTO.getUrl());
                serial.setTvmazeWeight(tvmazeShowDTO.getWeight());
                serial.setTvmazeUpdatedTimestamp(tvmazeShowDTO.getUpdated());
                serial.setRuntime(tvmazeShowDTO.getRuntime());
                serial.setGmtModified(new Date());
                serviceFacade.getSerialService().updateByUuid(serial);
            }
	    } while (CollectionUtils.isNotEmpty(serials));
	}
	
	

}
