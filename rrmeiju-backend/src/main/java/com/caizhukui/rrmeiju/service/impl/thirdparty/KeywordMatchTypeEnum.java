package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 关键词匹配模式枚举类
 * 
 * @author caizhukui
 * @date 2018年7月9日
 */
@Getter
public enum KeywordMatchTypeEnum {
    
    /** 精确匹配 */
    ACCURATE(1, "精确匹配"),
    
    /** 高级短语匹配 */
    ADVANCED_PHRASE(2, "高级短语匹配"),
    
    /** 广泛匹配 */
    GENERAL(3, "广泛匹配");
    
    private Integer value;
    
    private String desc;
    
    KeywordMatchTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static KeywordMatchTypeEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static KeywordMatchTypeEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }
    
}
