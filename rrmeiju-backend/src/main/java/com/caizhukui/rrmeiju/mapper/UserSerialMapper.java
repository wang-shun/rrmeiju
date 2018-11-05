package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.UserSerial;

/**
 * 用户美剧系列关联Mapper接口
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
public interface UserSerialMapper extends BaseMapper<UserSerial> {
    
    /**
     * 根据用户UUID查询用户美剧系列关联
     * 
     * @param userUuid 用户UUID
     * @return List<UserSerial>
     * @author caizhukui
     * @date 2018年4月29日
     */
    List<UserSerial> getByUserUuid(String userUuid);
    
    /**
     * 根据美剧系列UUID查询用户美剧系列关联
     * 
     * @param serialUuid 美剧系列UUID
     * @return List<UserSerial>
     * @author caizhukui
     * @date 2018年4月29日
     */
    List<UserSerial> getBySerialUuid(String serialUuid);
    
    /**
     * 根据用户UUID和美剧系列UUID查询用户美剧系列关联数量
     * 
     * @param userSerial
     * @return int
     * @author caizhukui
     * @date 2018年5月25日
     */
    int getCountByUserUuidAndSerialUuid(UserSerial userSerial);
    
    /**
     * 根据用户UUID和美剧系列UUID删除用户美剧系列关联
     * 
     * @param userSerial
     * @return int 受影响的记录数
     * @author caizhukui
     * @date 2018年5月25日
     */
    int deleteByUserUuidAndSerialUuid(UserSerial userSerial);

}
