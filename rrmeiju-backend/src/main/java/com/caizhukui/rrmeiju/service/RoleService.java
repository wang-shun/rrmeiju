package com.caizhukui.rrmeiju.service;

import java.util.List;

/**
 * 角色服务接口
 * 
 * @author caizhukui
 * @date 2016年10月31日
 */
public interface RoleService {
	
	/**
	 * 根据用户UUID查询角色列表
	 * 
	 * @param userUuid 用户UUID
	 * @return List<String> 角色列表
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	List<String> getRoleNamesByUserUuid(String userUuid);
	
	/**
	 * 根据用户名查询角色列表
	 * 
	 * @param userName 用户名
	 * @return List<String> 角色列表
	 * @author caizhukui
	 * @date 2016年10月31日
	 */
	List<String> getRoleNamesByUserName(String userName);
	
	/**
	 * 新增用户角色关联
	 * 
	 * @param userUuid 用户UUID
	 * @param roleUuid 角色UUID
	 * @author caizhukui
	 * @date 2017年4月14日
	 */
	void addUserRole(String userUuid, String roleUuid);

}
