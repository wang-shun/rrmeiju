package com.caizhukui.rrmeiju.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.UserLoginRecordMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.UserLoginRecord;
import com.caizhukui.rrmeiju.service.UserLoginRecordService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 用户登录记录服务实现类
 * 
 * @author caizhukui
 * @date 2017年6月8日
 */
@Service
public class UserLoginRecordServiceImpl extends BaseServiceImpl<UserLoginRecord> implements UserLoginRecordService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserLoginRecordServiceImpl.class);
	
	@Autowired
	private UserLoginRecordMapper userLoginRecordMapper;

	@Override
	public void addByUserName(String userName, String remoteIp) {
		UserLoginRecord record = convertUserLoginRecord(remoteIp);
		record.setUserName(userName);
		add(record);
	}

	@Override
	public void addByMobileNumber(String mobileNumber, String remoteIp) {
		UserLoginRecord record = convertUserLoginRecord(remoteIp);
		record.setMobileNumber(mobileNumber);
		add(record);
	}
	
	@Override
	public void addByEmail(String email, String remoteIp) {
		UserLoginRecord record = convertUserLoginRecord(remoteIp);
		record.setEmail(email);
		add(record);
	}

	@Override
	public void addByQqOpenId(String qqOpenId, String remoteIp) {
		UserLoginRecord record = convertUserLoginRecord(remoteIp);
		record.setQqOpenid(qqOpenId);
		add(record);
	}

	@Override
	public void addByWeixinOpenId(String weixinOpenId, String remoteIp) {
		UserLoginRecord record = convertUserLoginRecord(remoteIp);
		record.setWeixinOpenid(weixinOpenId);
		add(record);
	}

	@Override
	public void addByWeiboUid(String weiboUid, String remoteIp) {
		UserLoginRecord record = convertUserLoginRecord(remoteIp);
		record.setWeiboUid(weiboUid);
		add(record);
	}
	
	@Override
	public void addByBaiduUid(String baiduUid, String remoteIp) {
		UserLoginRecord record = convertUserLoginRecord(remoteIp);
		record.setBaiduUid(baiduUid);
		add(record);
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.USER_LOGIN_RECORD;
    }

    @Override
    protected BaseMapper<UserLoginRecord> getMapper() {
        return userLoginRecordMapper;
    }

	/**
	 * 转换用户登录记录
	 * 
	 * @param remoteIp 客户端IP
	 * @return UserLoginRecord 用户登录记录
	 * @author caizhukui
	 * @date 2017年6月8日
	 */
	private UserLoginRecord convertUserLoginRecord(String remoteIp) {
		UserLoginRecord record = new UserLoginRecord();
		record.setRemoteIp(remoteIp);
		return record;
	}

}
