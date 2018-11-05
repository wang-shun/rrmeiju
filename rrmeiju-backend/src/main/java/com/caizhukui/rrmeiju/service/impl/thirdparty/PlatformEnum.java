package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 搜索推广渠道枚举类
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
@Getter
public enum PlatformEnum {

    /** 搜索推广 */
    SEARCH_PROMOTION(0, "搜索推广"),
    
    /** 内部流量 */
    INNER_FLOW(3, "内部流量"),
    
    /** 搜索合作流量 */
    SEARCH_COOPERATION_FLOW(4, "搜索合作流量"),
    
    /* 以上3个值支持账户、计划、单元、关键词、创意5种基本类型报告，逻辑关系为：0 = 3 + 4 */

    /** 信息流推广 */
    INFORMATION_FLOW_PROMOTION(23, "信息流推广"),
    
    /** 搜索信息流 */
    SEARCH_INFORMATION_FLOW(14, "搜索信息流"),
    
    /** 贴吧信息流 */
    TIEBA_INFORMATION_FLOW(15, "贴吧信息流"),
    
    /** 全部（搜索推广+信息流推广） */
    ALL(99, "全部（搜索推广+信息流推广）");
    
    /* 以上4个值支持账户、计划、单元3种基本类型报告，逻辑关系为：23 = 14 + 15；99 = 0 + 23 */
    
    private Integer value;
    
    private String desc;
    
    PlatformEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static PlatformEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static PlatformEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }
    
}
