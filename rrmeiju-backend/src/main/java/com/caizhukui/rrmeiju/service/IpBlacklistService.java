package com.caizhukui.rrmeiju.service;

import java.util.List;

import com.caizhukui.rrmeiju.model.IpBlacklist;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月14日
 */
public interface IpBlacklistService {
	
	/**
	 * 查询所有被加入黑名单的IP地址
	 * 
	 * @return List<IpBlacklist>
	 * @author caizhukui
	 * @date 2017年6月14日
	 */
	List<IpBlacklist> getAll();
	
	/**
	 * 新增IP地址黑名单
	 * 
	 * @param ipBlacklist
	 * @author caizhukui
	 * @date 2017年6月14日
	 */
	void add(IpBlacklist ipBlacklist);

}
