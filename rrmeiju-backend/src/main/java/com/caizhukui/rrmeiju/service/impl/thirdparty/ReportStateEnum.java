package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 报告生成状态枚举类
 * 
 * @author caizhukui
 * @date 2018年7月5日
 */
@Getter
public enum ReportStateEnum {
    
    /** 等待中 */
    WAITING(1, "等待中"),
    
    /** 处理中 */
    PROCESSING(2, "处理中"),
    
    /** 处理成功 */
    PROCESSED(3, "处理成功");
    
    private Integer value;
    
    private String desc;
    
    ReportStateEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static ReportStateEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static ReportStateEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
