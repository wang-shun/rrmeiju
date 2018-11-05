package com.caizhukui.rrmeiju.model;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 字幕文件实体类
 * 
 * @author caizhukui
 * @date 2017年3月17日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class SubtitleFile extends BaseModel {

	private static final long serialVersionUID = -2286060366857892216L;
	
	/** 字幕文件名称 */
	private String fileName;
	
	/** 字幕文件大小，单位字节 */
	private long fileSize;
	
	/** 字幕UUID */
	private String subtitleUuid;
	
	/***************************************/
	
	/** 字幕信息 */
	@Transient
    private Subtitle subtitle;

}
