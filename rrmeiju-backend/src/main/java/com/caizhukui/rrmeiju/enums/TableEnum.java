package com.caizhukui.rrmeiju.enums;

import lombok.Getter;

/**
 * 数据库表名枚举类
 * 
 * @author caizhukui
 * @date 2018年5月15日
 */
@Getter
public enum TableEnum {
    
    /** 用户表 */
    USER("user"),

    /** 电视台表 */
    TELEVISION("television"),
    
    /**  */
    SERIAL("serial"),
    
    /**  */
    SEASON("season"),
    
    /**  */
    EPISODE("episode"),
    
    /**  */
    SUBTITLE("subtitle"),
  
    /**  */
    SUBTITLE_FILE("subtitle_file"),
    
    /**  */
    VIDEO("video"),
    
    /**  */
    NEWS("news"),
    
    /**  */
    IP("ip"),
    
    /**  */
    USER_OAUTH("user_oauth"),
    
    /**  */
    USER_SERIAL("user_serial"),
    
    /**  */
    USER_FANSUB("user_fansub"),
    
    /**  */
    SUBTITLE_DOWNLOAD("subtitle_download"),
    
    /**  */
    MOBILE_LOCALE("mobile_locale"),
    
    /**  */
    FANSUB("fansub"),
    
    /**  */
    SMS_SEND_RECORD("sms_send_record"),
    
    /** 用户登录记录表 */
    USER_LOGIN_RECORD("user_login_record"),
    
    /** 用户注册记录表 */
    USER_REGISTER_RECORD("user_register_record"),
    
    /**  */
    INDEX_SEARCH_RECORD("index_search_record");
    
    /** 数据库表名 */
    String tableName;
    
    TableEnum(String tableName) {
        this.tableName = tableName;
    }

}
