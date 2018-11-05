package com.caizhukui.rrmeiju.webservice;

import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caizhukui.common.service.SmsService;

/**
 * 短信发送服务端点
 * 
 * @author caizhukui
 * @date 2018年4月24日
 */
@Component
@WebService(serviceName = "SmsService")
public class SmsServiceEndpoint {
    
    @Autowired
    private SmsService smsService;
    
    @WebMethod
    public void sendSms(String phoneNumbers, String signName, String templateCode, Map<String, String> templateParams) {
        smsService.sendSms(phoneNumbers, signName, templateCode, templateParams);
    }

}
