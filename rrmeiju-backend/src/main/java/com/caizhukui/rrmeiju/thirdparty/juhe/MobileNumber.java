package com.caizhukui.rrmeiju.thirdparty.juhe;

import com.caizhukui.rrmeiju.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年2月28日
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MobileNumber extends BaseModel {
	
    private static final long serialVersionUID = -549747593235709344L;

    /** 手机号码 */
	private String phone;
	
	/** 省份 */
	private String province;
	
	/** 城市 */
	private String city;
	
	/** 区号 */
	@JsonProperty(value = "areacode")
	private String areaCode;
	
	/** 邮编 */
	private String zip;
	
	/** 运营商（移动、联通、电信） */
	private String company;
	
	/** 卡类型 */
	private String card;

}
