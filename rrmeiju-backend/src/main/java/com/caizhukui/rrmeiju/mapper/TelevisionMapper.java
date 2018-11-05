package com.caizhukui.rrmeiju.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Television;

/**
 * 电视台Mapper接口
 * 
 * @author caizhukui
 * @date 2016年10月19日
 */
//@CacheNamespace
public interface TelevisionMapper extends BaseMapper<Television> {
	
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
	
    /**
     * 根据ID查询电视台
     * 
     * @param id 电视台ID
     * @return Television 电视台信息
     * @author caizhukui
     * @date 2018年3月16日
     */
	@Override
    @Select(GET_BY_ID)
    @ResultMap(BASE_MAP)
    Television getById(@Param("tableName") String tableName, @Param("id") Long id);
	
	/**
     * 根据UUID查询电视台
     * 
     * @param uuid 电视台UUID
     * @return Television 电视台信息
     * @author caizhukui
     * @date 2017年1月19日
     */
	@Override
	@Select(GET_BY_UUID)
	@ResultMap(BASE_MAP)
	Television getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);

}
