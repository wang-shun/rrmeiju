package com.caizhukui.rrmeiju.task;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
 * @date 2017年6月6日
 */
//@Component
public class RetrieveEpisodeAirDateTask implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(RetrieveEpisodeAirDateTask.class);
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	/**
	 * 获取每集美剧的首播日期
	 * 
	 * @throws IOException
	 * @author caizhukui
	 * @date 2017/6/10
	 */
	@Scheduled(cron = "${cron.retrieveEpisodeAirDate}")
	public void retrieveEpisodeAirDate() throws IOException {
		int pageSize = 50, pageIndex = 1;
		List<Serial> serials = null;
		do {
			serials = serviceFacade.getSerialService().getAllByPagination(pageSize, pageIndex++);
			for (Serial serial : serials) {
				String serialUuid = serial.getUuid();
				List<Season> seasons = serviceFacade.getSeasonService().getBySerialUuid(serialUuid);
				if (CollectionUtils.isNotEmpty(seasons)) {
					logger.info("当前SerialNameChinese为：{}", serial.getChineseName());
					String serialNameEpguides = serial.getEpguidesName();
					Document document = getDocument(serialNameEpguides);
					List<List<Date>> airDates = getEpisodeAirDatesBySerialNameEnglish(document);
					List<Episode> episodes = generateEpisodes(airDates, seasons);
					if (CollectionUtils.isNotEmpty(episodes)) {
						serviceFacade.getEpisodeService().batchUpdateByUuid(episodes);
					}
				}
			}
		} while (CollectionUtils.isNotEmpty(serials));
	}
	
	/**
	 * 获取Document
	 * 
	 * @param serialNameEpguides
	 * @return Document
	 * @author caizhukui
	 * @date 2017年2月8日
	 */
	private Document getDocument(String serialNameEpguides) {
		final String BASE_URI = "http://epguides.com/";
		Document document = null;
		try {
			String url = BASE_URI + serialNameEpguides + "/";
			logger.info("请求URL为：{}", url);
			Connection connection = Jsoup.connect(url);
			document = connection.get();
		} catch (Exception e) {
			logger.error("获取{}出错，跳过，错误信息：{}", serialNameEpguides, e);
		}
		return document;
	}
	
	/**
	 * 解析Document，提取出首播日期的列表
	 * 
	 * @param document
	 * @return List<Episode>
	 * @author caizhukui
	 * @date 2017年6月6日
	 */
	private List<List<Date>> getEpisodeAirDatesBySerialNameEnglish(Document document) {
		if (document == null) return null;
		List<List<Date>> airDates = new ArrayList<List<Date>>();
		Element content = document.getElementById("eplist");
		String all = content.getElementsByTag("pre").first().text();
		// logger.info("{}", all);
		int currentSeasonIndex = 1, seasonIndex = 1;
		List<Date> airDatesOfSeason = new ArrayList<Date>();
		if (StringUtils.isNoneBlank(all)) {
			String[] parts = all.split("\n");
			for (String part : parts) {
				if (StringUtils.isNoneBlank(part)) {
					String[] params = part.split("\\s{3,}");
					if (params.length == 4) {
						String id = params[0].trim();
						if (id.endsWith(".") && !id.startsWith("S")) {
							String indexStr = params[1].trim();
							String[] indexes = indexStr.split("-");
							seasonIndex = Integer.valueOf(indexes[0]);
							if (seasonIndex != currentSeasonIndex) {
								airDates.add(airDatesOfSeason);
								airDatesOfSeason = new ArrayList<Date>();
								currentSeasonIndex = seasonIndex;
							}
							String airDateStr = params[2].trim();
							airDatesOfSeason.add(convertAirDate(airDateStr));
						}
					}
				}
			}
			airDates.add(airDatesOfSeason);
		}
		return airDates;
	}
	
	/**
	 * 
	 * 
	 * @param airDates
	 * @param seasons
	 * @return List<Episode>
	 * @author caizhukui
	 * @date 2017年6月6日
	 */
	private List<Episode> generateEpisodes(List<List<Date>> airDates, List<Season> seasons) {
		if (airDates == null || seasons == null) {
			logger.info("{} 数据不对", seasons.get(0).getChineseName());
			return null;
		}
		List<Episode> episodes = new ArrayList<Episode>();
		for (Season season : seasons) {
			String seasonUuid = season.getUuid();
			int seasonIndex = season.getSeasonIndex();
			if (seasonIndex > 0 && seasonIndex <= airDates.size()) { // 有可能出现数据库里的季数比从epguides页面上获取到的季数多的情况
				List<Date> airDatesBySeason = airDates.get(seasonIndex - 1);
				for (int i = 0; i < airDatesBySeason.size(); i++) {
					Episode episode = serviceFacade.getEpisodeService().getBySeasonUuidAndEpisodeIndex(seasonUuid, i+1);
					if (episode != null) {
						Date airDate = airDatesBySeason.get(i);
						episode.setAirDate(airDate);
						episodes.add(episode);
					}
				}
			}
		}
		return episodes;
	}
	
	/**
	 * 把首播日期从String转换成Date
	 * 
	 * @param airDateStr
	 * @return Date
	 * @author caizhukui
	 * @date 2017年6月6日
	 */
	private Date convertAirDate(String airDateStr) {
		Date airDate = null;
		try {
			airDate = new SimpleDateFormat("dd MMM yy", Locale.ENGLISH).parse(airDateStr);
		} catch (ParseException ignore) {}
		return airDate;
	}

}
