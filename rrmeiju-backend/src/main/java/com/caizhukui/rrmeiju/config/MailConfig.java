package com.caizhukui.rrmeiju.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 邮件发送配置类
 * 
 * @author caizhukui
 * @date 2018年4月20日
 */
@Configuration
@PropertySource("classpath:properties/mail.properties")
public class MailConfig {
    
    private static final String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    
    private static final String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
    
    /** 主机名 */
    @Value("${mail.smtp.host}")
    private String host;
    
    /** 端口号 */
    @Value("${mail.smtp.port}")
    private int port;
    
    /** 账号 */
    @Value("${mail.smtp.username}")
    private String username;
    
    /** 密码 */
    @Value("${mail.smtp.password}")
    private String password;
    
    /**  */
    @Value("${mail.transport.protocol}")
    private String mailTransportProtocol;
    
    /**  */
    @Value("${mail.smtp.auth}")
    private String mailSmtpAuth;
    
    /**  */
    @Value("${mail.smtp.starttls.enable}")
    private String mailSmtpStarttlsEnable;
    
    @Bean
    public SimpleMailMessage simpleMailMessage() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setSubject("Spring测试邮件");
        return mailMessage;
    }
    
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setJavaMailProperties(javaMailProperties());
        return javaMailSender;
    }
    
    @Bean
    public Properties javaMailProperties() {
        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty(MAIL_TRANSPORT_PROTOCOL, mailTransportProtocol);
        javaMailProperties.setProperty(MAIL_SMTP_AUTH, mailSmtpAuth);
        javaMailProperties.setProperty(MAIL_SMTP_STARTTLS_ENABLE, mailSmtpStarttlsEnable);
        return javaMailProperties;
    }

}
