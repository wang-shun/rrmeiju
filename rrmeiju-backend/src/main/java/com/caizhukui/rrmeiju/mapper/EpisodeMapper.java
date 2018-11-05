package com.caizhukui.rrmeiju.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Episode;

/**
 * 美剧集Mapper接口
 * 
 * @author caizhukui
 * @date 2016年10月20日
 */
public interface EpisodeMapper extends BaseMapper<Episode> {
    
    /**
     * 批量新增美剧集
     * 
     * @param episodes
     * @author caizhukui
     * @date 2018年5月4日
     */
    void batchAdd(List<Episode> episodes);
	
	/**
	 * 根据美剧季UUID查询集数
	 * 
	 * @param seasonUuid 美剧季UUID
	 * @return int
	 * @author caizhukui
	 * @date 2017年3月6日
	 */
	int getCountBySeasonUuid(String seasonUuid);
	
	/**
	 * 根据美剧季UUID和第几集查询集信息
	 * 
	 * @param seasonUuid 美剧季UUID
	 * @param episodeIndex 第几集
	 * @return Episode
	 * @author caizhukui
	 * @date 2017年7月12日
	 */
	Episode getBySeasonUuidAndEpisodeIndex(@Param("seasonUuid") String seasonUuid, @Param("episodeIndex") int episodeIndex);
	
	/**
	 * 查询某一季的所有集
	 * 
	 * @param seasonUuid 美剧季UUID
	 * @return List<Episode>
	 * @author caizhukui
	 * @date 2017年1月17日
	 */
	List<Episode> getBySeasonUuid(String seasonUuid);
	
	/**
	 * 查询某一天播出的所有剧集
	 * 
	 * @param airDate 播出日期
	 * @return List<Episode>
	 * @author caizhukui
	 * @date 2017年6月15日
	 */
	List<Episode> getByAirDate(Date airDate);
	
	 /**
     * 根据ID查询美剧集
     * 
     * @param id 美剧集ID
     * @return Episode 美剧集信息
     * @author caizhukui
     * @date 2018年3月16日
     */
    @Override
    @Select(GET_BY_ID)
    @ResultMap("baseMap")
    Episode getById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID查询美剧集
     * 
     * @param uuid 美剧集UUID
     * @return Episode 美剧集信息
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Override
    @Select(GET_BY_UUID)
    @ResultMap("baseMap")
    Episode getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);

}
