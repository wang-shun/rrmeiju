package com.caizhukui.rrmeiju.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Component
public class InfoConvert extends BaseConvert {
    
    @Autowired
    protected TelevisionInfoConvert televisionInfoConvert;
    
    @Autowired
    protected SerialInfoConvert serialInfoConvert;
    
    @Autowired
    protected EpisodeInfoConvert episodeInfoConvert;
    
    @Autowired
    protected SubtitleInfoConvert subtitleInfoConvert;
    
    @Autowired
    protected SubtitleFileInfoConvert subtitleFileInfoConvert;
    
    @Autowired
    protected SubtitleDownloadInfoConvert subtitleDownloadInfoConvert;

}
