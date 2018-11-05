package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.bo.CriteriaBO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.UserSerialMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.UserSerial;
import com.caizhukui.rrmeiju.service.UserSerialService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 用户美剧系列关联服务实现类
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Service
public class UserSerialServiceImpl extends BaseServiceImpl<UserSerial> implements UserSerialService {
    
    @Autowired
    private UserSerialMapper userSerialMapper;

    @Override
    public List<UserSerial> getByUserUuid(String userUuid) {
        return userSerialMapper.getByUserUuid(userUuid);
    }

    @Override
    public List<UserSerial> getBySerialUuid(String serialUuid) {
        return userSerialMapper.getBySerialUuid(serialUuid);
    }

    @Override
    public boolean existsByUserUuidAndSerialUuid(UserSerial userSerial) {
        return userSerialMapper.getCountByUserUuidAndSerialUuid(userSerial) == 1;
    }

    @Override
    public boolean deleteByUserUuidAndSerialUuid(UserSerial userSerial) {
        return userSerialMapper.deleteByUserUuidAndSerialUuid(userSerial) == 1;
    }

    @Override
    protected BaseMapper<UserSerial> getMapper() {
        return userSerialMapper;
    }

    @Override
    protected TableEnum getTable() {
        return TableEnum.USER_SERIAL;
    }

}
