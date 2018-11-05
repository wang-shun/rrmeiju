package com.caizhukui.rrmeiju.task;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.bo.IpLocation;
import com.caizhukui.rrmeiju.model.Ip;
import com.caizhukui.rrmeiju.service.CommonServiceFacade;
import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月6日
 */
@Component
public class RetrieveIpInfoTask implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(RetrieveIpInfoTask.class);
	
	@Autowired
	private CommonServiceFacade commonServiceFacade;
	
	@Autowired
	private ServiceFacade serviceFacade;
	
	/**
	 * 根据IP调用第三方接口获取IP信息（所属地、运营商等）
	 * 
	 * @throws IOException
	 * @author caizhukui
	 * @date 2017年6月8日
	 */
	@Scheduled(fixedDelayString = "${fixedDelay.retrieveIpInfo}", initialDelayString = "${initialDelay.retrieveIpInfo}")
	public void retrieveIpInfo() throws IOException {
		Set<String> subtitleDownloadIps = serviceFacade.getSubtitleDownloadService().getAllIps();
		Set<String> indexSearchRecordIps = serviceFacade.getIndexSearchRecordService().getAllIps();
		Set<String> ips = new HashSet<String>();
		ips.addAll(subtitleDownloadIps);
		ips.addAll(indexSearchRecordIps);
		for (String ip : ips) {
			if (commonServiceFacade.getIpService().getByIp(ip) == null) {
				IpLocation ipLocation = commonServiceFacade.getIpService().getLocationByIp(ip);
				logger.info("retrieveIpInfo - ipLocation = {}", ipLocation);
				commonServiceFacade.getIpService().add(ipLocation.convert());
			}
		}
	}
	
	/**
	 * 更新IP地址信息
	 * 
	 * @throws IOException
	 * @author caizhukui
	 * @date 2017年8月9日
	 */
	@Scheduled(fixedDelayString = "${fixedDelay.updateIpInfo}", initialDelayString = "${initialDelay.updateIpInfo}")
	public void updateIpInfo() throws IOException {
		int pageSize = 50, pageIndex = 1;
		List<Ip> ips = null;
		do {
			ips = commonServiceFacade.getIpService().getAllByPagination(pageSize, pageIndex++);
			for (Ip ip : ips) {
				String operator = ip.getOperator();
				if (StringUtils.equals(ip.getCountry(), "中国") && 
						(operator == null || StringUtils.equals(operator, "未知"))) {
					logger.info("更新前IP地址信息：{}", ip);
					IpLocation ipLocation = commonServiceFacade.getIpService().getLocationByIp(ip.getIp());
					logger.info("retrieveIpInfo - ipLocation = {}", ipLocation);
					operator = ipLocation.getOperator();
					if (operator != null && !StringUtils.equals(operator, "未知")) {
						ip.setProvince(ipLocation.getProvince());
						ip.setCity(ipLocation.getCity());
						ip.setOperator(ipLocation.getOperator());
						logger.info("更新后IP地址信息：{}", ip);
						commonServiceFacade.getIpService().updateByUuid(ip);
					}
				}
			}
		} while (CollectionUtils.isNotEmpty(ips));
	}

}
