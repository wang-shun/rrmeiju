package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Serial;

/**
 * 美剧系列Mapper接口
 * 
 * @author caizhukui
 * @date 2016年10月19日
 */
public interface SerialMapper extends BaseMapper<Serial> {
	
	/**
	 * 查询某一用户关注的所有美剧系列
	 * 
	 * @param userUuid 用户UUID
	 * @return List<Serial>
	 * @author caizhukui
	 * @date 2017年1月26日
	 */
	List<Serial> getByUserUuid(String userUuid);
	
	/**
	 * 查询某一电视台拥有的所有美剧系列
	 * 
	 * @param televisionUuid 电视台UUID
	 * @return List<Serial>
	 * @author caizhukui
	 * @date 2017年10月19日
	 */
	List<Serial> getByTelevisionUuid(String televisionUuid);
	
	/**
	 * 用户关注剧集
	 * 
	 * @param userUuid 用户UUID
	 * @param uuid 剧集UUID
	 * @author caizhukui
	 * @date 2017年1月26日
	 */
	void followSerial(@Param("userUuid") String userUuid, @Param("uuid") String uuid);
	
	/**
	 * 用户取消关注剧集
	 * 
	 * @param userUuid 用户UUID
	 * @param uuid 剧集UUID
	 * @author caizhukui
	 * @date 2017年4月22日
	 */
	void cancelFollowSerial(@Param("userUuid") String userUuid, @Param("uuid") String uuid);
	
	/**
	 * 查询用户是否关注剧集
	 * 
	 * @param userUuid 用户UUID
	 * @param uuid 剧集UUID
	 * @return int
	 * @author caizhukui
	 * @date 2017年1月26日
	 */
	int getFollowSerialCount(@Param("userUuid") String userUuid, @Param("uuid") String uuid);
	
	 /**
     * 根据ID查询美剧季
     * 
     * @param id 美剧季ID
     * @return Serial 美剧季信息
     * @author caizhukui
     * @date 2018年3月16日
     */
    @Override
    @Select(GET_BY_ID)
    @ResultMap(BASE_MAP)
    Serial getById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID查询美剧季
     * 
     * @param uuid 美剧季UUID
     * @return Serial 美剧季信息
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Override
    @Select(GET_BY_UUID)
    @ResultMap(BASE_MAP)
    Serial getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);
	
}
