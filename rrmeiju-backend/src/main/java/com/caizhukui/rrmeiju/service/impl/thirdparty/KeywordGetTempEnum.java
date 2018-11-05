package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 是否查询关键词影子枚举类<br>
 * 影子是指用户先向系统提交了关键词A，然后又对A进行修改（例如修改 url）<br>
 * 修改后的关键词为A'，在A'通过审核生效之前，线上的生效关键词仍然为A<br>
 * 此时getTemp为0，查询到的是A；getTemp为1，查询到的是 A'
 * 
 * @author caizhukui
 * @date 2018年7月9日
 */
@Getter
public enum KeywordGetTempEnum {
    
    /** 只查询关键词本身 */
    SELF(0, "只查询关键词本身"),
    
    /** 只查询关键词影子 */
    SHADOW(1, "只查询关键词影子");
    
    private Integer value;
    
    private String desc;
    
    KeywordGetTempEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static KeywordGetTempEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static KeywordGetTempEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
