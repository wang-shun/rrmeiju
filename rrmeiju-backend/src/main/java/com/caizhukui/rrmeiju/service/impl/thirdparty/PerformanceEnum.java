package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 返回数据枚举类
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
@Getter
public enum PerformanceEnum {
    
    /** 消耗 */
    COST("cost"),
    
    /** 点击均价 */
    CPC("cpc"),
    
    /** 点击数 */
    CLICK("click"),
    
    /** 展示数 */
    IMPRESSION("impression"),
    
    /** 点击率 */
    CTR("ctr"),
    
    /** 千次展现成本 */
    CPM("cpm"),
    
    /** 关键词平均排名 */
    POSITION("position"),
    
    /** 转化率 */
    CONVERSION("conversion"),
    
    /**  */
    PHONE_CONVERSION("phoneConversion"),
    
    /**  */
    BRIDGE_CONVERSION("bridgeConversion");
    
    private String value;
    
    PerformanceEnum(String value) {
        this.value = value;
    }
    
    public static PerformanceEnum getByValue(final String value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }

}
