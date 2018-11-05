package com.caizhukui.rrmeiju.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户实体类
 * 
 * @author caizhukui
 * @date 2017年1月26日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseModel {
	
	private static final long serialVersionUID = -2572183673803204493L;
	
	/** 用户名 */
	private String userName;
	
	/** QQ的OpenID */
	private String qqOpenId;
	
	/** 微信的OpenID */
	private String weixinOpenId;
	
	/** 新浪微博的uid */
	private String weiboUid;
	
	/** 百度的uid */
	private String baiduUid;

	/** 密码 */
	private String password;
	
	/** 昵称 */
	private String nickname;
	
	/** 性别 */
    private byte sex;
	
	/** 邮箱 */
    private String email;
	
	/** 手机号 */
	private String mobileNumber;
	
	/** 头像URL */
	private String avatarUrl;
	
	/** 注册来源（详见{@linkplain com.caizhukui.rrmeiju.consts.UserRegisterSource UserRegisterSource}） */
	private int source;
	
	/** 注册时间 */
    private Date createTime;
    
    /** 账号是否已过期 */
	private boolean accountNonExpired;
	
	/** 账号是否被封禁 */
	private boolean accountNonLocked;
	
	/** 账号权限是否已过期 */
	private boolean credentialsNonExpired;
	
	/** 账号是否已激活 */
	private boolean enabled;
	
	/***************************************/
	
	/**  */
	@Transient
	private List<Fansub> fansubs;
	
	/**  */
	@Transient
	private List<Subtitle> subtitles;
	
	/**  */
	@Transient
	private List<SubtitleDownload> subtitleDownloads;
	
	/**  */
	@Transient
	private List<Video> videos;
	
	/**  */
	@Transient
	private List<VideoDownload> videoDownloads;

}
