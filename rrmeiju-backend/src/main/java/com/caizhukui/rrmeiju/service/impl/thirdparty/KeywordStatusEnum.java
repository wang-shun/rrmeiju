package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.util.Arrays;

import lombok.Getter;

/**
 * 关键词状态枚举类<br>
 * 系统指定，客户端不可改变<br>
 * 部分无效：投放设备为全部设备时，移动物料审核未过，计算机物料审核通过时，显示“部分无效”<br>
 * 搜索无效：将关键词的“搜索无效”状态进行设备的区分<br>
 * 当计算机出价低于计算机最低展现价格，显示“计算机搜索无效”<br>
 * 当移动出价低于移动最低展现价格，显示“移动搜索无效”<br>
 * 都无效时，显示“搜索无效”<br>
 * 
 * @author caizhukui
 * @date 2018年7月9日
 */
@Getter
public enum KeywordStatusEnum {
    
    /** 有效-移动url审核中 */
    VALID_MOBILE_IN_REVIEW(40, "有效-移动url审核中"),
    
    /** 有效 */
    VALID(41, "有效"),
    
    /** 暂停推广 */
    PAUSED(42, "暂停推广"),
    
    /** 不宜推广 */
    INAPPROPRIATE(43, "不宜推广"),
    
    /** 搜索无效 */
    INVALID(44, "搜索无效"),
    
    /** 待激活 */
    INACTIVATE(45, "待激活"),
    
    /** 审核中 */
    IN_REVIEW(46, "审核中"),
    
    /** 搜索量过低 */
    SEARCH_LOW(47, "搜索量过低"),
    
    /** 部分无效 */
    INVALID_PART(48, "部分无效"),
    
    /** 计算机搜索无效 */
    INVALID_PC(49, "计算机搜索无效"),
    
    /** 移动搜索无效 */
    INVALID_MOBILE(50, "移动搜索无效");
    
    private Integer value;
    
    private String desc;
    
    KeywordStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public static KeywordStatusEnum getByValue(final Integer value) {
        return Arrays.stream(values()).filter(item -> item.getValue().equals(value)).findFirst().orElse(null);
    }
    
    public static KeywordStatusEnum getByDesc(final String desc) {
        return Arrays.stream(values()).filter(item -> item.getDesc().equals(desc)).findFirst().orElse(null);
    }

}
