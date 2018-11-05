package com.caizhukui.rrmeiju.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 美剧系列实体类
 * 
 * @author caizhukui
 * @date 2017年1月26日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Serial extends BaseModel {

	private static final long serialVersionUID = 5418172646437682270L;
	
	/** 剧集在IMDB网站的ID */
	private String imdbId;
	
	/** 剧集在TV Maze网站的ID */
	private Integer tvmazeId;
	
	/** 剧集在The TV DB网站的ID */
    private Integer thetvdbId;
    
    /** 剧集在TV Rage网站的ID */
    private Integer tvrageId;
    
    /** 剧集官网主页URL */
    private String officialSiteUrl;
    
    /** 中文剧情简介 */
    private String chineseSummary;
    
    /** 英文剧情简介 */
    private String englishSummary;
    
    /** 剧集语言 */
    private String language;
    
    /** 原剧集名 */
    private String originalName;
	
	/** 英文剧集名 */
	private String englishName;
	
	/** 中文剧集名 */
	private String chineseName;
	
	/** 中文剧集别名 */
	private String chineseAlias;
	
	/** 剧集在epguides的英文名 */
	private String epguidesName;
	
	/** 每周播出日，英文逗号分隔的数字 */
	private String scheduleDays;
	
	/** 每天播出时间 */
	private String scheduleTime;
	
	/**  */
	private String tvmazeMediumImageUrl;
	
	/**  */
    private String tvmazeOriginalImageUrl;
	
	/** 中文剧集分类，英文逗号分隔 */
	private String chineseGenres;
	
	/** 英文剧集分类，英文逗号分隔 */
    private String englishGenres;
    
    /** 中文剧集状态 */
    private String chineseStatus;
    
    /** 英文剧集状态 */
    private String englishStatus;
    
    /** 中文剧集类型 */
    private String chineseType;
    
    /** 英文剧集类型 */
    private String englishType;
    
    /** 每集时长，单位分钟 */
    private Integer runtime;
	
	/** 电视台UUID */
	private String televisionUuid;
	
	/** 剧集是否已完结 */
	private Boolean finished;
	
	/** 剧集在TV Maze网站的URL */
	private String tvmazeUrl;
	
	/** 剧集在TV Maze网站的评分 */
	private Float tvmazeAverageRating;
	
	/**  */
	private Long tvmazeUpdatedTimestamp;
	
	/**  */
	private Integer tvmazeWeight;
	
	/** 剧集首播日期 */
	private Date premiereDate;
	
	/***************************************/
	
	/** 电视台信息 */
	@Transient
    private Television television;
    
    /**  */
	@Transient
    private List<Season> seasons;
		
}