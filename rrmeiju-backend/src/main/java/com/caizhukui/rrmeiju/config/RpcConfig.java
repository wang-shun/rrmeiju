package com.caizhukui.rrmeiju.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.caizhukui.common.service.SmsService;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月24日
 */
//@Configuration
@PropertySource("classpath:properties/rpc.properties")
public class RpcConfig {
    
    /** 短信发送RMI服务名 */
    private static final String SMS_SERVICE_NAME = "SmsService";
    
    /** RMI服务主机名 */
    @Value("${rpc.rmi.registryHost}")
    private String registryHost;
    
    /** RMI服务端口号 */
    @Value("${rpc.rmi.registryPort}")
    private int registryPort;
    
    /**  */
    @Value("${rpc.jaxws.baseAddress}")
    private String baseAddress;
    
    /**
     * 将短信发送导出为RMI服务<br>
     * 客户端必须是Java应用，且Java版本号要与服务端一样
     * 
     * @param smsService
     * @return RmiServiceExporter
     * @author caizhukui
     * @date 2018年4月24日
     */
//    @Bean
//    public RmiServiceExporter rmiExportedSmsService(SmsService smsService) {
//        RmiServiceExporter exporter = new RmiServiceExporter();
//        exporter.setService(smsService);
//        exporter.setServiceName(SMS_SERVICE_NAME);
//        exporter.setServiceInterface(SmsService.class);
//        exporter.setRegistryHost(registryHost);
//        exporter.setRegistryPort(registryPort);
//        return exporter;
//    }
    
    /**
     * 将短信发送导出为Hessian服务
     * 
     * @param smsService
     * @return HessianServiceExporter
     * @author caizhukui
     * @date 2018年4月24日
     */
    @Bean
    public HessianServiceExporter hessianExportedSmsService(SmsService smsService) {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(smsService);
        exporter.setServiceInterface(SmsService.class);
        return exporter;
    }
    
    /**
     * 将短信发送导出为HTTP Invoker服务<br>
     * 客户端必须是基于Java的Spring应用，且Java版本号要与服务端一样
     * 
     * @param smsService
     * @return HttpInvokerServiceExporter
     * @author caizhukui
     * @date 2018年4月24日
     */
    @Bean
    public HttpInvokerServiceExporter httpExportedSmsService(SmsService smsService) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(smsService);
        exporter.setServiceInterface(SmsService.class);
        return exporter;
    }
    
    /**
     * 导出JAX-WS Web服务<br>
     * 只能用在支持将端点发布到指定地址的JAX-WS运行时中
     * 
     * @return SimpleJaxWsServiceExporter
     * @author caizhukui
     * @date 2018年4月24日
     */
    @Bean
    public SimpleJaxWsServiceExporter jaxWsExporter() {
        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        exporter.setBaseAddress(baseAddress);
        return exporter;
    }

}
