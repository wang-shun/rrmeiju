package com.caizhukui.rrmeiju.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年7月3日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MobileLocale extends BaseModel {
	
    private static final long serialVersionUID = 7670268439894262910L;
	
	/**  */
	private String mobileSegment;
	
	/**  */
	private String mobileArea;
	
	/**  */
	private String province;
	
	/**  */
	private String city;
	
	/**  */
	private String mobileType;
	
	/**  */
	private String operator;
	
	/**  */
	private String areaCode;
	
	/**  */
	private String postCode;

}
