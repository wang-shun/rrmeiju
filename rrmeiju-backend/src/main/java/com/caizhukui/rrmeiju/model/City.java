package com.caizhukui.rrmeiju.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 城市实体类
 * 
 * @author caizhukui
 * @date 2017年3月15日
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class City extends BaseModel {

	private static final long serialVersionUID = 9171279588131780419L;
	
	/** 城市名称 */
	private String cityName;
	
	/** 行政级别 */
	private String level;
	
	/** 城市编码 */
	private String code;
	
	/** 所属省份ID */
	private String provinceId;

}
