package com.caizhukui.rrmeiju.service;

import com.caizhukui.rrmeiju.thirdparty.juhe.MobileNumber;

/**
 * 手机号码服务
 * 
 * @author caizhukui
 * @date 2017年3月21日
 */
public interface MobileService {
	
	/**
	 * 
	 * 
	 * @param mobile
	 * @return MobileNumber
	 * @author caizhukui
	 * @date 2017年3月21日
	 */
	MobileNumber getInfoByMobile(String mobile);

}
