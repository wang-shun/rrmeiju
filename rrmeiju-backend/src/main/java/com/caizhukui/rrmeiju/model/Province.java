package com.caizhukui.rrmeiju.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 省份实体类
 * 
 * @author caizhukui
 * @date 2017年3月15日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Province extends BaseModel {

	private static final long serialVersionUID = 305882071400999897L;
	
	/** 省份中文名 */
	private String provinceNameChinese;
	
	/** 省份中文简称 */
	private String provinceAbbrChinese;
	
	/** 省份英文名 */
	private String provinceNameEnglish;
	
	/** 省份英文简称 */
	private String provinceAbbrEnglish;
	
	/** 省份代码 */
	private String code;
	
	/** 省会城市 */
	private String capital;

}
