package com.caizhukui.rrmeiju.service;

import org.activiti.bpmn.model.BpmnModel;

import com.caizhukui.rrmeiju.model.User;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年8月11日
 */
public interface WorkflowService {
    
    /**
     * 
     * @param user
     * @author caizhukui
     * @date 2018年8月13日
     */
    String createUser(User user);
    
    /**
     * 部署流程
     * 
     * @param model
     * @param processName 流程定义名称
     * @param deploymentName 流程部署名称
     * @return processDefinitionId 流程定义ID
     * @author caizhukui
     * @date 2018年8月11日
     */
    String deployProcess(BpmnModel model, String processName, String deploymentName);
    
    /**
     * 激活流程
     * 
     * @author caizhukui
     * @date 2018年8月11日
     */
    void activateProcess();
    
    /**
     * 中止流程
     * 
     * @author caizhukui
     * @date 2018年8月11日
     */
    void suspendProcess();
    
    /**
     * 启动流程
     * 
     * @param processDefinitionId 流程定义ID
     * @author caizhukui
     * @date 2018年8月13日
     */
    void startProcess(String processDefinitionId);

}
