package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Subtitle;

/**
 * 字幕Mapper接口
 * 
 * @author caizhukui
 * @date 2017年1月19日
 */
@CacheNamespace
public interface SubtitleMapper extends BaseMapper<Subtitle> {
	
	/**
	 * 查询某一字幕组上传的字幕数量
	 * 
	 * @param fansubUuid 字幕组UUID
	 * @return int 该字幕组上传的字幕数量
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	int getCountByFansubUuid(String fansubUuid);

    /**
     * 查询某一字幕组上传的所有字幕
     * 
     * @param fansubUuid 字幕组UUID
     * @return List<Subtitle> 该字幕组上传的所有字幕
     * @author caizhukui
     * @date 2017年4月29日
     */
    List<Subtitle> getByFansubUuid(String fansubUuid);
    
	/**
	 * 查询某一用户上传的字幕数量
	 * 
	 * @param userUuid 用户UUID
	 * @return int 该用户上传的字幕数量
	 * @author caizhukui
	 * @date 2017年5月8日
	 */
	int getCountByUserUuid(String userUuid);
	
	/**
	 * 查询某一用户上传的所有字幕
	 * 
	 * @param userUuid 用户UUID
	 * @return List<Subtitle> 该用户上传的所有字幕
	 * @author caizhukui
	 * @date 2018年4月29日
	 */
	List<Subtitle> getByUserUuid(String userUuid);
	
	/**
	 * 根据文件MD5查询字幕信息
	 * 
	 * @param fileMd5 字幕文件MD5值
	 * @return Subtitle 字幕信息
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	Subtitle getByFileMd5(String fileMd5);
	
	/**
	 * 根据字幕标题查询字幕信息
	 * 
	 * @param subtitleTitle 字幕标题
	 * @return List<Subtitle>
	 * @author caizhukui
	 * @date 2017年1月19日
	 */
	List<Subtitle> getByTitle(String subtitleTitle);
	
	/**
	 * 查询某一剧集的所有字幕
	 * 
	 * @param episodeUuid 集UUID
	 * @return List<Subtitle>
	 * @author caizhukui
	 * @date 2017年1月19日
	 */
	List<Subtitle> getByEpisodeUuid(String episodeUuid);
	
	/**
	 * 分页查询某一用户关注的剧集的所有字幕
	 * 
	 * @param userId 用户ID
	 * @param pageSize 每页记录数
	 * @param startIndex 第几页
	 * @return List<Subtitle>
	 * @author caizhukui
	 * @date 2017年6月13日
	 */
	List<Subtitle> getUserFollowSubtitlesPaginated(@Param("userId") String userId, 
	        @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
	
	/**
	 * 更新downloadCount，自增1
	 * 
	 * @param subtitleId
	 * @author caizhukui
	 * @date 2017年3月8日
	 */
	void increaseDownloadCount(String subtitleId);
	
	/**
	 * 查询最近一周（当前日期的前7天）内下载次数最多的字幕
	 * 
	 * @return List<Subtitle>
	 * @author caizhukui
	 * @date 2017年10月14日
	 */
	List<Subtitle> getMostDownloadedSubtitlesOfLastWeek();
	
	/**
     * 根据ID查询字幕
     * 
     * @param id 字幕ID
     * @return Subtitle 字幕信息
     * @author caizhukui
     * @date 2018年3月16日
     */
    @Override
    @Select(GET_BY_ID)
    @ResultMap(BASE_MAP)
    Subtitle getById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID查询字幕
     * 
     * @param uuid 字幕UUID
     * @return Subtitle 字幕信息
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Override
    @Select(GET_BY_UUID)
    @ResultMap(BASE_MAP)
    Subtitle getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);
	
}
