package com.caizhukui.rrmeiju.thirdparty.juhe;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Base Response
 * 
 * @author caizhukui
 * @date 2017年2月28日下午3:47:49
 */
@Data
public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 5707818335587475713L;
	
	/** 状态码 */
	@JsonProperty(value = "resultcode")
	private String resultCode;
	
	/** 返回说明 */
	private String reason;
	
	/** 返回码 */
	@JsonProperty(value = "error_code")
	private String errorCode;

}
