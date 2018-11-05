package com.caizhukui.rrmeiju.model;

import java.util.Date;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月28日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MovieDownload extends BaseModel {

    private static final long serialVersionUID = -5928943985333907481L;
    
    /** 电影UUID */
    private String subtitleUuid;
    
    /** 用户UUID */
    private String userUuid;
    
    /** 客户端IP地址 */
    private String remoteIp;
    
    /** 下载时间 */
    private Date downloadTime;
    
    /***************************************/
    
    /**  */
    @Transient
    private Subtitle subtitle;
    
    /**  */
    @Transient
    private User user;

}
