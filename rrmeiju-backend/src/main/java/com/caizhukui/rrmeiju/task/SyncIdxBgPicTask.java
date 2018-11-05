package com.caizhukui.rrmeiju.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.caizhukui.cloudstorage.CloudStorageService;
import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.model.IdxBgPic;
import com.caizhukui.rrmeiju.service.IdxBgPicService;

/**
 * 定时任务
 * 
 * @author caizhukui
 * @date 2017年3月14日
 */
//@Component
public class SyncIdxBgPicTask implements ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(SyncIdxBgPicTask.class);
	
	/** 首页背景图片在阿里云OSS保存的路径 */
	private static final String OBJECT_KEY = "idx-bg-pic/";
	
	@Autowired
	@Qualifier("ossCloudStorage")
	private CloudStorageService ossService;
	
	@Autowired
	private IdxBgPicService idxBgPicService;
	
	/**
	 * 自动同步阿里云OSS的首页背景图片URL到数据库
	 * 
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	//@Scheduled(fixedDelayString = "${fixedDelay.syncIdxBgPic}", initialDelayString = "${initialDelay.syncIdxBgPic}")
    public void syncIdxBgPic() {
		// OSS中存在的所有文件URL
//        List<String> fileUrls = ossService.listOBJECT_KEY);
//        // 数据库表中存在的所有文件
//        List<IdxBgPic> idxBgPics = idxBgPicService.getAll();
//        for (String fileUrl : fileUrls) {
//        	// OSS中存在，数据库表中不存在，插入
//        	if (idxBgPicService.getByFileUrl(fileUrl) == null) {
//        		logger.info("数据库新增首页背景图片 - fileUrl = {}", fileUrl);
//        		IdxBgPic idxBgPic = new IdxBgPic();
//            	idxBgPic.setUuid(UuidUtils.getUuid());
//            	idxBgPic.setFileUrl(fileUrl);
//            	idxBgPicService.add(idxBgPic);
//        	}
//        }
//        for (IdxBgPic idxBgPic : idxBgPics) {
//        	// 数据库表中存在，OSS中不存在，删除
//        	String fileUrl = idxBgPic.getFileUrl();
//        	if (!fileUrls.contains(fileUrl)) {
//        		logger.info("数据库删除首页背景图片 - fileUrl = {}", fileUrl);
//        		idxBgPicService.deleteByUuid(idxBgPic.getUuid());
//        	}
//        }
    }

}
