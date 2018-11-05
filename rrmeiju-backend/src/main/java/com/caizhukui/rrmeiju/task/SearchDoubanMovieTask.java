package com.caizhukui.rrmeiju.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.douban.DoubanCastDTO;
import com.caizhukui.rrmeiju.dto.douban.DoubanDirectorDTO;
import com.caizhukui.rrmeiju.dto.douban.DoubanSubjectDTO;
import com.caizhukui.rrmeiju.dto.douban.response.DoubanGetMovieDTO;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017/5/5
 */
//@Component
public class SearchDoubanMovieTask implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchDoubanMovieTask.class);
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	/**
	 * 根据剧集名调用豆瓣接口获取豆瓣数据
	 * 
	 * @author caizhukui
	 * @throws RestControllerException 
	 * @date 2017/5/5
	 */
	@Scheduled(cron = "${cron.searchDoubanMovie}")
	public void searchDoubanMovie() throws RestControllerException {
		int pageSize = 40, pageIndex = 1;
		List<Season> seasons = null;
		// 豆瓣接口限定最多40次请求/分钟，每次最多处理1条数据，然后等待30秒
		do {
			seasons = serviceFacade.getSeasonService().getAllByPagination(pageSize, pageIndex++);
			for (Season season : seasons) {
				if (StringUtils.isBlank(season.getDoubanId())) {
					String seasonNameChinese = season.getChineseName();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(season.getPremiereDate());
					String seasonYear = String.valueOf(calendar.get(Calendar.YEAR));
					try {
						// 根据中文季名来查，比如说“越狱 第一季”
						List<DoubanSubjectDTO> subjects = serviceFacade.getDoubanService().searchMovie(seasonNameChinese);
						// 返回结果空，再尝试根据中文系列名来查
						if (CollectionUtils.isEmpty(subjects)) {
							int endIndex = seasonNameChinese.lastIndexOf(' ');
							if (endIndex > 0) {
								String serialNameChinese = seasonNameChinese.substring(0, endIndex);
								// 根据中文系列名来查，比如说“越狱”
								subjects = serviceFacade.getDoubanService().searchMovie(serialNameChinese);
							}
						}
						// 返回结果空，再尝试根据英文系列名来查
						if (CollectionUtils.isEmpty(subjects)) {
							String seasonNameEnglish = season.getEnglishName();
							int endIndex = seasonNameEnglish.lastIndexOf(':');
							if (endIndex > 0) {
								String serialNameEnglish = seasonNameEnglish.substring(0, endIndex);
								// 根据英文系列名来查，比如说“Prison Break”
								subjects = serviceFacade.getDoubanService().searchMovie(serialNameEnglish);
							}
						}
						List<DoubanSubjectDTO> accurateSubjects = new ArrayList<DoubanSubjectDTO>();
						if (CollectionUtils.isNotEmpty(subjects)) {
							if (subjects.size() == 1) {
								accurateSubjects = subjects;
							// 返回多个结果时根据类型和年份来匹配
							} else {
								for (DoubanSubjectDTO subject : subjects) {
									String subtype = subject.getSubtype();
									String year = subject.getYear();
									if ("tv".equals(subtype) && seasonYear.equals(year)) {
										accurateSubjects.add(subject);
									}
								}
							}
							// 只有一个精确匹配结果时才更新
							if (accurateSubjects.size() == 1) {
								String doubanId = accurateSubjects.get(0).getId();
								season.setDoubanId(doubanId);
								logger.info("更新 {} 的豆瓣ID - doubanId = {}", seasonNameChinese, doubanId);
								serviceFacade.getSeasonService().updateByUuid(season);
							} else {
								logger.info("{} 有多个搜索结果", seasonNameChinese);
								logger.info("{}", accurateSubjects);
							}
						}
						// 等待30秒
						try {
							Thread.sleep(30 * 1000);
						} catch (InterruptedException e) {
							logger.error("InterruptedException", e);
						}
					// 接口调用受到限制，等待10分钟后继续运行
					} catch (Exception e) {
						logger.error("调用豆瓣接口异常", e);
						try {
							Thread.sleep(10 * 60 * 1000);
						} catch (InterruptedException ie) {
							logger.error("InterruptedException", ie);
						}
					}
				}
			}
		} while (CollectionUtils.isNotEmpty(seasons));
	}
	
	/**
	 * 根据豆瓣ID调用豆瓣接口获取豆瓣数据
	 * 
	 * @throws RestControllerException
	 * @author caizhukui
	 * @date 2017/5/9
	 */
	@Scheduled(cron = "${cron.getDoubanMovie}")
	public void getDoubanMovie() throws RestControllerException {
		int pageSize = 40, pageIndex = 1;
		List<Season> seasons = null;
		// 豆瓣接口限定最多40次请求/分钟，每次最多处理1条数据，然后等待30秒
		do {
			seasons = serviceFacade.getSeasonService().getAllByPagination(pageSize, pageIndex++);
			for (Season season : seasons) {
				String doubanId = season.getDoubanId();
				if (StringUtils.isNotBlank(doubanId)) {
					try {
						DoubanGetMovieDTO subject = serviceFacade.getDoubanService().getMovie(doubanId);
						season.setDoubanRating(subject.getRating().getAverage()); // 豆瓣评分
						if (StringUtils.isBlank(season.getDoubanUrl())) {
							season.setSummary(subject.getSummary()); // 简介
							season.setDoubanUrl(subject.getAlt()); // 豆瓣条目页URL
							List<DoubanDirectorDTO> directors = subject.getDirectors();
							// 导演
							StringBuffer sb = new StringBuffer();
							if (CollectionUtils.isNotEmpty(directors)) {
								for (DoubanDirectorDTO director : directors) {
									sb.append(director.getName());
									sb.append(",");
								}
								sb.deleteCharAt(sb.length() - 1);
							}
							season.setDirectors(sb.toString());
							// 主演
							sb.setLength(0);
							List<DoubanCastDTO> casts = subject.getCasts();
							if (CollectionUtils.isNotEmpty(casts)) {
								for (DoubanCastDTO cast : casts) {
									sb.append(cast.getName());
									sb.append(",");
								}
								sb.deleteCharAt(sb.length() - 1);
							}
							season.setCasts(sb.toString());
							// 制片国家/地区
							sb.setLength(0);
							List<String> countries = subject.getCountries();
							if (CollectionUtils.isNotEmpty(countries)) {
								for (String country : countries) {
									sb.append(country);
									sb.append(",");
								}
								sb.deleteCharAt(sb.length() - 1);
							}
							season.setCountries(sb.toString());
							// 类型
							sb.setLength(0);
							List<String> genres = subject.getGenres();
							if (CollectionUtils.isNotEmpty(genres)) {
								for (String genre : genres) {
									sb.append(genre);
									sb.append(",");
								}
								sb.deleteCharAt(sb.length() - 1);
							}
							season.setGenres(sb.toString());
							logger.info("更新 {} 的全部豆瓣信息", season.getChineseName());
						} else {
							logger.info("更新 {} 的豆瓣评分", season.getChineseName());
						}
						serviceFacade.getSeasonService().updateByUuid(season);
						// 等待30秒
						try {
							Thread.sleep(30 * 1000);
						} catch (InterruptedException ignore) {
							logger.error("线程等待被中断", ignore);
						}
					// 接口调用受到限制，等待10分钟后继续运行
					} catch (Exception e) {
						logger.error("调用豆瓣接口异常", e);
						try {
							Thread.sleep(1 * 60 * 1000);
						} catch (InterruptedException ignore) {
							logger.error("线程等待被中断", ignore);
						}
					}
				}
			}
		} while (CollectionUtils.isNotEmpty(seasons));
	}

}
