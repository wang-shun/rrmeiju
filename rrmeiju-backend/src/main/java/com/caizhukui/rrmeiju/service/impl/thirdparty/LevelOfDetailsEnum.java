package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 统计粒度枚举类
 * 
 * @author caizhukui
 * @date 2018年7月5日
 */
@Getter
public enum LevelOfDetailsEnum {
    
    /** 账户粒度 */
    ACCOUNT(2, "账户粒度"),
    
    /** 计划粒度 */
    PLAN(3, "计划粒度"),
    
    /** 单元粒度 */
    UNIT(5, "单元粒度"),
    
    /** 关键词wordid粒度 */
    WORD(6, "关键词wordid粒度"),
    
    /** 创意粒度 */
    IDEA(7, "创意粒度"),
    
    /** 关键词keywordid粒度 */
    KEYWORD(11, "关键词keywordid粒度"),
    
    /** 关键词keywordid+创意粒度 */
    KEYWORD_AND_IDEA(12, "关键词keywordid+创意粒度");
    
    private Integer value;
    
    private String desc;
    
    LevelOfDetailsEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static LevelOfDetailsEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static LevelOfDetailsEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
