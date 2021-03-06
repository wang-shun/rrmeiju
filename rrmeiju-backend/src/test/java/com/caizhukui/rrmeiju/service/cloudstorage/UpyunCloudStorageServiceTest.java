package com.caizhukui.rrmeiju.service.cloudstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.caizhukui.cloudstorage.CloudStorageService;

/**
 * 又拍云对象存储服务测试类
 * 
 * @author caizhukui
 * @date 2018年4月29日
 */
public class UpyunCloudStorageServiceTest extends CloudStorageServiceTest {

    @Autowired
    @Qualifier("upyunCloudStorage")
    private CloudStorageService cloudStorageService;

    @Override
    protected CloudStorageService cloudStorageService() {
        return cloudStorageService;
    }

}
