package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.FansubDTO;
import com.caizhukui.rrmeiju.dto.SeasonDTO;
import com.caizhukui.rrmeiju.dto.UserDTO;
import com.caizhukui.rrmeiju.dto.response.subtitle.SubtitleInfoDTO;
import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Fansub;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.User;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年6月10日
 */
@Component
public class SubtitleInfoConvert extends BaseConvert implements Convert<Subtitle, SubtitleInfoDTO>{

    @Override
    public SubtitleInfoDTO model2Dto(Subtitle model) {
        SubtitleInfoDTO subtitleInfoDTO = new SubtitleInfoDTO();
        subtitleInfoDTO.setUuid(model.getUuid());
        subtitleInfoDTO.setSubtitleTitle(model.getSubtitleTitle());
        subtitleInfoDTO.setSubtitleUrl(model.getSubtitleUrl());
        subtitleInfoDTO.setSubtitleLang(model.getSubtitleLang());
        subtitleInfoDTO.setFileFormat(model.getFileFormat());
        subtitleInfoDTO.setFileSize(model.getFileSize());
        subtitleInfoDTO.setDownloadCount(model.getDownloadCount());
        subtitleInfoDTO.setCreateTime(model.getUploadTime());
        // 集信息
        Episode episode = serviceFacade.getEpisodeService().getByUuid(model.getEpisodeUuid());
        subtitleInfoDTO.setEpisode(episodeConvert.model2Dto(episode));
        // 季信息
        Season season = serviceFacade.getSeasonService().getByUuid(model.getSeasonUuid());
        SeasonDTO seasonDTO = new SeasonDTO();
        seasonDTO.setUuid(season.getUuid());
        seasonDTO.setChineseName(season.getChineseName());
        seasonDTO.setSeasonIndex(season.getSeasonIndex());
        seasonDTO.setPosterUrl(season.getPosterUrl());
        seasonDTO.setDoubanRating(season.getDoubanRating());
        subtitleInfoDTO.setSeason(seasonDTO);
        // 用户信息
        User user = serviceFacade.getUserService().getByUuid(model.getUserUuid());
        UserDTO userDTO = new UserDTO();
        userDTO.setUuid(user.getUuid());
        userDTO.setUserName(user.getUserName());
        userDTO.setNickname(user.getNickname());
        subtitleInfoDTO.setUser(userDTO);
        // 字幕组信息
        Fansub fansub = serviceFacade.getFansubService().getByUuid(model.getFansubUuid());
        FansubDTO fansubDTO = new FansubDTO();
        fansubDTO.setUuid(fansub.getUuid());
        fansubDTO.setFansubName(fansub.getFansubName());
        subtitleInfoDTO.setFansub(fansubDTO);
        return subtitleInfoDTO;
    }

    @Override
    public Subtitle dto2Model(SubtitleInfoDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

}
