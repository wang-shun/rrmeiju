package com.caizhukui.rrmeiju.mapper;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.UserRegisterRecord;

/**
 * 用户注册记录Mapper接口
 * 
 * @author caizhukui
 * @date 2017年6月8日
 */
public interface UserRegisterRecordMapper extends BaseMapper<UserRegisterRecord> {
	
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
