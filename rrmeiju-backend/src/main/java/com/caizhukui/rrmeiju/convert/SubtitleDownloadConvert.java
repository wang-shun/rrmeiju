package com.caizhukui.rrmeiju.convert;

import com.caizhukui.rrmeiju.dto.SubtitleDownloadDTO;
import com.caizhukui.rrmeiju.model.SubtitleDownload;

public class SubtitleDownloadConvert implements Convert<SubtitleDownload, SubtitleDownloadDTO> {

    @Override
    public SubtitleDownloadDTO model2Dto(SubtitleDownload model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubtitleDownload dto2Model(SubtitleDownloadDTO dto) {
        SubtitleDownload model = null;
        if (dto != null) {
            model = new SubtitleDownload();
            model.setUuid(dto.getUuid());
            model.setSubtitleUuid(dto.getSubtitleUuid());
            model.setUserUuid(dto.getUserUuid());
            model.setRemoteIp(dto.getRemoteIp());
            model.setDownloadTime(dto.getDownloadTime());
        }
        return model;
    }

}
