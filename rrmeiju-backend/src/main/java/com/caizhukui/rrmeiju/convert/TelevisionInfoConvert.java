package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.response.television.TelevisionInfoDTO;
import com.caizhukui.rrmeiju.model.Television;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Component
public class TelevisionInfoConvert extends BaseConvert implements Convert<Television, TelevisionInfoDTO> {

    @Override
    public TelevisionInfoDTO model2Dto(Television model) {
        TelevisionInfoDTO dto = null;
        if (model != null) {
            dto = (TelevisionInfoDTO) televisionConvert.model2Dto(model);
            dto.setSerials(serialConvert.model2Dto(model.getSerials()));
        }
        return dto;
    }

    @Override
    public Television dto2Model(TelevisionInfoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
