package com.caizhukui.rrmeiju.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import com.caizhukui.core.consts.ProfileConstant;
import com.caizhukui.rrmeiju.jms.EmailSendingHandler;

/**
 * JMS配置，默认使用ActiveMQ消息队列
 * 
 * @author caizhukui
 * @date 2018年4月16日
 */
//@Configuration
@PropertySource("classpath:properties/activemq.properties")
public class JmsConfig {

    /** brokerUrl，开发环境 */
    @Value("${activemq.brokerUrl.dev}")
    private String brokerUrlDev;

    /** brokerUrl，生产环境 */
    @Value("${activemq.brokerUrl.prod}")
    private String brokerUrlProd;

    @Value("${activemq.queueName.email}")
    private String emailQueueName;

    @Value("${activemq.topicName.sync}")
    private String syncTopicName;

    @Bean
    public JmsOperations jmsOperations(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        return jmsTemplate;
    }

    @Bean
    @Profile(ProfileConstant.DEV)
    public ConnectionFactory devActiveMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrlDev);
        return activeMQConnectionFactory;
    }

    @Bean
    @Profile(ProfileConstant.PROD)
    public ConnectionFactory prodActiveMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrlProd);
        return activeMQConnectionFactory;
    }

    @Bean
    public ActiveMQQueue emailQueue() {
        return new ActiveMQQueue(emailQueueName);
    }

    @Bean
    public ActiveMQTopic activeMQTopic() {
        return new ActiveMQTopic(syncTopicName);
    }

    @Bean
    public EmailSendingHandler emailSendingHandler() {
        return new EmailSendingHandler();
    }

    @Bean
    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
            EmailSendingHandler emailSendingHandler) {
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(connectionFactory);
        defaultMessageListenerContainer.setDestinationName(emailQueueName);
        defaultMessageListenerContainer.setMessageListener(emailSendingHandler);
        return defaultMessageListenerContainer;
    }

}
