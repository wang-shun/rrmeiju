package com.caizhukui.rrmeiju.service;

import com.caizhukui.rrmeiju.bo.IpLocation;
import com.caizhukui.rrmeiju.model.Ip;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
public interface IpService extends BaseService<Ip> {
	
	/**
	 * 根据IP地址获取地理位置
	 * 
	 * @param ip IP地址
	 * @return Location
	 * @author caizhukui
	 * @date 2017年3月21日
	 */
	IpLocation getLocationByIp(String ip);
	
	/**
	 * 根据IP地址查询IP地址信息
	 * 
	 * @param ip IP地址
	 * @return Ip IP地址信息
	 * @author caizhukui
	 * @date 2017年6月10日
	 */
	Ip getByIp(String ip);
	
}
