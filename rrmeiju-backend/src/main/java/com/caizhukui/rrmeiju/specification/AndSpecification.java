package com.caizhukui.rrmeiju.specification;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年2月11日
 */
public class AndSpecification extends AbstractSpecification {
    
    private Specification one;
    
    private Specification other;
    
    public AndSpecification(Specification x, Specification y) {
        one = x;
        other = y;
    }

    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return one.isSatisfiedBy(candidate) && other.isSatisfiedBy(candidate);
    }

}
