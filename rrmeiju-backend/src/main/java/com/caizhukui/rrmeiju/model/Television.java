package com.caizhukui.rrmeiju.model;

import java.util.List;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 电视台实体类
 * 
 * @author caizhukui
 * @date 2017年1月26日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Television extends BaseModel {

	private static final long serialVersionUID = 8226853941418083824L;
	
	/** 电视台名称 */
	private String televisionName;
	
	/** 电视台简介 */
	private String televisionInfo;
	
	/** 电视台官网主页URL */
	private String homepageUrl;
	
	/** 电视台标志URL */
	private String logoUrl;
	
	/***************************************/
	
	/** 电视台旗下的所有剧集 */
	@Transient
	private List<Serial> serials;
	
}
