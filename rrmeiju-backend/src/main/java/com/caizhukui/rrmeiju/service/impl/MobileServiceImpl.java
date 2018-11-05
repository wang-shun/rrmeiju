package com.caizhukui.rrmeiju.service.impl;

import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.service.MobileService;
import com.caizhukui.rrmeiju.thirdparty.juhe.MobileNumber;
import com.caizhukui.rrmeiju.thirdparty.juhe.MobileNumberResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月21日
 */
@Service
public class MobileServiceImpl implements MobileService {
	
	private static final Logger logger = LoggerFactory.getLogger(MobileServiceImpl.class);
	
	/** 调用聚合数据手机号码归属地接口的AppKey */
	private static final String APP_KEY = "2f10eefd42bbe5a8c5847910be08c886";

	@Override
	public MobileNumber getInfoByMobile(String phone) {
		MobileNumber mobileNumber = null;
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			URI uri = new URIBuilder()    
			        .setScheme("http")    
			        .setHost("apis.juhe.cn")    
			        .setPath("/mobile/get")
			        .setParameter("phone", phone)
			        .setParameter("key", APP_KEY)
			        .build();
			HttpGet httpGet = new HttpGet(uri);
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			String strResult = EntityUtils.toString(httpEntity);
			httpResponse.close();
			httpClient.close();
			ObjectMapper mapper = new ObjectMapper();
			MobileNumberResponse response = mapper.readValue(strResult, MobileNumberResponse.class);
			mobileNumber = response.getResult();
			mobileNumber.setPhone(phone);
		} catch (Exception e) {
			logger.error("", e);
		}
		return mobileNumber;
	}
	
	

}
