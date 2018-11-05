package com.caizhukui.rrmeiju.service;

import com.caizhukui.rrmeiju.model.UserRegisterRecord;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 用户注册记录服务接口
 * 
 * @author caizhukui
 * @date 2017年6月8日
 */
public interface UserRegisterRecordService extends BaseService<UserRegisterRecord> {
	
	/**
	 * 查询某一IP当天的注册请求量
	 * 
	 * @param remoteIp 客户端IP地址
	 * @return int 该IP当天的注册请求量
	 * @author caizhukui
	 * @date 2017年6月7日
	 */
	int getTodayCountByRemoteIp(String remoteIp);

}
