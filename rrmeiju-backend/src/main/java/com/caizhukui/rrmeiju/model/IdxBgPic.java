package com.caizhukui.rrmeiju.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月14日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class IdxBgPic extends BaseModel {

	private static final long serialVersionUID = -7781041806518011101L;
	
	/** 文件URL */
	private String fileUrl;
	
}
