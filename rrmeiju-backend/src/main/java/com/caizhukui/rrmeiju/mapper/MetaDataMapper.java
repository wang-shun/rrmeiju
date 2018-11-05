package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;

/**
 * 数据库元数据Mapper接口
 * 
 * @author caizhukui
 * @date 2016年10月31日
 */
@CacheNamespace
public interface MetaDataMapper {
	
	/**
	 * 根据表名查询该表所有字段名
	 * 
	 * @param tableName 表名
	 * @return List<String> 该表所有字段名
	 * @author caizhukui
	 * @date 2017年1月26日
	 */
	List<String> getColumnNamesOfTable(String tableName);

}
