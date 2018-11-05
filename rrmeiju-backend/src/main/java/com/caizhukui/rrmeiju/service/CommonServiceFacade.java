package com.caizhukui.rrmeiju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.caizhukui.common.service.SmsService;
import com.caizhukui.common.service.TranslationService;

import lombok.Data;

/**
 * 公共服务门面类
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
@Data
@Service
public class CommonServiceFacade {
	
	/**
	 * 短信服务
	 */
    @Autowired
	private SmsService smsService;
	
	/**
	 * 邮件服务
	 */
	@Autowired
	private EmailService emailService;
	
	/**
	 * IP地址服务
	 */
	@Autowired
	private IpService ipService;
	
	/**
	 * 手机号码服务
	 */
	@Autowired
	private MobileService mobileService;
	
	/**
	 * 手机号码段服务
	 */
	@Autowired
	private MobileLocaleService mobileLocaleService;
	
	/**
	 * 翻译服务
	 */
	@Autowired
	@Qualifier("youdaoTranslationService")
	private TranslationService translationService;

}
