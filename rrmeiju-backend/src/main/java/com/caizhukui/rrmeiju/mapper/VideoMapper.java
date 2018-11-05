package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Video;

/**
 * 视频Mapper接口
 * 
 * @author caizhukui
 * @date 2017年7月8日
 */
public interface VideoMapper extends BaseMapper<Video> {
	
	/**
	 * 根据美剧集UUID查询视频信息
	 * 
	 * @param episodeUuid 美剧集UUID
	 * @return List<Video>
	 * @author caizhukui
	 * @date 2017年7月8日
	 */
	List<Video> getByEpisodeUuid(String episodeUuid);
	
	/**
	 * 根据剧名、第几季和第几集查询视频信息
	 * 
	 * @param serialName 中文或英文剧名
	 * @param seasonIndex 第几季
	 * @param episodeIndex 第几集
	 * @return List<Video>
	 * @author caizhukui
	 * @date 2017年8月2日
	 */
	List<Video> getBySerialNameAndIndex(@Param("serialName") String serialName, 
	        @Param("seasonIndex") int seasonIndex, @Param("episodeIndex") int episodeIndex);
	
	/**
     * 根据ID查询视频
     * 
     * @param id 视频ID
     * @return Video 视频信息
     * @author caizhukui
     * @date 2018年3月16日
     */
    @Override
    @Select(GET_BY_ID)
    @ResultMap(BASE_MAP)
    Video getById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID查询视频
     * 
     * @param uuid 视频UUID
     * @return Video 视频信息
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Override
    @Select(GET_BY_UUID)
    @ResultMap(BASE_MAP)
    Video getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);
	
}
