package com.caizhukui.rrmeiju.convert;

import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.dto.FansubDTO;
import com.caizhukui.rrmeiju.model.Fansub;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月26日
 */
@Component
public class FansubConvert implements Convert<Fansub, FansubDTO> {

    @Override
    public FansubDTO model2Dto(Fansub model) {
        FansubDTO dto = null;
        if (model != null) {
            dto = new FansubDTO();
            dto.setUuid(model.getUuid());
            dto.setFansubName(model.getFansubName());
            dto.setFansubInfo(model.getFansubInfo());
            dto.setFoundationYear(model.getFoundationYear());
            dto.setLogoUrl(model.getLogoUrl());
            dto.setHomepageUrl(model.getHomepageUrl());
            dto.setWeiboUrl(model.getWeiboUrl());
            dto.setWechat(model.getWechat());
            dto.setWechatUrl(model.getWechatUrl());
            dto.setBulletin(model.getBulletin());
        }
        return dto;
    }

    @Override
    public Fansub dto2Model(FansubDTO dto) {
        Fansub model = null;
        if (dto != null) {
            model = new Fansub();
            model.setUuid(dto.getUuid());
            model.setFansubName(dto.getFansubName());
            model.setFansubInfo(dto.getFansubInfo());
            model.setFoundationYear(dto.getFoundationYear());
            model.setLogoUrl(dto.getLogoUrl());
            model.setHomepageUrl(dto.getHomepageUrl());
            model.setWeiboUrl(dto.getWeiboUrl());
            model.setWechat(dto.getWechat());
            model.setWechatUrl(dto.getWechatUrl());
            model.setBulletin(dto.getBulletin());
        }
        return model;
    }

}
