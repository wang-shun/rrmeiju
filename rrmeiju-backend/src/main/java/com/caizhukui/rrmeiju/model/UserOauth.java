package com.caizhukui.rrmeiju.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月30日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserOauth extends BaseModel {
	
    private static final long serialVersionUID = -1085032976123500429L;
	
	/** 用户UUID */
	private String userUuid;
	
	/** 授权的唯一票据 */
	private String accessToken;
	
	/** 刷新授权的唯一票据 */
	private String refreshToken;
	
	/** access_token的有效期，单位是秒 */
	private int expiresIn;
	
	/** 授权时间 */
	private Date grantTime;
	
	/** 授权自然失效时间 */
	private Date expireTime;
	
	/** 第三方OAuth来源 (1:QQ，2:微信，3:新浪微博，4:百度，5:豆瓣) */
	private int source;

}
