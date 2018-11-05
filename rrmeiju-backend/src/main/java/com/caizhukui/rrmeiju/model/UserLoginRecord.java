package com.caizhukui.rrmeiju.model;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户登录记录实体类
 * 
 * @author caizhukui
 * @date 2017年6月8日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserLoginRecord extends BaseModel {

	private static final long serialVersionUID = 6683932337282038389L;
	
	/** 用户名 */
	private String userName;
	
	/** 手机号 */
	private String mobileNumber;
	
	/** 邮箱 */
	private String email;
	
	/** QQ的OpenID */
	private String qqOpenid;
	
	/** 微信的OpenID */
	private String weixinOpenid;
	
	/** 新浪微博的uid */
	private String weiboUid;
	
	/** 百度的uid */
	private String baiduUid;
	
	/** 客户端IP地址 */
	private String remoteIp;
	
	/** 登录时间 */
	private String loginTime;
	
	/***************************************/
	
	/**  */
	@Transient
	private User user;

}
