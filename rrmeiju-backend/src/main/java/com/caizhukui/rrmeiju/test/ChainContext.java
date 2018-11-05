package com.caizhukui.rrmeiju.test;

import org.apache.commons.chain.impl.ContextBase;

import lombok.Getter;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月17日下午2:16:40
 */
public class ChainContext extends ContextBase {

	private static final long serialVersionUID = 4991624890351089574L;
	
	@Getter
	private Object target;

    public ChainContext() {}

    public ChainContext(Object target) {
        this.target = target;
    }

}
