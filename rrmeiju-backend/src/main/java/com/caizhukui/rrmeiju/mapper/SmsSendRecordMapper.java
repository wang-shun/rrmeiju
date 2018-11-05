package com.caizhukui.rrmeiju.mapper;

import java.util.Set;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.SmsSendRecord;

/**
 * 短信发送记录Mapper接口
 * 
 * @author caizhukui
 * @date 2017年6月7日
 */
public interface SmsSendRecordMapper extends BaseMapper<SmsSendRecord> {
	
	/**
	 * 查询搜索记录的所有IP
	 * 
	 * @return Set<String>
	 * @author caizhukui
	 * @date 2017年6月7日
	 */
	Set<String> getAllIps();
	
	/**
	 * 查询某一IP当天的短信发送量
	 * 
	 * @param remoteIp 客户端IP地址
	 * @return int 该IP当天的短信发送量
	 * @author caizhukui
	 * @date 2017年6月7日
	 */
	int getTodayCountByRemoteIp(String remoteIp);
	
	/**
	 * 查询某一手机号当天的短信发送量
	 * 
	 * @param mobileNumber 手机号
	 * @return int 该手机号当天的短信发送量
	 * @author caizhukui
	 * @date 2017年6月7日
	 */
	int getTodayCountByMobileNumber(String mobileNumber);

}
