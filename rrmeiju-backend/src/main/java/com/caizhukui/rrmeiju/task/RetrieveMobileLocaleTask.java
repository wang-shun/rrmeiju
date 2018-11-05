package com.caizhukui.rrmeiju.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.model.MobileLocale;
import com.caizhukui.rrmeiju.service.CommonServiceFacade;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年7月3日
 */
//@Component
public class RetrieveMobileLocaleTask implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(RetrieveMobileLocaleTask.class);
	
	@Autowired
	private CommonServiceFacade commonServiceFacade;
	
	/**
	 * 获取手机号码段信息<br>
	 * 移动号段：134 135 136 137 138 139 147 150 151 152 157 158 159 172 178 182 183 184 187 188 198<br>
	 * 联通号段：130 131 132 145 155 156 166 171 175 176 185 186<br>
	 * 电信号段：133 149 153 173 177 180 181 189 199<br>
	 * 虚拟运营商号段：170
	 * 
	 * @throws IOException
	 * @author caizhukui
	 * @date 2017年7月3日下午4:38:42
	 */
	//@Scheduled(cron = "${cron.retrieveMobileLocale}")
	public void retrieveMobileLocale() throws IOException {
		List<Integer> mobileSegments = new ArrayList<Integer>();
		mobileSegments.add(1660000);
		for (int mobileSegmentMin : mobileSegments) {
			int mobileSegmentMax = 1669999;// mobileSegmentMin + 9999;
			for (int i = mobileSegmentMin; i <= mobileSegmentMax; i++) {
				logger.info("当前查询号段：{}", i);
				String mobileSegment = String.valueOf(i);
				Document document = getDocumentFromIp138(mobileSegment);
				if (document == null) {
					try {
						Thread.sleep(10000); // 10秒后重试一次
					} catch (InterruptedException e) {
						logger.error("", e);
					} 
					document = getDocumentFromIp138(mobileSegment);
				}
				MobileLocale mobileLocale = parseDocument(document);
				if (mobileLocale != null) {
					String mobileArea = mobileLocale.getMobileArea();
					if (StringUtils.isNotBlank(mobileArea) && !"未知".equals(mobileArea.trim())) {
						mobileLocale.setMobileSegment(mobileSegment);
						commonServiceFacade.getMobileLocaleService().add(mobileLocale);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @param mobileSegment
	 * @return Document
	 * @author caizhukui
	 * @date 2017年7月3日下午5:15:08
	 */
	private Document getDocumentFromIp138(String mobileSegment) {
		final String BASE_URI = "http://www.ip138.com:8080/search.asp";
		Document document = null;
		try {
			String url = BASE_URI + "?mobile=" + mobileSegment + "&action=mobile";
			Connection connection = Jsoup.connect(url);
			document = connection.get();
		} catch (Exception e) {
			logger.error("获取手机号码段{}信息出错，跳过，错误信息：{}", mobileSegment, e.getMessage());
		}
		return document;
	}
	
	/**
	 * 解析HTML文档获取手机号段归属地信息
	 * 
	 * @param document HTML文档
	 * @return MobileLocale 手机号段归属地信息
	 * @author caizhukui
	 * @date 2017年7月3日下午5:15:14
	 */
	private MobileLocale parseDocument(Document document) {
		if (document == null) return null;
		MobileLocale mobileLocale = null;
		Elements tables = document.getElementsByTag("table");
		if (tables.size() == 2) {
			mobileLocale = new MobileLocale();
			Element table = tables.get(1);
			Elements trs = table.getElementsByTag("tr");
			String mobileArea = trs.get(2).getElementsByTag("td").get(1).text().trim();
			if (mobileArea.endsWith(" ")) {
				mobileArea = mobileArea.substring(0, mobileArea.length() - 1);
			}
			String mobileType = trs.get(3).getElementsByTag("td").get(1).text().trim();
			String areaCode = trs.get(4).getElementsByTag("td").get(1).text().trim();
			String postCode = trs.get(5).getElementsByTag("td").get(1).text().trim();
			if (postCode.length() >= 6) {
				postCode = postCode.substring(0, 6);
			}
			mobileLocale.setMobileArea(mobileArea);
			mobileLocale.setMobileType(mobileType);
			mobileLocale.setAreaCode(areaCode);
			mobileLocale.setPostCode(postCode);
		}
		return mobileLocale;
	}

}
