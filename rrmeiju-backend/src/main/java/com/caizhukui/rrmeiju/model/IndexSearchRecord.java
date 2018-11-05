package com.caizhukui.rrmeiju.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 *
 * @author caizhukui
 * @date 2017年3月11日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class IndexSearchRecord extends BaseModel {
	
	private static final long serialVersionUID = 2686307773312433477L;
	
	/** 用户ID */
	private String userId;
	
	/** 客户端IP地址 */
	private String remoteIp;
	
	/** 搜索关键字 */
	private String keyword;

}
