package com.caizhukui.rrmeiju.model;

import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 字幕组实体类
 * 
 * @author caizhukui
 * @date 2017年1月25日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Fansub extends BaseModel {

	private static final long serialVersionUID = -9139945367757768209L;
	
	/** 字幕组名称 */
	private String fansubName;

	/** 字幕组简介 */
	private String fansubInfo;
	
	/** 字幕组成立年份 */
	private String foundationYear;
	
	/** 字幕组徽标URL */
	private String logoUrl;
	
	/** 字幕组主页URL */
	private String homepageUrl;
	
	/** 字幕组官方微博URL */
	private String weiboUrl;
	
	/** 字幕组微信公众号 */
	private String wechat;
	
	/** 微信公众号二维码图片URL */
	private String wechatUrl;
	
	/** 字幕组公告 */
	private String bulletin;
	
	/***************************************/
	
	/**  */
	@Transient
	private List<Subtitle> subtitles;
	
	/**  */
	@Transient
	private List<UserFansub> userFansubs;
	
}
