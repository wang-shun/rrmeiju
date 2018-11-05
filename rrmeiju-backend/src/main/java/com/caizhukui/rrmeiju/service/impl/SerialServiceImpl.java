package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.SerialMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.service.SerialService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 美剧季服务实现类
 * 
 * @author caizhukui
 * @date 2017年1月26日
 */
@Service
public class SerialServiceImpl extends BaseServiceImpl<Serial> implements SerialService {
	
	private static final Logger logger = LoggerFactory.getLogger(SerialServiceImpl.class);
	
	@Autowired
	private SerialMapper serialMapper;

	@Override
	public List<Serial> getByUserUuid(String userUuid) {
		List<Serial> serials = serialMapper.getByUserUuid(userUuid);
		return serials;
	}
	
	@Override
	public List<Serial> getByTelevisionUuid(String televisionUuid) {
		List<Serial> serials = serialMapper.getByTelevisionUuid(televisionUuid);
		return serials;
	}
	
	@Override
	public void batchAdd(List<Serial> serials) {
		for (Serial serial : serials) {
			add(serial);
		}
	}

	@Override
	public void batchUpdate(List<Serial> serials) {
		for (Serial serial : serials) {
			updateByUuid(serial);
		}
	}

	@Override
	public boolean followSerial(String userUuid, String serialUuid) {
		boolean isSuccess = false;
		try {
			int count = serialMapper.getFollowSerialCount(userUuid, serialUuid);
			if (count == 0) {
				serialMapper.followSerial(userUuid, serialUuid);
			}
			isSuccess = true;
		} catch (Exception e) {
			logger.error("关注剧集出错", e);
		}
		return isSuccess;
	}
	
	@Override
	public boolean cancelFollowSerial(String userUuid, String serialUuid) {
		boolean isSuccess = false;
		try {
			serialMapper.cancelFollowSerial(userUuid, serialUuid);
			isSuccess = true;
		} catch (Exception e) {
			logger.error("取消关注剧集出错", e);
		}
		return isSuccess;
	}

	@Override
	public boolean isFollowSerial(String userUuid, String serialUuid) {
		boolean isFollow = false;
		int count = serialMapper.getFollowSerialCount(userUuid, serialUuid);
		if (count > 0) {
			isFollow = true;
		}
		return isFollow;
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.SERIAL;
    }

    @Override
    protected BaseMapper<Serial> getMapper() {
        return serialMapper;
    }

}
