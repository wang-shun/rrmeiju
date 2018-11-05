package com.caizhukui.rrmeiju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.UserRegisterRecordMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.UserRegisterRecord;
import com.caizhukui.rrmeiju.service.UserRegisterRecordService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 用户注册记录服务实现类
 * 
 * @author caizhukui
 * @date 2017年6月8日
 */
@Service
public class UserRegisterRecordServiceImpl extends BaseServiceImpl<UserRegisterRecord> implements UserRegisterRecordService {

	@Autowired
	private UserRegisterRecordMapper userRegisterRecordMapper;

	@Override
	public int getTodayCountByRemoteIp(String remoteIp) {
		int count = userRegisterRecordMapper.getTodayCountByRemoteIp(remoteIp);
		return count;
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.USER_REGISTER_RECORD;
    }

    @Override
    protected BaseMapper<UserRegisterRecord> getMapper() {
        return userRegisterRecordMapper;
    }

}
