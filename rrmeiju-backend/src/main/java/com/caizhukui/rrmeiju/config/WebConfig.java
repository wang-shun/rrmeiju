package com.caizhukui.rrmeiju.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.caizhukui.rrmeiju.interceptor.CorsInterceptor;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月14日
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.caizhukui.rrmeiju.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    /** 配置Thymeleaf视图解析器 */

    @Bean
    public ViewResolver viewResolver(TemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setCharacterEncoding("UTF-8");
        // viewResolver.setOrder(1);
        // viewResolver.setViewNames(new String[] { ".html", ".xhtml" });
        return viewResolver;
    }

    @Bean
    public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
        // SpringTemplateEngine自动应用SpringStandardDialect，
        // 并启用Spring自己的MessageSource消息解析机制
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        // 使用Spring 4.2.4或更高版本启用SpringEL编译器，可以加快大多数情况下的执行速度，
        // 但是当一个模板中的表达式在不同数据类型之间重用时，可能与特定情况不兼容，
        // 因此该标志默认为“false”，以实现更安全的向后兼容性
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Bean
    public ITemplateResolver templateResolver() {
        // SpringResourceTemplateResolver自动与Spring自己集成，资源解决基础设施
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        // 默认情况下，模板缓存为true，如果设置为false，模板在修改时自动更新
        templateResolver.setCacheable(true);
        return templateResolver;
    }

    /** 配置国际化 */
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    
    /** 文件上传 */
    
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        // 单文件最大5MB
        multipartResolver.setMaxUploadSizePerFile(5242880L);
        return multipartResolver;
    }

    @Bean
    public CorsInterceptor corsInterceptor() {
         return new CorsInterceptor();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/v1/*");
    }
    
}
