package com.caizhukui.rrmeiju.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮件控制类
 * 
 * @author caizhukui
 * @date 2016年12月28日
 */
@RestController
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmailController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	/**
	 * 
	 * 
	 * @param type
	 * @param from
	 * @param to
	 * @param subject
	 * @param text
	 * @author caizhukui
	 * @date 2017年3月16日
	 */
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public void sendEmail(@RequestParam(required=false, defaultValue="text") String type, @RequestParam String from, 
			@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
		logger.debug("sendEmail - type = {}, from = {}, to = {}, subject = {}, text = {}", type, from, to, subject, text);
		String[] tos = to.split(",");
		if ("html".equals(type)) {
			commonServiceFacade.getEmailService().sendHtmlMail(from, tos, subject, text);
		} else {
			commonServiceFacade.getEmailService().sendTextMail(tos, text);
		}
	}

    @Override
    protected String getName() {
        return "邮件";
    }

}
