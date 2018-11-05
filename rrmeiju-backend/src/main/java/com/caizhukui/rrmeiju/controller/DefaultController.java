package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.exception.RestControllerException;

/**
 * 控制器类
 * 
 * @author caizhukui
 * @date 2017年1月25日
 */
@Controller
public class DefaultController {
	
	/**
	 * 获取UUID字符串
	 * 
	 * @return String 32位小写UUID字符串
	 * @author caizhukui
	 * @date 2017年8月2日
	 */
	@RequestMapping(value = "/uuid", method = GET, produces = TEXT_PLAIN_VALUE)
	@ResponseBody
	public String uuid() {
		return UuidUtils.getUuid();
	}
	
	/**
	 * 
	 * 
	 * @return String
	 * @author caizhukui
	 * @date 2018年5月24日
	 */
	@RequestMapping("/")
	public String defaultPage() {
	    return "index";
	}
	
	/**
	 * 
	 */
	@RequestMapping("/v1/**")
	public void unmappedRequest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String developerMessage = "路径为" + uri + "的资源不存在";
        throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setDetail(developerMessage));
    }

}
