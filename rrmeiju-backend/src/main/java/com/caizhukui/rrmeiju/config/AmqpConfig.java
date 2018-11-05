package com.caizhukui.rrmeiju.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitOperations;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * AMQP配置，默认使用RabbitMQ消息队列
 * 
 * @author caizhukui
 * @date 2018年4月16日
 */
//@Configuration
@PropertySource("classpath:properties/rabbitmq.properties")
public class AmqpConfig {

    /**  */
    @Value("${rabbitmq.host}")
    private String host;

    /**  */
    @Value("${rabbitmq.port}")
    private int port;

    /**  */
    @Value("${rabbitmq.username}")
    private String username;

    /**  */
    @Value("${rabbitmq.password}")
    private String password;

    /**  */
    @Value("${rabbitmq.queueName.email}")
    private String emailQueueName;

    /**  */
    @Value("${rabbitmq.exchange.default}")
    private String defaultExchange;

    /**  */
    @Value("${rabbitmq.routingKey.default}")
    private String defaultRoutingKey;

    /**  */
    @Value("${rabbitmq.queue.default}")
    private String defaulQueue;

    @Bean
    public RabbitOperations rabbitOperations(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.setExchange(defaultExchange);
        rabbitTemplate.setRoutingKey(defaultRoutingKey);
        rabbitTemplate.setQueue(defaulQueue);
        return rabbitTemplate;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory, Queue queue, Exchange exchange, Binding binding) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareExchange(exchange);
        rabbitAdmin.declareBinding(binding);
        return rabbitAdmin;
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueueName);
    }

    @Bean
    public Exchange fanoutExchange() {
        FanoutExchange fanoutExchange = new FanoutExchange(emailQueueName);
        return fanoutExchange;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost(host);
        cachingConnectionFactory.setPort(port);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter messageConverter() {
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        return jackson2JsonMessageConverter;
    }

}
