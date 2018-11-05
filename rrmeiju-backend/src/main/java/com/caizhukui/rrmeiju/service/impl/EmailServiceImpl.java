package com.caizhukui.rrmeiju.service.impl;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.service.EmailService;

/**
 * Email Service
 * 
 * @author caizhukui
 * @date 2017年3月16日
 */
@Service
public class EmailServiceImpl implements EmailService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Resource
	private JavaMailSender mailSender;
	
	@Resource
    private SimpleMailMessage templateMessage;

	@Override
	public void sendTextMail(String[] to, String text) {
		// create a thread safe "copy" of the template message and customize it
        SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
        msg.setTo(to);
        msg.setText(text);
        try {
            mailSender.send(msg);
        } catch (MailException e) {
            logger.error("{}", e);
        }
	}

	@Override
	public void sendHtmlMail(String from, String[] to, String subject, String text) {
		MimeMessage mime = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mime, true, "UTF-8");
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text, true);
			mailSender.send(mime);
		} catch (MessagingException e) {
			logger.error("", e);
		}
		
	}

}
