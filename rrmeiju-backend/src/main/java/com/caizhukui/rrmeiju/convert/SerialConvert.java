package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.SerialDTO;
import com.caizhukui.rrmeiju.model.Serial;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Component
public class SerialConvert implements Convert<Serial, SerialDTO> {

    @Override
    public SerialDTO model2Dto(Serial model) {
        SerialDTO dto = new SerialDTO();
        dto.setUuid(model.getUuid());
        dto.setEnglishName(model.getEnglishName());
        dto.setChineseName(model.getChineseName());
        dto.setChineseAlias(model.getChineseAlias());
        dto.setTelevisionUuid(model.getTelevisionUuid());
        return dto;
    }

    @Override
    public Serial dto2Model(SerialDTO dto) {
        Serial model = null;
        if (dto != null) {
            model = new Serial();
            model.setUuid(dto.getUuid());
            model.setEnglishName(dto.getEnglishName());
            model.setChineseName(dto.getChineseName());
            model.setChineseAlias(dto.getChineseAlias());
            model.setTelevisionUuid(dto.getTelevisionUuid());
        }
        return model;
    }

}
