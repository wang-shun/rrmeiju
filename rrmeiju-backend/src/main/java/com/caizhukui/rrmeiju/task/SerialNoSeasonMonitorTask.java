package com.caizhukui.rrmeiju.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.model.User;
import com.caizhukui.rrmeiju.service.CommonServiceFacade;
import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * 定时任务
 * 
 * @author caizhukui
 * @date 2017年3月3日
 */
//@Component
public class SerialNoSeasonMonitorTask implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(SerialNoSeasonMonitorTask.class);
	
	/**  */
	private static final char ST_START_DELIMITER = '$';
	
	/**  */
	private static final char ST_END_DELIMITER = '$';
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	@Autowired
	private CommonServiceFacade commonServiceFacade;
	
	/**
	 * 自动根据Serial的serialNameEnglish字段更新serialNameEpguides字段
	 * 
	 * @author caizhukui
	 * @date 2017年4月8日
	 */
	@Scheduled(fixedDelayString = "${fixedDelay.syncSerialNameEpguides}", initialDelayString = "${initialDelay.syncSerialNameEpguides}")
	public void syncSerialNameEpguides() {
		int pageSize = 50, pageIndex = 1;
		List<Serial> serials = null;
		do {
			serials = serviceFacade.getSerialService().getAllByPagination(pageSize, pageIndex++);
			for (Serial serial : serials) {
				String serialNameEnglish = serial.getEnglishName();
				String serialNameEpguides = serial.getEpguidesName();
				if (StringUtils.isBlank(serialNameEpguides)) {
					serialNameEpguides = convertSerialName(serialNameEnglish);
					serial.setEpguidesName(serialNameEpguides);
					logger.info("update serial - serialNameEnglish = {}, serialNameEpguides = {}", serialNameEnglish, serialNameEpguides);
					serviceFacade.getSerialService().updateByUuid(serial);
				}
			}
		} while (CollectionUtils.isNotEmpty(serials));
	}
	
	/**
	 * 检测没有季信息的系列，并发邮件通知管理员
	 * 
	 * @author caizhukui
	 * @date 2017年3月3日
	 */
	@Scheduled(cron = "${cron.serialNoSeasonMonitor}")
	public void serialNoSeasonMonitor() {
		int pageSize = 50, pageIndex = 1;
		List<Serial> serials = null;
		List<Serial> noSeasonSerials = new ArrayList<Serial>();
		do {
			serials = serviceFacade.getSerialService().getAllByPagination(pageSize, pageIndex++);
			for (Serial serial : serials) {
				int count = serviceFacade.getSeasonService().getCountBySerialUuid(serial.getUuid());
				if (count == 0) {
					noSeasonSerials.add(serial);
				}
			}
		} while (CollectionUtils.isNotEmpty(serials));
		if (CollectionUtils.isNotEmpty(noSeasonSerials)) {
			// 填充StringTemplate邮件模板，给管理员发邮件
			try {
				STGroup group = new STGroupFile("templates/email/serial-no-season.stg", ST_START_DELIMITER, ST_END_DELIMITER);
				ST st = group.getInstanceOf("serial-no-season");
				st.add("serials", noSeasonSerials);
				String text = st.render();
				commonServiceFacade.getEmailService().sendHtmlMail("ego_ecust@outlook.com", getAllAdminEmail(), "日日美剧 - 没有季的系列信息", text);
			} catch (Exception e) {
				logger.error("", e);
			}
		}
	}
	
	/**
	 * 检测没有集信息的季，并发邮件通知管理员
	 * 
	 * @author caizhukui
	 * @date 2017年3月3日
	 */
	@Scheduled(cron = "${cron.seasonNoEpisodeMonitor}")
	public void seasonNoEpisodeMonitor() {
		int pageSize = 50, pageIndex = 1;
		List<Season> seasons = null;
		List<Season> noEpisodeSeasons = new ArrayList<Season>();
		do {
			seasons = serviceFacade.getSeasonService().getAllByPagination(pageSize, pageIndex++);
			for (Season season : seasons) {
				int count = serviceFacade.getEpisodeService().getCountBySeasonUuid(season.getUuid());
				if (count == 0) {
					noEpisodeSeasons.add(season);
				}
			}
		} while (CollectionUtils.isNotEmpty(seasons));
		if (CollectionUtils.isNotEmpty(noEpisodeSeasons)) {
			// 填充StringTemplate邮件模板，给管理员发邮件
			try {
				STGroup group = new STGroupFile("templates/email/season-no-episode.stg", ST_START_DELIMITER, ST_END_DELIMITER);
				ST st = group.getInstanceOf("season-no-episode");
				st.add("seasons", noEpisodeSeasons);
				String text = st.render();
				commonServiceFacade.getEmailService().sendHtmlMail("ego_ecust@outlook.com", getAllAdminEmail(), "日日美剧 - 没有集的季信息", text);
			} catch (Exception e) {
				logger.error("{}", e);
			}
		}
	}
	
	/**
	 * 把serialNameEnglish转换成serialNameEpguides
	 * 
	 * @param serialNameEnglish 系列英文名
	 * @return String 系列在Epguides网站的URL中的英文名
	 * @author caizhukui
	 * @date 2017年4月8日
	 */
	private String convertSerialName(String serialNameEnglish) {
		String serialNameEpguides = serialNameEnglish;
		// 去除剧集名开头的冠词
		String[] articles = new String[] { "The", "A", "An" };
		for (String article : articles) {
			String articlePrefix = article + " ";
			if (serialNameEpguides.startsWith(articlePrefix)) {
				serialNameEpguides = serialNameEpguides.substring(articlePrefix.length());
				break;
			}
		}
		// 去除空格和特殊字符，并把&替换为and
		serialNameEpguides = serialNameEpguides.replaceAll(" ", "")
				.replaceAll("\\.", "")
				.replaceAll("'", "")
				.replaceAll("-", "")
				.replaceAll(":", "")
				.replaceAll("/", "")
				.replaceAll(",", "")
				.replaceAll("&", "and");
		return serialNameEpguides;
	}
	
	/**
	 * 获取所有管理员的邮箱
	 * 
	 * @return String[] 所有管理员的邮箱
	 * @author caizhukui
	 * @date 2017年4月12日
	 */
	private String[] getAllAdminEmail() {
		List<String> emails = new ArrayList<String>();
		List<User> users = serviceFacade.getUserService().getAllAdmin();
		for (User user : users) {
			String email = user.getEmail();
			if (StringUtils.isNotBlank(email)) {
				emails.add(email);
			}
		}
		return emails.toArray(new String[0]);
	}

}
