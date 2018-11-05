package com.caizhukui.rrmeiju.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caizhukui.common.service.SmsService;

import junit.framework.TestCase;

/**
 * 短信发送服务测试类
 * 
 * @author caizhukui
 * @date 2018年4月25日
 */
public class SmsServiceTest extends BaseServiceTest {
    
    @Autowired
    private SmsService smsService;
    
    /**
     * 发送短信
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testSendSms() {
        final String phoneNumbers = "13626270072";
        final String signName = "美剧字幕站";
        final String templateCode = "SMS_129746405";
        final String captcha = String.valueOf(System.currentTimeMillis()).substring(7);
        Map<String, String> templateParams = new HashMap<>(1);
        templateParams.put("captcha", captcha);
        boolean success = smsService.sendSms(phoneNumbers, signName, templateCode, templateParams);
        TestCase.assertTrue(success);
    }

}
