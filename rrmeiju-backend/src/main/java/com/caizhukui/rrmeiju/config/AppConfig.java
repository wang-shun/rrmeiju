package com.caizhukui.rrmeiju.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.impl.ChainBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.caizhukui.rrmeiju.test.ChainFilter;
import com.caizhukui.rrmeiju.test.PingFilter;
import com.caizhukui.rrmeiju.test.PongFilter;
import com.octo.captcha.engine.CaptchaEngine;
import com.octo.captcha.engine.image.gimpy.SimpleListImageCaptchaEngine;
import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月10日
 */
@Configuration
@Import({ AsyncConfig.class, SchedulingConfig.class, CacheConfig.class, RepositoryConfig.class, MailConfig.class,
        SmsConfig.class })
@ComponentScan(basePackages = { "com.caizhukui" }, excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        // placeholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        // placeholderConfigurer.setTrimValues(true);
        return placeholderConfigurer;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // restTemplate.setErrorHandler(errorHandler);
        return restTemplate;
    }

    @Bean
    public CaptchaService captchaService(CaptchaEngine captchaEngine) {
        DefaultManageableImageCaptchaService captchaService = new DefaultManageableImageCaptchaService();
        captchaService.setCaptchaEngine(captchaEngine);
        return captchaService;
    }

    @Bean
    public CaptchaEngine captchaEngine() {
        return new SimpleListImageCaptchaEngine();
    }

    @Bean
    public ChainBase pingPongChain() {
        List<ChainFilter> chainFilters = new ArrayList<>(2);
        chainFilters.add(new PingFilter());
        chainFilters.add(new PongFilter());
        return new ChainBase(chainFilters);
    }

}
