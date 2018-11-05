package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色控制器类
 * 
 * @author caizhukui
 * @date 2016年10月31日
 */
@RestController
@RequestMapping(value = "/v1/roles", produces = APPLICATION_JSON_UTF8_VALUE)
public class RoleController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

	/**
	 * 根据UserName查询RoleName
	 * 
	 * @param userName
	 * @return List<String>
	 * @author caizhukui
	 * @date 2016年10月31日下午1:39:09
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, params = {"userName"})
	public List<String> getRoleNames(@RequestParam String userName) {
		logger.info("userName : {}", userName);
		List<String> roleNames = serviceFacade.getRoleService().getRoleNamesByUserName(userName);
		logger.info("roleNames : {}", roleNames);
		return roleNames;
	}

    @Override
    protected String getName() {
        return "角色";
    }

}
