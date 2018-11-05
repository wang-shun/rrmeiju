package com.caizhukui.rrmeiju.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 短信发送记录实体类
 * 
 * @author caizhukui
 * @date 2017年6月7日
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SmsSendRecord extends BaseModel {

    private static final long serialVersionUID = 7528206476334880824L;

    /** 手机号 */
    private String mobileNumber;

    /** 客户端IP地址 */
    private String remoteIp;

    /** 短信发送类型（1：用户注册，2：用户登录，3：重置密码） */
    private int type;
    
    /** 短信发送时间 */
    private Date sendTime;

}
