package com.caizhukui.rrmeiju.model;

import java.util.Date;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 视频下载记录实体类
 * 
 * @author caizhukui
 * @date 2018年4月28日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class VideoDownload extends BaseModel {

    private static final long serialVersionUID = -5908417673254180352L;
    
    /** 视频UUID */
    private String videoUuid;
    
    /** 用户UUID */
    private String userUuid;
    
    /** 客户端IP地址 */
    private String remoteIp;
    
    /** 下载时间 */
    private Date downloadTime;
    
    /***************************************/
    
    /**  */
    @Transient
    private Video video;
    
    /**  */
    @Transient
    private User user;

}
