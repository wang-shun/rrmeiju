package com.caizhukui.rrmeiju.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户注册记录实体类
 * 
 * @author caizhukui
 * @date 2017年6月8日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserRegisterRecord extends BaseModel {

	private static final long serialVersionUID = -1373878564231202728L;
	
	/** 用户名 */
	private String userName;
	
	/** 手机号 */
	private String mobileNumber;
	
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
	
	/** 注册时间 */
	private String registerTime;

}
