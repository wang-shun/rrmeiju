package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.SeasonDTO;
import com.caizhukui.rrmeiju.dto.SerialDTO;
import com.caizhukui.rrmeiju.dto.response.episode.EpisodeInfoDTO;
import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Serial;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年6月10日
 */
@Component
public class EpisodeInfoConvert extends BaseConvert implements Convert<Episode, EpisodeInfoDTO> {

    @Override
    public EpisodeInfoDTO model2Dto(Episode model) {
        EpisodeInfoDTO episodeInfoDTO = new EpisodeInfoDTO();
        // episodeInfoDTO.setEpisodeId(episode.getEpisodeId());
        episodeInfoDTO.setEpisodeIndex(model.getEpisodeIndex());
        // episodeInfoDTO.setEpisodeName(episode.getEpisodeName());
        // episodeInfoDTO.setAirDate(episode.getAirDate());
        String seasonUuid = model.getSeasonUuid();
        Season season = serviceFacade.getSeasonService().getByUuid(seasonUuid);
        // 只返回需要的数据
        SeasonDTO seasonDTO = new SeasonDTO();
        seasonDTO.setUuid(season.getUuid());
        seasonDTO.setSeasonIndex(season.getSeasonIndex());
        // seasonDTO.setSeasonNameChinese(season.getSeasonNameChinese());
        // seasonDTO.setSeasonNameEnglish(season.getSeasonNameEnglish());
        episodeInfoDTO.setSeason(seasonDTO);
        String serialId = season.getSerialUuid();
        Serial serial = serviceFacade.getSerialService().getByUuid(serialId);
        SerialDTO serialDTO = new SerialDTO();
        serialDTO.setChineseName(serial.getChineseName());
        serialDTO.setEnglishName(serial.getEnglishName());
        episodeInfoDTO.setSerial(serialDTO);
        return episodeInfoDTO;
    }

    @Override
    public Episode dto2Model(EpisodeInfoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
