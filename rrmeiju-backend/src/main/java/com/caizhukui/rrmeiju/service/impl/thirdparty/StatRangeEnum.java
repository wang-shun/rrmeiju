package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 统计范围枚举类<br>
 * 统计范围不能细于当前的统计粒度<br>
 * 例如统计粒度为计划，则统计范围不能细到单元
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
@Getter
public enum StatRangeEnum {
    
    /** 账户范围 */
    ACCOUNT(2, "账户范围"),
    
    /** 计划范围 */
    PLAN(3, "计划范围"),
    
    /** 单元范围 */
    UNIT(5, "单元范围"),
    
    /** 关键词wordid范围 */
    WORD(6, "关键词wordid范围"),
    
    /** 创意范围 */
    IDEA(7, "创意范围"),
    
    /** 关键词keywordid范围 */
    KEYWORD(11, "关键词keywordid范围");
    
    private Integer value;
    
    private String desc;
    
    StatRangeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static StatRangeEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static StatRangeEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
