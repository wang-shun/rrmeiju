package com.caizhukui.rrmeiju.test;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月17日下午2:27:55
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class SmsContext extends ChainContext {

	private static final long serialVersionUID = 1518576562530401628L;
	
	private List<String> messages;

}
