package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 报告类型枚举类
 * 
 * @author caizhukui
 * @date 2018年7月5日
 */
@Getter
public enum ReportTypeEnum {
    
    /** 账户报告 */
    ACCOUNT(2, "账户报告"),
    
    /** 地域报告 */
    REGION(3, "地域报告"),
    
    /** 二级地域（地级市）报告 */
    SECONDARY_REGION(5, "二级地域报告"),
    
    /** 搜索词报告 */
    SEARCH(6, "搜索词报告"),
    
    /** 关键词wordid报告 */
    WORD(9, "关键词wordid报告"),
    
    /** 计划报告 */
    PLAN(10, "计划报告"),
    
    /** 单元报告 */
    UNIT(11, "单元报告"),
    
    /** 创意报告 */
    IDEA(12, "创意报告"),
    
    /** 关键词keywordid报告 */
    KEYWORD(14, "关键词keywordid报告"),
    
    /** 配对报告 */
    PAIR(15, "配对报告"),
    
    /** 蹊径报告 */
    PATH(21, "蹊径报告"),
    
    /** 历史数据排名报告 */
    HISTORY_RANKING(38, "历史数据排名报告"),
    
    /** APP下载报告 */
    APP_DOWNLOAD(40, "APP下载报告"),
    
    /** 推广电话报告 */
    PROMOTION_PHONE(41, "推广电话报告");
    
    private Integer value;
    
    private String desc;
    
    ReportTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static ReportTypeEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static ReportTypeEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
