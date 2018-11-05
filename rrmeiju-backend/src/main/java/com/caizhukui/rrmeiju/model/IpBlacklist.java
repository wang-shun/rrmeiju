package com.caizhukui.rrmeiju.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * IP地址黑名单Model类
 * 
 * @author caizhukui
 * @date 2017年6月14日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class IpBlacklist extends BaseModel {

	private static final long serialVersionUID = 9215322962411266019L;
	
	/** IP地址ID */
	private String ipId;
	
	/** IP地址 */
	private String ip;
	
	/** 创建时间 */
	private Date createTime;
	
}
