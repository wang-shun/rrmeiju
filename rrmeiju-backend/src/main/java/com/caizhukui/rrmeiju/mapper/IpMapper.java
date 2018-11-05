package com.caizhukui.rrmeiju.mapper;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Ip;

/**
 * IP地址Mapper接口
 * 
 * @author caizhukui
 * @date 2017年6月8日
 */
public interface IpMapper extends BaseMapper<Ip> {
	
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
