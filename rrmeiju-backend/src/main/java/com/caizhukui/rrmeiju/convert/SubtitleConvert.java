package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.SubtitleDTO;
import com.caizhukui.rrmeiju.model.Subtitle;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年6月10日
 */
@Component
public class SubtitleConvert extends BaseConvert implements Convert<Subtitle, SubtitleDTO> {

    @Override
    public SubtitleDTO model2Dto(Subtitle model) {
        SubtitleDTO dto = null;
        if (model != null) {
            dto = new SubtitleDTO();
            dto.setUuid(model.getUuid());
            dto.setSubtitleTitle(model.getSubtitleTitle());
            dto.setSubtitleUrl(model.getSubtitleUrl());
            dto.setSubtitleLang(model.getSubtitleLang());
            dto.setFileFormat(model.getFileFormat());
            dto.setFileSize(model.getFileSize());
            dto.setFileMd5(model.getFileMd5());
            dto.setEpisodeUuid(model.getEpisodeUuid());
            dto.setSeasonUuid(model.getSeasonUuid());
            dto.setUserUuid(model.getUserUuid());
            dto.setFansubUuid(model.getFansubUuid());
            dto.setRemark(model.getRemark());
            dto.setDownloadCount(model.getDownloadCount());
            dto.setCreateTime(model.getUploadTime());
        }
        return dto;
    }

    @Override
    public Subtitle dto2Model(SubtitleDTO dto) {
        Subtitle model = null;
        if (dto != null) {
            model = new Subtitle();
            model.setUuid(dto.getUuid());
            model.setSubtitleTitle(dto.getSubtitleTitle());
            model.setSubtitleUrl(dto.getSubtitleUrl());
            model.setSubtitleLang(dto.getSubtitleLang());
            model.setFileFormat(dto.getFileFormat());
            model.setFileSize(dto.getFileSize());
            model.setFileMd5(dto.getFileMd5());
            model.setEpisodeUuid(dto.getEpisodeUuid());
            model.setSeasonUuid(dto.getSeasonUuid());
            model.setUserUuid(dto.getUserUuid());
            model.setFansubUuid(dto.getFansubUuid());
            model.setRemark(dto.getRemark());
            model.setDownloadCount(dto.getDownloadCount());
            model.setUploadTime(dto.getCreateTime());
            model.setSubtitleFiles(subtitleFileConvert.dto2Model(dto.getSubtitleFiles()));
        }
        return model;
    }

}
