package com.caizhukui.rrmeiju.config;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.caizhukui.core.consts.ProfileConstant;

/**
 * 工作流配置，默认使用Activiti流程引擎
 * 
 * @author caizhukui
 * @date 2018年8月11日
 */
@Configuration
@PropertySource("classpath:properties/activiti.properties")
public class ActivitiConfig {
    
    /** JDBC驱动类的全限定类名 */
    @Value("${jdbc.driver}")
    private String jdbcDriver;

    /** 数据库连接URL，开发环境 */
    @Value("${jdbc.url.dev}")
    private String jdbcUrlDev;

    /** 用户名，开发环境 */
    @Value("${jdbc.username.dev}")
    private String jdbcUsernameDev;

    /** 密码，开发环境 */
    @Value("${jdbc.password.dev}")
    private String jdbcPasswordDev;

    /** 数据库连接URL，测试环境 */
    @Value("${jdbc.url.test}")
    private String jdbcUrlTest;

    /** 用户名，测试环境 */
    @Value("${jdbc.username.test}")
    private String jdbcUsernameTest;

    /** 密码，测试环境 */
    @Value("${jdbc.password.test}")
    private String jdbcPasswordTest;

    /** 数据库连接URL，生产环境 */
    @Value("${jdbc.url.prod}")
    private String jdbcUrlProd;

    /** 用户名，生产环境 */
    @Value("${jdbc.username.prod}")
    private String jdbcUsernameProd;

    /** 密码，生产环境 */
    @Value("${jdbc.password.prod}")
    private String jdbcPasswordProd;
    
    @Bean
    public BpmnModel createProcessModel() {
        // 创建BPMN模型对象
        BpmnModel model = new BpmnModel();
        org.activiti.bpmn.model.Process process = new org.activiti.bpmn.model.Process();
        model.addProcess(process);
        process.setId("myProcess");
        process.setName("My Process");
        // 开始事件
        StartEvent startEvent = new StartEvent();
        startEvent.setId("startEvent");
        process.addFlowElement(startEvent);
        // 用户任务
        UserTask userTask = new UserTask();
        userTask.setId("userTask");
        userTask.setName("User Task");
        process.addFlowElement(userTask);
        // 结束事件
        EndEvent endEvent = new EndEvent();
        endEvent.setId("endEvent");
        process.addFlowElement(endEvent);
        // 添加流程顺序
        process.addFlowElement(new SequenceFlow("startEvent", "userTask"));
        process.addFlowElement(new SequenceFlow("userTask", "endEvent"));
        return model;
    }
    
    @Bean
    public RepositoryService repositoryService(ProcessEngine engine) {
        return engine.getRepositoryService();
    }
    
    @Bean
    public RuntimeService runtimeService(ProcessEngine engine) {
        return engine.getRuntimeService();
    }
    
    @Bean
    public TaskService taskService(ProcessEngine engine) {
        return engine.getTaskService();
    }
    
    @Bean
    public IdentityService identityService(ProcessEngine engine) {
        return engine.getIdentityService();
    }
    
    @Bean
    public ProcessEngine processEngine(ProcessEngineConfiguration config) {
        return config.buildProcessEngine();
    }
    
    @Bean
    @Profile(ProfileConstant.DEV)
    public ProcessEngineConfiguration devProcessEngineConfiguration() {
        ProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
        config.setJdbcDriver(jdbcDriver);
        config.setJdbcUrl(jdbcUrlDev);
        config.setJdbcUsername(jdbcUsernameDev);
        config.setJdbcPassword(jdbcPasswordDev);
        config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        config.setCreateDiagramOnDeploy(true);
        config.setEnableProcessDefinitionInfoCache(true);
        return config;
    }
    
    @Bean
    @Profile(ProfileConstant.TEST)
    public ProcessEngineConfiguration testProcessEngineConfiguration() {
        ProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
        config.setJdbcDriver(jdbcDriver);
        config.setJdbcUrl(jdbcUrlTest);
        config.setJdbcUsername(jdbcUsernameTest);
        config.setJdbcPassword(jdbcPasswordTest);
        config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        return config;
    }
    
    @Bean
    @Profile(ProfileConstant.PROD)
    public ProcessEngineConfiguration prodProcessEngineConfiguration() {
        ProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
        config.setJdbcDriver(jdbcDriver);
        config.setJdbcUrl(jdbcUrlProd);
        config.setJdbcUsername(jdbcUsernameProd);
        config.setJdbcPassword(jdbcPasswordProd);
        config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        return config;
    }

}
