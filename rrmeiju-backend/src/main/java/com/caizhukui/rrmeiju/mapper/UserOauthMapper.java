package com.caizhukui.rrmeiju.mapper;

import org.apache.ibatis.annotations.Param;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.UserOauth;

/**
 * Mapper接口
 * 
 * @author caizhukui
 * @date 2017年6月30日
 */
public interface UserOauthMapper extends BaseMapper<UserOauth> {
	
	/**
	 * 根据用户UUID和第三方OAuth来源查询OAuth记录
	 * 
	 * @param userUuid 用户ID
	 * @param source 第三方OAuth来源
	 * @return UserOauth
	 * @author caizhukui
	 * @date 2017年6月30日
	 */
	UserOauth getByUserUuidAndSource(@Param("userUuid") String userUuid, @Param("source") int source);

}
