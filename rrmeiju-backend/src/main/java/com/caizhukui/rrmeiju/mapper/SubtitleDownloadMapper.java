package com.caizhukui.rrmeiju.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.SubtitleDownload;

/**
 * 字幕下载记录Mapper接口
 * 
 * @author caizhukui
 * @date 2017年5月10日
 */
public interface SubtitleDownloadMapper extends BaseMapper<SubtitleDownload> {
	
	/**
	 * 查询字幕下载记录的所有IP
	 * 
	 * @return Set<String>
	 * @author caizhukui
	 * @date 2017年6月6日
	 */
	Set<String> getAllIps();
	
	/**
	 * 根据用户UUID查询字幕下载记录
	 * 
	 * @param userUuid 用户UUID
	 * @return List<SubtitleDownload>
	 * @author caizhukui
	 * @date 2017年5月10日
	 */
	List<SubtitleDownload> getByUserUuid(String userUuid);
	
	/**
	 * 根据字幕UUID查询字幕下载记录
	 * 
	 * @param subtitleUuid 字幕UUID
	 * @return List<SubtitleDownload>
	 * @author caizhukui
	 * @date 2017年7月21日
	 */
	List<SubtitleDownload> getBySubtitleUuid(String subtitleUuid);
	
	/**
	 * 查询字幕下载量的全国地域分布数据
	 * 
	 * @return List<Map<String, Object>>
	 * @author caizhukui
	 * @date 2017年7月18日
	 */
	List<Map<String, Object>> getGeoData();
	/**
     * 根据ID查询字幕下载记录
     * 
     * @param id 字幕下载记录ID
     * @return SubtitleDownload 字幕下载记录
     * @author caizhukui
     * @date 2018年3月16日
     */
    @Override
    @Select(GET_BY_ID)
    @ResultMap(BASE_MAP)
    SubtitleDownload getById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID查询字幕下载记录
     * 
     * @param uuid 字幕下载记录UUID
     * @return SubtitleDownload 字幕下载记录
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Override
    @Select(GET_BY_UUID)
    @ResultMap(BASE_MAP)
    SubtitleDownload getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);
	
}
