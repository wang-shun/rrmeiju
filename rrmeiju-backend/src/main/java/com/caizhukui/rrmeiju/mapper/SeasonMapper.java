package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Season;

/**
 * 美剧季度Mapper接口
 * 
 * @author caizhukui
 * @date 2016年10月20日
 */
public interface SeasonMapper extends BaseMapper<Season> {
	
	/**
	 * 根据美剧系列UUID查询季度数量
	 * 
	 * @param serialUuid 美剧系列UUID
	 * @return int
	 * @author caizhukui
	 * @date 2017年3月6日
	 */
	int getCountBySerialUuid(String serialUuid);
	
	/**
	 * 根据美剧系列UUID查询季度
	 * 
	 * @param serialUuid 美剧系列UUID
	 * @return List<Season> 该美剧系列的所有季度
	 * @author caizhukui
	 * @date 2017年1月13日
	 */
	List<Season> getBySerialUuid(String serialUuid);
	
	/**
	 * 根据字幕组UUID查询季度
	 * 
	 * @param fansubUuid 字幕组UUID
	 * @param limit
	 * @return List<Season>
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	List<Season> getByFansubUuid(@Param("fansubUuid") String fansubUuid, @Param("limit") int limit);
	
	/**
     * 根据ID查询美剧季
     * 
     * @param id 美剧季ID
     * @return Season 美剧季信息
     * @author caizhukui
     * @date 2018年3月16日
     */
    @Override
    @Select(GET_BY_ID)
    @ResultMap(BASE_MAP)
    Season getById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID查询美剧季
     * 
     * @param uuid 美剧季UUID
     * @return Season 美剧季信息
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Override
    @Select(GET_BY_UUID)
    @ResultMap(BASE_MAP)
    Season getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);

}
