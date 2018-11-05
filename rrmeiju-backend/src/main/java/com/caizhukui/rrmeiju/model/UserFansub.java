package com.caizhukui.rrmeiju.model;

import java.util.Date;

import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户字幕组关联实体类
 * 
 * @author caizhukui
 * @date 2018年4月29日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserFansub extends BaseModel {

    private static final long serialVersionUID = -7979501456977491490L;
    
    /** 用户UUID */
    private String userUuid;
    
    /** 字幕组UUID */
    private String fansubUuid;
    
    /** 加入时间 */
    private Date joinTime;
    
    /***************************************/
    
    /** 用户信息 */
    @Transient
    private User user;
    
    /** 字幕组信息 */
    @Transient
    private Fansub fansub;

}
