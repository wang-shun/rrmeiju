package com.caizhukui.rrmeiju.model;

import java.util.Date;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 资讯实体类
 * 
 * @author caizhukui
 * @date 2017年9月12日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class News extends BaseModel {
	
	private static final long serialVersionUID = 3589525060919524437L;
	
	/** 资讯标题 */
	private String newsTitle;
	
	/** 资讯内容 */
	private String newsContent;
	
	/** 关键词 */
	private String keywords;
	
	/** 用户ID */
	private String userId;
	
	/** 季度ID */
	private String seasonId;
	
	/** 创建时间 */
	private Date createTime;
	
	/***************************************/
	
	/**  */
	@Transient
	private Season season;

}
