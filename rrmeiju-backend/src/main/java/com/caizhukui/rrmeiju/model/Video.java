package com.caizhukui.rrmeiju.model;

import java.util.Date;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 视频实体类
 * 
 * @author caizhukui
 * @date 2017年7月8日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Video extends BaseModel {
	
    private static final long serialVersionUID = 253675762661320149L;
	
	/** 视频文件名 */
	private String videoTitle;
	
	/** 视频文件链接 */
	private String videoUrl;
	
	/** 内嵌字幕语言，多个值之间用英文逗号分隔 */
	private String subtitleLang;
	
	/** 视频文件格式 */
	private String videoFormat;
	
	/** 视频所在平台，如百度网盘、哔哩哔哩等 */
	private String videoSource;
	
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
	
	/** 观看次数 */
	private int viewCount;
	
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

}
