package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import com.caizhukui.rrmeiju.model.IpBlacklist;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月14日
 */
public interface IpBlacklistMapper {
	
	/**
	 * 查询所有被加入黑名单的IP地址
	 * 
	 * @return List<IpBlacklist>
	 * @author caizhukui
	 * @date 2017年6月14日下午8:13:42
	 */
	List<IpBlacklist> getAll();
	
	/**
	 * 新增IP地址黑名单
	 * 
	 * @param ipBlacklist
	 * @author caizhukui
	 * @date 2017年6月14日下午8:19:39
	 */
	void add(IpBlacklist ipBlacklist);

}
