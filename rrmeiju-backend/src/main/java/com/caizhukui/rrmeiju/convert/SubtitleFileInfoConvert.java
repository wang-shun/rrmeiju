package com.caizhukui.rrmeiju.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.SubtitleFileDTO;
import com.caizhukui.rrmeiju.dto.response.subtitle.SubtitleFileInfoDTO;
import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Fansub;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.SubtitleFile;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年6月11日
 */
@Component
public class SubtitleFileInfoConvert extends BaseConvert implements Convert<Subtitle, SubtitleFileInfoDTO> {

    @Override
    public SubtitleFileInfoDTO model2Dto(Subtitle model) {
        SubtitleFileInfoDTO dto = null;
        if (model != null) {
            dto = new SubtitleFileInfoDTO();
            String uuid = model.getUuid();
            dto.setSubtitleUuid(uuid);
            dto.setSubtitleTitle(model.getSubtitleTitle());
            dto.setSubtitleUrl(model.getSubtitleUrl());
            dto.setSubtitleLang(model.getSubtitleLang());
            dto.setFileFormat(model.getFileFormat());
            dto.setFileSize(model.getFileSize());
            // 字幕文件信息
            List<SubtitleFile> subtitleFiles = serviceFacade.getSubtitleFileService().getBySubtitleUuid(uuid);
            List<SubtitleFileDTO> subtitleFileDTOs = new ArrayList<SubtitleFileDTO>();
            for (SubtitleFile subtitleFile : subtitleFiles) {
                subtitleFileDTOs.add(subtitleFileConvert.model2Dto(subtitleFile));
            }
            dto.setSubtitleFiles(subtitleFileDTOs);
            // 字幕组信息
            Fansub fansub = serviceFacade.getFansubService().getByUuid(model.getFansubUuid());
            dto.setFansub(fansubConvert.model2Dto(fansub));
            // 集信息
            Episode episode = serviceFacade.getEpisodeService().getByUuid(model.getEpisodeUuid());
            dto.setEpisode(episodeConvert.model2Dto(episode));
            // 季信息
            Season season = serviceFacade.getSeasonService().getByUuid(model.getSeasonUuid());
            dto.setSeason(seasonConvert.model2Dto(season));
            // 系列信息
            Serial serial = serviceFacade.getSerialService().getByUuid(season.getSerialUuid());
            dto.setSerial(serialConvert.model2Dto(serial));
        }
        return dto;
    }

    @Override
    public Subtitle dto2Model(SubtitleFileInfoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
