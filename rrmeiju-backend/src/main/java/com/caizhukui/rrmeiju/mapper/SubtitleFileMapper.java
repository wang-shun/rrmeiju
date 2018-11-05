package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.SubtitleFile;

/**
 * 字幕文件Mapper接口
 * 
 * @author caizhukui
 * @date 2017年3月17日
 */
public interface SubtitleFileMapper extends BaseMapper<SubtitleFile> {
	
	/**
	 * 根据字幕UUID查询字幕文件
	 * 
	 * @param subtitleUuid 字幕UUID
	 * @return List<SubtitleFile>
	 * @author caizhukui
	 * @date 2017年3月17日
	 */
	List<SubtitleFile> getBySubtitleUuid(String subtitleUuid);
	
	/**
     * 根据ID查询字幕文件
     * 
     * @param id 字幕文件ID
     * @return SubtitleFile 字幕文件信息
     * @author caizhukui
     * @date 2018年3月16日
     */
    @Override
    @Select(GET_BY_ID)
    @ResultMap(BASE_MAP)
    SubtitleFile getById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID查询字幕文件
     * 
     * @param uuid 字幕文件UUID
     * @return Subtitle 字幕文件信息
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Override
    @Select(GET_BY_UUID)
    @ResultMap(BASE_MAP)
    SubtitleFile getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);
	
}
