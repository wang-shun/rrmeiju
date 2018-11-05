package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.EpisodeDTO;
import com.caizhukui.rrmeiju.model.Episode;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年6月10日
 */
@Component
public class EpisodeConvert implements Convert<Episode, EpisodeDTO> {

    @Override
    public EpisodeDTO model2Dto(Episode model) {
        EpisodeDTO dto = null;
        if (model != null) {
            dto = new EpisodeDTO();
            dto.setUuid(model.getUuid());
            dto.setEpisodeIndex(model.getEpisodeIndex());
            dto.setEpisodeName(model.getEpisodeName());
            dto.setAirDate(model.getAirDate());
            dto.setSeasonUuid(model.getSeasonUuid());
        }
        return dto;
    }

    @Override
    public Episode dto2Model(EpisodeDTO dto) {
        Episode model = null;
        if (dto != null) {
            model = new Episode();
            model.setUuid(dto.getUuid());
            model.setEpisodeIndex(dto.getEpisodeIndex());
            model.setEpisodeName(dto.getEpisodeName());
            model.setAirDate(dto.getAirDate());
            model.setSeasonUuid(dto.getSeasonUuid());
        }
        return model;
    }

}
