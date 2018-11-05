package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 关键词ID类型枚举类
 * 
 * @author caizhukui
 * @date 2018年7月9日
 */
@Getter
public enum KeywordIdTypeEnum {
    
    /** 单元ID */
    UNIT(5, "单元ID"),
   
    /** 关键词ID */
    KEYWORD(11, "关键词ID");
    
    private Integer value;
    
    private String desc;
    
    KeywordIdTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static KeywordIdTypeEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static KeywordIdTypeEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
