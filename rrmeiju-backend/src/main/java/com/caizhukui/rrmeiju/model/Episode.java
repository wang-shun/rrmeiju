package com.caizhukui.rrmeiju.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 美剧集实体类
 * 
 * @author caizhukui
 * @date 2017年1月13日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Episode extends BaseModel implements Comparable<Episode> {

	private static final long serialVersionUID = 8932627521676285544L;
	
	/** 剧集在TV Maze网站的ID */
	private Integer tvmazeShowId;
	
	/** 第几季 */
	private Integer seasonIndex;
	
	/** 第几集 */
	private Integer episodeIndex;
	
	/** 分集标题 */
	private String episodeName;
	
	/** 英文本集剧情简介 */
	private String englishSummary;
	
	/** 中文本集剧情简介 */
	private String chineseSummary;
	
	/** 本集时长，单位分钟 */
	private Integer runtime;
	
	/** 本集在TV Maze网站的链接 */
	private String tvmazeUrl;
	
	/** 季度UUID */
	private String seasonUuid;
	
	/** 播出日期 */
	private Date airDate;
	
	/** 播出时间 */
	private String airTime;
	
	/**  */
	private Date airStamp;
	
	/***************************************/
	
	/**  */
	@Transient
	private Season season;
	
	/**  */
	@Transient
	private List<Subtitle> subtitles;
	
	/**  */
	@Transient
	private List<Video> videos;

	@Override
	public int compareTo(Episode o) {
		// 自定义排序规则，根据episode_index正序排序
		if (this.getEpisodeIndex() > o.getEpisodeIndex()) {
			return 1;
		} else if (this.getEpisodeIndex() < o.getEpisodeIndex()) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
