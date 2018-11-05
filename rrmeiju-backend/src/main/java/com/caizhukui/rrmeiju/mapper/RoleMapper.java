package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 角色Mapper接口
 * 
 * @author caizhukui
 * @date 2016年10月31日
 */
public interface RoleMapper {
	
	/**
	 * 根据用户ID查询角色列表
	 * 
	 * @param userId 用户ID
	 * @return List<String> 角色列表
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	List<String> getRoleNamesByUserId(String userId);
	
	/**
	 * 根据用户名查询角色列表
	 * 
	 * @param userName 用户名
	 * @return List<String> 角色列表
	 * @author caizhukui
	 * @date 2016年10月31日下午1:22:40
	 */
	List<String> getRoleNamesByUserName(String userName);
	
	/**
	 * 新增用户角色关联
	 * 
	 * @param userId 用户ID
	 * @param roleId 角色ID
	 * @author caizhukui
	 * @date 2017年4月14日下午2:55:44
	 */
	void addUserRole(@Param("userId") String userId, @Param("roleId") String roleId);
	
}
