package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.response.subtitle.SubtitleDownloadInfoDTO;
import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.SubtitleDownload;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年6月11日
 */
@Component
public class SubtitleDownloadInfoConvert extends InfoConvert implements Convert<SubtitleDownload, SubtitleDownloadInfoDTO> {

    @Override
    public SubtitleDownloadInfoDTO model2Dto(SubtitleDownload model) {
        SubtitleDownloadInfoDTO dto = null;
        if (model != null) {
            dto = new SubtitleDownloadInfoDTO();
            dto.setSubtitleDownloadId(model.getUuid());
            dto.setDownloadTime(model.getDownloadTime());
            String subtitleUuid = model.getSubtitleUuid();
            Subtitle subtitle = serviceFacade.getSubtitleService().getByUuid(subtitleUuid);
            dto.setSubtitleInfo(subtitleInfoConvert.model2Dto(subtitle));
        }
        return dto;
    }

    @Override
    public SubtitleDownload dto2Model(SubtitleDownloadInfoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
