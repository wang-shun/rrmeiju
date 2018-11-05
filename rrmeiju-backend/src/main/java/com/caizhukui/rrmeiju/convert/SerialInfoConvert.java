package com.caizhukui.rrmeiju.convert;

import java.util.List;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.response.serial.SerialInfoDTO;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Serial;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Component
public class SerialInfoConvert extends BaseConvert implements Convert<Serial, SerialInfoDTO> {

    @Override
    public SerialInfoDTO model2Dto(Serial model) {
        SerialInfoDTO dto = null;
        if (model != null) {
            dto = (SerialInfoDTO) serialConvert.model2Dto(model);
            List<Season> seasons = serviceFacade.getSeasonService().getBySerialUuid(model.getUuid());
            dto.setSeasons(seasonConvert.model2Dto(seasons));
        }
        return dto;
    }

    @Override
    public Serial dto2Model(SerialInfoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
