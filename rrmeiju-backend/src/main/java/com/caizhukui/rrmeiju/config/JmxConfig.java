package com.caizhukui.rrmeiju.config;

import javax.management.MBeanServerConnection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月18日
 */
//@Configuration
public class JmxConfig {
    
    /*@Bean
    public ConnectorServerFactoryBean connectorServerFactoryBean() {
        return new ConnectorServerFactoryBean();
    }
    
    @Bean
    public JmxClient jmxClient(MBeanServerConnection connection) {
        JmxClient jmxClient = new JmxClient();
        jmxClient.setMbeanServerConnection(connection);
        return jmxClient;
    }

    @Bean
    public MBeanProxyFactoryBean mBeanProxyFactoryBean(MBeanServerConnection server) {
        MBeanProxyFactoryBean proxy = new MBeanProxyFactoryBean();
        proxy.setObjectName("");
        proxy.setServer(server);
        //proxy.setProxyInterface();
        return proxy;
    }
    
    @Bean
    public MBeanServerConnectionFactoryBean mBeanServerConnectionFactoryBean() {
        MBeanServerConnectionFactoryBean mbscfb = new MBeanServerConnectionFactoryBean();
        mbscfb.setServiceUrl("sss");
        return mbscfb;
    }*/
    
}
