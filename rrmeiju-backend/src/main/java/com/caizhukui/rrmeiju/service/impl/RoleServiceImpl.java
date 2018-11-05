package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.mapper.RoleMapper;
import com.caizhukui.rrmeiju.service.RoleService;

/**
 * 角色服务实现类
 * 
 * @author caizhukui
 * @date 2016年10月31日
 */
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<String> getRoleNamesByUserUuid(String userId) {
		List<String> roleNames = roleMapper.getRoleNamesByUserId(userId);
		return roleNames;
	}

	@Override
	public List<String> getRoleNamesByUserName(String userName) {
		List<String> roleNames = roleMapper.getRoleNamesByUserName(userName);
		return roleNames;
	}

	@Override
	public void addUserRole(String userId, String roleId) {
		roleMapper.addUserRole(userId, roleId);
	}

}
