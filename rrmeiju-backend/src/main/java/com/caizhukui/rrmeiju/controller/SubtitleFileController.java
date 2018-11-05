package com.caizhukui.rrmeiju.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caizhukui.rrmeiju.dto.response.subtitle.SubtitleFileInfoDTO;
import com.caizhukui.rrmeiju.model.Subtitle;

/**
 * 字幕文件控制器类
 * 
 * @author caizhukui
 * @date 2018年6月11日
 */
@RestController
public class SubtitleFileController extends BaseController {
    
    private static final Logger logger = LoggerFactory.getLogger(SubtitleFileController.class);

    /**
     * 根据字幕UUID查询字幕文件关联信息
     * 
     * @param uuid 字幕ID
     * @return SubtitleFileInfoDTO
     * @author caizhukui
     * @date 2017年4月21日
     */
    @RequestMapping(value = "/subtitles/{uuid}/subtitleFiles", method = GET)
    public SubtitleFileInfoDTO getSubtitleFiles(@PathVariable String uuid) {
        logger.debug("getSubtitleFiles - uuid = {}", uuid);
        Subtitle subtitle = serviceFacade.getSubtitleService().getByUuid(uuid);
        SubtitleFileInfoDTO subtitleFileInfoDTO = subtitleFileInfoConvert.model2Dto(subtitle);
        return subtitleFileInfoDTO;
    }

    @Override
    protected String getName() {
        return "字幕文件";
    }

}
