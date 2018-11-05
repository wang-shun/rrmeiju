package com.caizhukui.rrmeiju.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 异步执行配置
 * 
 * @author caizhukui
 * @date 2018年4月19日
 */
@Configuration
@EnableAsync
@PropertySource("classpath:properties/async.properties")
public class AsyncConfig implements AsyncConfigurer {
    
    /** 线程池最小线程数 */
    @Value("${executor.corePoolSize}")
    private int corePoolSize;
    
    /** 线程池最大线程数 */
    @Value("${executor.maxPoolSize}")
    private int maxPoolSize;
    
    /**  */
    @Value("${executor.keepAliveSeconds}")
    private int keepAliveSeconds;
    
    /** 等待队列容量 */
    @Value("${executor.queueCapacity}")
    private int queueCapacity;
    
    /**  */
    @Value("${executor.allowCoreThreadTimeOut}")
    private boolean allowCoreThreadTimeOut;
    
    /**  */
    @Value("${executor.threadNamePrefix}")
    private String threadNamePrefix;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setAllowCoreThreadTimeOut(allowCoreThreadTimeOut);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

}
