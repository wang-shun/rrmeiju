package com.caizhukui.rrmeiju.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户美剧系列关联实体类
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserSerial extends BaseModel {
    
    /** 用户UUID */
    private String userUuid;
    
    /** 美剧系列UUID */
    private String serialUuid;
    
    /** 关注时间 */
    private Date followTime;

}
