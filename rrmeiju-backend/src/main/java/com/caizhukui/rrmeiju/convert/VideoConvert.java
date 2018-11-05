package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.VideoDTO;
import com.caizhukui.rrmeiju.model.Video;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月26日
 */
@Component
public class VideoConvert implements Convert<Video, VideoDTO> {

    @Override
    public VideoDTO model2Dto(Video model) {
        VideoDTO dto = null;
        if (model != null) {
            dto = new VideoDTO();
            dto.setUuid(model.getUuid());
            dto.setVideoTitle(model.getVideoTitle());
            dto.setVideoUrl(model.getVideoUrl());
            dto.setSubtitleLang(model.getSubtitleLang());
            dto.setVideoFormat(dto.getVideoFormat());
            dto.setVideoSource(model.getVideoSource());
            dto.setRemark(model.getRemark());
            dto.setEpisodeUuid(model.getEpisodeUuid());
            dto.setSeasonUuid(model.getSeasonUuid());
            dto.setUserUuid(model.getUserUuid());
            dto.setFansubUuid(model.getFansubUuid());
            dto.setViewCount(model.getViewCount());
            dto.setDeleted(model.isDeleted());
        }
        return dto;
    }

    @Override
    public Video dto2Model(VideoDTO dto) {
        Video model = null;
        if (dto != null) {
            model = new Video();
            model.setUuid(dto.getUuid());
            model.setVideoTitle(dto.getVideoTitle());
            model.setVideoUrl(dto.getVideoUrl());
            model.setSubtitleLang(dto.getSubtitleLang());
            model.setVideoFormat(dto.getVideoFormat());
            model.setVideoSource(dto.getVideoSource());
            model.setRemark(dto.getRemark());
            model.setEpisodeUuid(dto.getEpisodeUuid());
            model.setSeasonUuid(dto.getSeasonUuid());
            model.setUserUuid(dto.getUserUuid());
            model.setFansubUuid(dto.getFansubUuid());
            model.setViewCount(dto.getViewCount());
            model.setDeleted(dto.isDeleted());
        }
        return model;
    }

}
