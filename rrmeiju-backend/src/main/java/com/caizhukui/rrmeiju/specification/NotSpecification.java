package com.caizhukui.rrmeiju.specification;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年2月11日
 */
public class NotSpecification extends AbstractSpecification {
    
    private Specification wrapped;
    
    public NotSpecification(Specification x) {
        wrapped = x;
    }

    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return !wrapped.isSatisfiedBy(candidate);
    }

}
