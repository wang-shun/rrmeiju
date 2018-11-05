package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caizhukui.rrmeiju.mapper.IdxBgPicMapper;
import com.caizhukui.rrmeiju.model.IdxBgPic;
import com.caizhukui.rrmeiju.service.IdxBgPicService;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月14日
 */
@Service
@Transactional
public class IdxBgPicServiceImpl implements IdxBgPicService {
	
	private static final Logger logger = LoggerFactory.getLogger(IdxBgPicServiceImpl.class);
	
	@Autowired
	private IdxBgPicMapper idxBgPicMapper;

	@Override
	public void add(IdxBgPic idxBgPic) {
		idxBgPicMapper.add(idxBgPic);
	}

	@Override
	public IdxBgPic getByFileUrl(String fileUrl) {
		IdxBgPic idxBgPic = idxBgPicMapper.getByFileUrl(fileUrl);
		return idxBgPic;
	}

	@Override
	public IdxBgPic getByRandom(String currentFileId) {
		List<IdxBgPic> idxBgPics = idxBgPicMapper.getByRandom(2);
		IdxBgPic idxBgPic = idxBgPics.get(0);
		if (currentFileId != null && currentFileId.equals(idxBgPic.getUuid())) {
			idxBgPic = idxBgPics.get(1);
		}
		return idxBgPic;
	}

	@Override
	public List<IdxBgPic> getAll() {
		List<IdxBgPic> idxBgPics = idxBgPicMapper.getAll();
		return idxBgPics;
	}

	@Override
	public void deleteByUuid(String uuid) {
		idxBgPicMapper.deleteByUuid(uuid);
	}

}
