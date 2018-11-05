package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 搜索推广设备枚举类
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
@Getter
public enum DeviceEnum {
    
    /** 全部搜索推广设备 */
    ALL(0, "全部搜索推广设备"),
    
    /** 仅计算机 */
    PC(1, "仅计算机"),
    
    /** 仅移动 */
    MOBILE(2, "仅移动");
    
    private Integer value;
    
    private String desc;
    
    DeviceEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static DeviceEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static DeviceEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
