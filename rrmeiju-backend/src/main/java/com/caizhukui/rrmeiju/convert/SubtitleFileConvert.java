package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.SubtitleFileDTO;
import com.caizhukui.rrmeiju.model.SubtitleFile;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年6月11日
 */
@Component
public class SubtitleFileConvert implements Convert<SubtitleFile, SubtitleFileDTO> {

    @Override
    public SubtitleFileDTO model2Dto(SubtitleFile model) {
        SubtitleFileDTO dto = null;
        if (model != null) {
            dto = new SubtitleFileDTO();
            dto.setUuid(model.getUuid());
            dto.setFileName(model.getFileName());
            dto.setFileSize(model.getFileSize());
            dto.setSubtitleUuid(model.getSubtitleUuid());
        }
        return dto;
    }

    @Override
    public SubtitleFile dto2Model(SubtitleFileDTO dto) {
        SubtitleFile model = null;
        if (dto != null) {
            model = new SubtitleFile();
            model.setUuid(dto.getUuid());
            model.setFileName(dto.getFileName());
            model.setFileSize(dto.getFileSize());
            model.setSubtitleUuid(dto.getSubtitleUuid());
        }
        return model;
    }

}
