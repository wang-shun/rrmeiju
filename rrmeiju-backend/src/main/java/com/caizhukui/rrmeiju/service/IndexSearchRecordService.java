package com.caizhukui.rrmeiju.service;

import java.util.Set;

import com.caizhukui.rrmeiju.model.IndexSearchRecord;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 服务接口
 *
 * @author caizhukui
 * @date 2017年3月11日
 */
public interface IndexSearchRecordService extends BaseService<IndexSearchRecord> {
	
	/**
	 * 查询搜索记录的所有IP
	 * 
	 * @return Set<String>
	 * @author caizhukui
	 * @date 2017年6月6日
	 */
	Set<String> getAllIps();

}
