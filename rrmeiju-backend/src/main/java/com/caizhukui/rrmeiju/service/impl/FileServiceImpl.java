package com.caizhukui.rrmeiju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caizhukui.rrmeiju.mapper.FileMapper;
import com.caizhukui.rrmeiju.model.UploadFile;
import com.caizhukui.rrmeiju.service.FileService;

/**
 * 文件上传记录Service，具体的文件上传参见{@link OssCloudStorageServiceImpl}
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
@Service
@Transactional
public class FileServiceImpl implements FileService {
	
	@Autowired
	private FileMapper uploadFileDao;

	/**
	 * (non-Javadoc)
	 * @see com.caizhukui.rrmeiju.service.FileService#add(com.caizhukui.rrmeiju.model.UploadFile)
	 */
	@Async
	@Override
	public void add(UploadFile uploadFile) {
		uploadFileDao.add(uploadFile);
	}

}
