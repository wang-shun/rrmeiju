package com.caizhukui.rrmeiju.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 美剧季度实体类
 * 
 * @author caizhukui
 * @date 2017年1月13日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Season extends BaseModel {
	
	private static final long serialVersionUID = -303728057602697809L;
	
	/** 系列UUID */
	private String serialUuid;
	
	/** 英文名 */
	private String englishName;
	
	/** 中文名 */
	private String chineseName;
	
	/** 第几季 */
	private Integer seasonIndex;
	
	/** 首播日期 */
	private Date premiereDate;
	
	/** 本季集数 */
	private Integer episodeCount;
	
	/** 海报链接URL */
	private String posterUrl;
	
	/** 季是否已完结 */
	private Boolean finished;
	
	/** 季在豆瓣的ID */
	private String doubanId;
	
	/** 豆瓣条目页URL */
	private String doubanUrl;
	
	/** TV Maze网站本季链接 */
	private String tvmazeUrl;
	
	/** 豆瓣评分 */
	private Float doubanRating;
	
	/** 简介 */
	private String summary;
	
	/** 导演 */
	private String directors;
	
	/** 主演 */
	private String casts;

	/** 制片国家/地区 */
	private String countries;
	
	/** 类型 */
	private String genres;
	
	/***************************************/
	
	/** 系列信息 */
	@Transient
    private Serial serial;
    
    /**  */
	@Transient
    private List<Episode> episodes;
	
}
