package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 关键词高级短语细分匹配模式枚举类
 * 
 * @author caizhukui
 * @date 2018年7月9日
 */
@Getter
public enum KeywordPhraseTypeEnum {
    
    /** 同义包含 */
    SYNONYMOUS(1, "同义包含"),
    
    /** 精确包含 */
    ACCURATE(2, "精确包含"),
    
    /** 核心包含 */
    CORE(3, "核心包含");
    
    private Integer value;
    
    private String desc;
    
    KeywordPhraseTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static KeywordPhraseTypeEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static KeywordPhraseTypeEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
