package com.caizhukui.rrmeiju.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.caizhukui.rrmeiju.model.UserSerial;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 用户美剧系列关联服务接口
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
public interface UserSerialService extends BaseService<UserSerial> {
    
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
     * 根据用户UUID和美剧系列UUID查询用户美剧系列关联是否存在
     * 
     * @param userSerial
     * @return boolean
     * @author caizhukui
     * @date 2018年5月25日
     */
    boolean existsByUserUuidAndSerialUuid(UserSerial userSerial);
    
    /**
     * 根据用户UUID和美剧系列UUID删除用户美剧系列关联
     * 
     * @param userSerial
     * @return boolean 删除是否成功
     * @author caizhukui
     * @date 2018年5月25日
     */
    @Async
    boolean deleteByUserUuidAndSerialUuid(UserSerial userSerial);

}
