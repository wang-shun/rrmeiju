package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.UserSerialDTO;
import com.caizhukui.rrmeiju.model.UserSerial;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Component
public class UserSerialConvert implements Convert<UserSerial, UserSerialDTO> {

    @Override
    public UserSerialDTO model2Dto(UserSerial model) {
        UserSerialDTO dto = null;
        if (model != null) {
            dto = new UserSerialDTO();
            dto.setUserUuid(model.getUserUuid());
            dto.setSerialUuid(model.getSerialUuid());
            dto.setFollowTime(model.getFollowTime());
        }
        return dto;
    }

    @Override
    public UserSerial dto2Model(UserSerialDTO dto) {
        UserSerial model = null;
        if (dto != null) {
            model = new UserSerial();
            model.setUserUuid(dto.getUserUuid());
            model.setSerialUuid(dto.getSerialUuid());
            model.setFollowTime(dto.getFollowTime());
        }
        return model;
    }

}
