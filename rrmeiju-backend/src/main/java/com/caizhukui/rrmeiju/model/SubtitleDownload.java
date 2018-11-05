package com.caizhukui.rrmeiju.model;

import java.util.Date;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 字幕下载记录实体类
 * 
 * @author caizhukui
 * @date 2017年5月10日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SubtitleDownload extends BaseModel {

	private static final long serialVersionUID = 8705741451940306349L;
	
	/** 字幕UUID */
	private String subtitleUuid;
	
	/** 用户UUID */
	private String userUuid;
	
	/** 客户端IP地址 */
	private String remoteIp;
	
	/** 下载时间 */
	private Date downloadTime;
	
	/***************************************/
	
	/** 字幕信息 */
	@Transient
	private Subtitle subtitle;
	
	/** 用户信息 */
	@Transient
	private User user;

}
