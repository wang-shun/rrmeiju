package com.caizhukui.rrmeiju.service.impl;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.service.WorkflowService;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年8月11日
 */
@Service
public class WorkflowServiceImpl implements WorkflowService {
    
    @Autowired
    private RepositoryService repositoryService;
    
    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private TaskService taskService;
    
    @Autowired
    private IdentityService identityService;

    @Override
    public String createUser(com.caizhukui.rrmeiju.model.User user) {
        String userId = user.getUuid();
        User activitiUser = identityService.newUser(userId);
        activitiUser.setEmail(user.getEmail());
        activitiUser.setPassword(user.getPassword());
        identityService.saveUser(activitiUser);
        return userId;
    }

    @Override
    public String deployProcess(BpmnModel model, String processName, String deploymentName) {
        DeploymentBuilder builder = repositoryService.createDeployment();
        Deployment deployment = builder.addBpmnModel(processName, model).name(deploymentName).deploy();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId())
                .singleResult();
        return processDefinition.getId();
    }

    @Override
    public void activateProcess() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void suspendProcess() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void startProcess(String processDefinitionId) {
        ProcessInstance instance = runtimeService.startProcessInstanceById(processDefinitionId);
    }

}
