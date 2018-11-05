package com.caizhukui.rrmeiju.specification;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年2月11日
 */
public abstract class AbstractSpecification implements Specification {
    
    public Specification and(Specification other) {
        return new AndSpecification(this, other);
    }
    
    public Specification or(Specification other) {
        return new OrSpecification(this, other);
    }
    
    public Specification not() {
        return new NotSpecification(this);
    }
    
    // public abstract boolean subsumes();

}
