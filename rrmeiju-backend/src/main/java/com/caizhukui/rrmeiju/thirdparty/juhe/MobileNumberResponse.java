package com.caizhukui.rrmeiju.thirdparty.juhe;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年2月28日下午3:49:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MobileNumberResponse extends BaseResponse {

	private static final long serialVersionUID = -5820273207047731251L;

	/** 返回结果集 */
	private MobileNumber result;

}
