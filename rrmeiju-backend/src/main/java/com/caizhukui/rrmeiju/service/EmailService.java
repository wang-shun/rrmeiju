package com.caizhukui.rrmeiju.service;

/**
 * 邮件服务
 * 
 * @author caizhukui
 * @date 2016年12月28日
 */
public interface EmailService {
	
	/**
	 * 
	 * @param to
	 * @param text
	 * @author caizhukui
	 * @date 2017年3月16日
	 */
	void sendTextMail(String[] to, String text);
	
	/**
	 * 
	 * 
	 * @param to
	 * @param text
	 * @author caizhukui
	 * @date 2017年3月16日
	 */
	void sendHtmlMail(String from, String[] to, String subject, String text);
	
}
