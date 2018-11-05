package com.caizhukui.rrmeiju.service;

import java.util.List;
import java.util.Map;

import com.caizhukui.rrmeiju.model.Television;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 电视台服务接口
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
public interface TelevisionService extends BaseService<Television> {
	
	/**
	 * 查询所有电视台名称
	 * 
	 * @return List<String>
	 * @author caizhukui
	 * @date 2016年12月14日
	 */
	List<String> getAllTelevisionNames();
	
	/**
	 * 查询所有电视台旗下的美剧数量
	 * 
	 * @return List<Map<String, Object>>
	 * @author caizhukui
	 * @date 2016年12月14日
	 */
	List<Map<String, Object>> getAllTelevisionSerialCount();
	
}
