package com.caizhukui.rrmeiju.service;

import java.util.Set;

import com.caizhukui.rrmeiju.model.SmsSendRecord;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 短信发送记录服务接口
 * 
 * @author caizhukui
 * @date 2017年6月7日
 */
public interface SmsSendRecordService extends BaseService<SmsSendRecord> {
	
	/**
	 * 查询搜索记录的所有IP
	 * 
	 * @return Set<String>
	 * @author caizhukui
	 * @date 2017年6月7日
	 */
	Set<String> getAllIps();
	
	/**
	 * 查询短信发送是否超限
	 * 
	 * @param mobileNumber
	 * @param remoteIp
	 * @return boolean
	 * @author caizhukui
	 * @date 2017年6月7日
	 */
	boolean isRestricted(String mobileNumber, String remoteIp);

}
