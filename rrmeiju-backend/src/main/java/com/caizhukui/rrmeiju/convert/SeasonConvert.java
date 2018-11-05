package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.SeasonDTO;
import com.caizhukui.rrmeiju.model.Season;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Component
public class SeasonConvert implements Convert<Season, SeasonDTO> {

    @Override
    public SeasonDTO model2Dto(Season model) {
        SeasonDTO dto = null;
        if (model != null) {
            dto = new SeasonDTO();
            dto.setUuid(model.getUuid());
            dto.setEnglishName(model.getEnglishName());
            dto.setChineseName(model.getChineseName());
            dto.setSerialUuid(model.getSerialUuid());
            dto.setPremiereDate(model.getPremiereDate());
            dto.setEpisodeCount(model.getEpisodeCount());
            dto.setSeasonIndex(model.getSeasonIndex());
            dto.setPosterUrl(model.getPosterUrl());
            dto.setDoubanId(model.getDoubanId());
            dto.setDoubanUrl(model.getDoubanUrl());
            dto.setDoubanRating(model.getDoubanRating());
            dto.setSummary(model.getSummary());
            dto.setDirectors(model.getDirectors());
            dto.setCasts(model.getCasts());
            dto.setCountries(model.getCountries());
            dto.setGenres(model.getGenres());
        }
        return dto;
    }

    @Override
    public Season dto2Model(SeasonDTO dto) {
        Season model = null;
        if (dto != null) {
            model = new Season();
            model.setUuid(dto.getUuid());
            model.setEnglishName(dto.getEnglishName());
            model.setChineseName(dto.getChineseName());
            model.setSerialUuid(dto.getSerialUuid());
            model.setPremiereDate(dto.getPremiereDate());
            model.setEpisodeCount(dto.getEpisodeCount());
            model.setSeasonIndex(dto.getSeasonIndex());
            model.setPosterUrl(dto.getPosterUrl());
            model.setDoubanId(dto.getDoubanId());
            model.setDoubanUrl(dto.getDoubanUrl());
            model.setDoubanRating(dto.getDoubanRating());
            model.setSummary(dto.getSummary());
            model.setDirectors(dto.getDirectors());
            model.setCasts(dto.getCasts());
            model.setCountries(dto.getCountries());
            model.setGenres(dto.getGenres());
        }
        return model;
    }

}
