package com.caizhukui.rrmeiju.service.impl.thirdparty.baidu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baidu.drapi.autosdk.core.ResHeader;
import com.baidu.drapi.autosdk.core.ServiceFactory;
import com.baidu.drapi.autosdk.exception.ApiException;

/**
 * 百度搜索推广服务基础实现类
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
@Service
public class BaiduServiceImpl {
    
    private static final Logger logger = LoggerFactory.getLogger(BaiduServiceImpl.class);
    
    protected static final String SUCCESS = "success";
    
    /**  */
    protected ServiceFactory factory;
    
    public BaiduServiceImpl() throws ApiException {
        factory = ServiceFactory.getInstance();
    }
    
    protected boolean isSuccess(ResHeader header) {
        return header.getStatus() == 0 && SUCCESS.equals(header.getDesc());
    }

}
