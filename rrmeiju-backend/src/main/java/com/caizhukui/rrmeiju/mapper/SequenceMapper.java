package com.caizhukui.rrmeiju.mapper;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月16日
 */
public interface SequenceMapper {
	
	/**
	 * 获取下一个可用的序列值
	 * 
	 * @param sequenceName 序列名
	 * @return int 序列值
	 * @author caizhukui
	 * @date 2017年6月16日下午3:42:12
	 */
	int getNextVal(String sequenceName);

}
