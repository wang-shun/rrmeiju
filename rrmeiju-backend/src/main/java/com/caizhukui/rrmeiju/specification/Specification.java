package com.caizhukui.rrmeiju.specification;

/**
 * 规则接口
 * 
 * @author caizhukui
 * @date 2018年2月11日
 */
public interface Specification {
    
    /**
     * 
     * 
     * @param candidate
     * @return boolean
     * @author caizhukui
     * @date 2018年2月11日
     */
    boolean isSatisfiedBy(Object candidate);

}
