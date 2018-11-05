package com.caizhukui.rrmeiju.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Component
public class BaseConvert {

    @Autowired
    protected ServiceFacade serviceFacade;
    
    @Autowired
    protected TelevisionConvert televisionConvert;
    
    @Autowired
    protected SerialConvert serialConvert;
    
    @Autowired
    protected SeasonConvert seasonConvert;
    
    @Autowired
    protected EpisodeConvert episodeConvert;
    
    @Autowired
    protected SubtitleConvert subtitleConvert;
    
    @Autowired
    protected SubtitleFileConvert subtitleFileConvert;
    
    @Autowired
    protected SubtitleDownloadConvert subtitleDownloadConvert;
    
    @Autowired
    protected FansubConvert fansubConvert;
    
    @Autowired
    protected UserConvert userConvert;
    
    @Autowired
    protected IpConvert ipConvert;
    
    @Autowired
    protected UserSerialConvert userSerialConvert;

}
