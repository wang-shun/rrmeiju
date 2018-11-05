package com.caizhukui.rrmeiju.service;

import org.springframework.scheduling.annotation.Async;

import com.caizhukui.rrmeiju.model.UserLoginRecord;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 用户登录记录服务接口
 * 
 * @author caizhukui
 * @date 2017年6月8日
 */
public interface UserLoginRecordService extends BaseService<UserLoginRecord> {
	
	/**
	 * 新增用户登录记录（用户名登录）
	 * 
	 * @param userName 用户名
	 * @param remoteIp 客户端IP
	 * @author caizhukui
	 * @date 2017年6月10日
	 */
    @Async
	void addByUserName(String userName, String remoteIp);
	
	/**
	 * 新增用户登录记录（手机号登录）
	 * 
	 * @param mobileNumber 手机号
	 * @param remoteIp 客户端IP
	 * @author caizhukui
	 * @date 2017年6月10日
	 */
    @Async
	void addByMobileNumber(String mobileNumber, String remoteIp);
	
	/**
	 * 新增用户登录记录（邮箱登录）
	 * 
	 * @param email 邮箱
	 * @param remoteIp 客户端IP
	 * @author caizhukui
	 * @date 2017年6月10日
	 */
    @Async
	void addByEmail(String email, String remoteIp);
	
	/**
	 * 新增用户登录记录（QQ登录）
	 * 
	 * @param qqOpenId QQ的OpenID
	 * @param remoteIp 客户端IP
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
    @Async
	void addByQqOpenId(String qqOpenId, String remoteIp);
	
	/**
	 * 新增用户登录记录（微信登录）
	 * 
	 * @param weixinOpenId 微信的OpenID
	 * @param remoteIp 客户端IP
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
    @Async
	void addByWeixinOpenId(String weixinOpenId, String remoteIp);
	
	/**
	 * 新增用户登录记录（新浪微博登录）
	 * 
	 * @param weiboUid 新浪微博的uid
	 * @param remoteIp 客户端IP
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
    @Async
	void addByWeiboUid(String weiboUid, String remoteIp);
	
	/**
	 * 新增用户登录记录（百度登录）
	 * 
	 * @param baiduUid 百度的uid
	 * @param remoteIp 客户端IP
	 * @author caizhukui
	 * @date 2017年7月6日
	 */
    @Async
	void addByBaiduUid(String baiduUid, String remoteIp);

}
