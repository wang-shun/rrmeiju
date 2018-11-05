package com.caizhukui.rrmeiju.mapper;

import java.util.Set;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.IndexSearchRecord;

/**
 * 
 *
 * @author caizhukui
 * @date 2017年3月11日
 */
public interface IndexSearchRecordMapper extends BaseMapper<IndexSearchRecord> {
	
	/**
	 * 查询搜索记录的所有IP
	 * 
	 * @return Set<String>
	 * @author caizhukui
	 * @date 2017年6月6日
	 */
	Set<String> getAllIps();
	
}
