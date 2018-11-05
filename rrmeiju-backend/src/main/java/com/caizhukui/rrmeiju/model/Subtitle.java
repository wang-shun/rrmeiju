package com.caizhukui.rrmeiju.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 字幕实体类
 * 
 * @author caizhukui
 * @date 2017年1月19日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Subtitle extends BaseModel {
	
	private static final long serialVersionUID = 9037628238897629594L;
	
	/** 字幕文件标题 */
	private String subtitleTitle;
	
	/** 字幕文件链接 */
	private String subtitleUrl;
	
	/** 字幕文件语言 */
	private String subtitleLang;
	
	/** 字幕文件格式 */
	private String fileFormat;
	
	/** 字幕文件大小，单位字节 */
	private long fileSize;
	
	/** 字幕文件MD5值 */
	private String fileMd5;
	
	/** 集UUID */
	private String episodeUuid;
	
	/** 季UUID */
	private String seasonUuid;
	
	/** 用户UUID */
	private String userUuid;
	
	/** 字幕组UUID */
	private String fansubUuid;
	
	/** 附加说明 */
	private String remark;
	
	/** 下载次数 */
	private int downloadCount;
	
	/** 上传时间 */
	private Date uploadTime;
	
	/** 是否已删除 */
	private boolean deleted;
	
	/***************************************/
	
	/**  */
	@Transient
    private Episode episode;
    
    /**  */
	@Transient
    private Season season;
    
    /**  */
	@Transient
    private User user;
    
    /**  */
	@Transient
    private Fansub fansub;
    
    /**  */
	@Transient
    private List<SubtitleFile> subtitleFiles;

}
