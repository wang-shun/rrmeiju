package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import com.caizhukui.rrmeiju.model.UserFansub;

/**
 * 用户字幕组关联Mapper接口
 * 
 * @author caizhukui
 * @date 2018年4月29日
 */
public interface UserFansubMapper {
    
    /**
     * 根据用户UUID查询用户字幕组关联
     * 
     * @param userUuid 用户UUID
     * @return List<UserFansub>
     * @author caizhukui
     * @date 2018年4月29日
     */
    List<UserFansub> getByUserUuid(String userUuid);
    
    /**
     * 根据字幕组UUID查询用户字幕组关联
     * 
     * @param fansubUuid 字幕组UUID
     * @return List<UserFansub>
     * @author caizhukui
     * @date 2018年4月29日
     */
    List<UserFansub> getByFansubUuid(String fansubUuid);

}
