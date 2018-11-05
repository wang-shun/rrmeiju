package com.caizhukui.rrmeiju.service;

import org.apache.ibatis.annotations.Param;

import com.caizhukui.rrmeiju.model.UserOauth;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月30日
 */
public interface UserOauthService {
	
	/**
	 * 根据用户UUID和第三方OAuth来源查询OAuth记录
	 * 
	 * @param userUuid 用户UUID
	 * @param source 第三方OAuth来源
	 * @return UserOauth
	 * @author caizhukui
	 * @date 2017年6月30日
	 */
	UserOauth getByUserUuidAndSource(String userUuid, int source);
	
	/**
	 * 新增用户第三方OAuth记录
	 * 
	 * @param userOauth
	 * @return UserOauth
	 * @author caizhukui
	 * @date 2017年6月30日
	 */
	UserOauth add(UserOauth userOauth);

}
