package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 统计时间单位枚举类
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
@Getter
public enum UnitOfTimeEnum {
    
    /** 年 */
    YEAR(1, "年"),
    
    /** 月 */
    MONTH(3, "月"),
    
    /** 周 */
    WEEK(4, "周"),
    
    /** 日 */
    DAY(5, "日"),
    
    /** 小时 */
    HOUR(7, "小时"),
    
    /** 请求时间段汇总 */
    TIME_RANGE(8, "请求时间段汇总");
    
    private Integer value;
    
    private String desc;
    
    UnitOfTimeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static UnitOfTimeEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static UnitOfTimeEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
