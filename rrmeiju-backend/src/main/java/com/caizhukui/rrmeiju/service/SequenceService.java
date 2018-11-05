package com.caizhukui.rrmeiju.service;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月16日
 */
public interface SequenceService {
	
	/**
	 * 获取下一个可用的序列值
	 * 
	 * @param sequenceName 序列名
	 * @return int 序列值
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	int getNextVal(String sequenceName);

}
