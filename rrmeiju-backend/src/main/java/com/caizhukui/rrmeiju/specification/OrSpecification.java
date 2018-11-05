package com.caizhukui.rrmeiju.specification;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年2月11日
 */
public class OrSpecification extends AbstractSpecification {
    
    private Specification one;
    
    private Specification other;
    
    public OrSpecification(Specification x, Specification y) {
        one = x;
        other = y;
    }

    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return one.isSatisfiedBy(candidate) || other.isSatisfiedBy(candidate);
    }

}
