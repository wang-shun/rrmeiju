package com.caizhukui.rrmeiju.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * CORS拦截器类
 * 
 * @author caizhukui
 * @date 2016年11月16日
 */
public class CorsInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = LoggerFactory.getLogger(CorsInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 获取客户端IP地址
		// 使用了Nginx作为反向代理，X-Real-IP在Nginx的配置文件里设置
		String remoteAddr = request.getHeader("X-Real-IP");
		if (StringUtils.isBlank(remoteAddr) || "unknown".equalsIgnoreCase(remoteAddr)) {
			remoteAddr = request.getRemoteAddr();
		}
		// 请求的URI
		String requestUri = request.getRequestURI();
		logger.info("remoteAddr = {}, requestUri = {}", remoteAddr, requestUri);
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		return true;
	}

}
