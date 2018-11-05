package com.caizhukui.rrmeiju.service.cloudstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.caizhukui.cloudstorage.CloudStorageService;

/**
 * 百度云对象存储服务测试类
 * 
 * @author caizhukui
 * @date 2018年5月3日
 */
public class BosCloudStorageServiceTest extends CloudStorageServiceTest {

    @Autowired
    @Qualifier("bosCloudStorage")
    private CloudStorageService cloudStorageService;
    
    @Override
    protected CloudStorageService cloudStorageService() {
        return cloudStorageService;
    }

}
