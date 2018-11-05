package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.TelevisionDTO;
import com.caizhukui.rrmeiju.model.Television;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Component
public class TelevisionConvert implements Convert<Television, TelevisionDTO> {

    @Override
    public TelevisionDTO model2Dto(Television model) {
        TelevisionDTO dto = null;
        if (model != null) {
            dto = new TelevisionDTO();
            dto.setUuid(model.getUuid());
            dto.setTelevisionName(model.getTelevisionName());
            dto.setTelevisionInfo(model.getTelevisionInfo());
            dto.setHomepageUrl(model.getHomepageUrl());
            dto.setLogoUrl(model.getLogoUrl());
        }
        return dto;
    }

    @Override
    public Television dto2Model(TelevisionDTO dto) {
        Television model = null;
        if (dto != null) {
            model = new Television();
            model.setUuid(dto.getUuid());
            model.setTelevisionName(dto.getTelevisionName());
            model.setTelevisionInfo(dto.getTelevisionInfo());
            model.setHomepageUrl(dto.getHomepageUrl());
            model.setLogoUrl(dto.getLogoUrl());
        }
        return model;
    }

}
