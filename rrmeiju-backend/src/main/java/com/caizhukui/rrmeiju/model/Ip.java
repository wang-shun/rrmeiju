package com.caizhukui.rrmeiju.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * IP地址实体类
 * 
 * @author caizhukui
 * @date 2017年6月6日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Ip extends BaseModel {
	
	private static final long serialVersionUID = 3759464677552785328L;
	
	/** IP地址 */
	private String ip;
	
	/** IP地址所在国家 */
	private String country;
	
	/** IP地址所在省份 */
	private String province;
	
	/** IP地址所在城市 */
	private String city;
	
	/** IP地址所属运营商 */
	private String operator;

}
