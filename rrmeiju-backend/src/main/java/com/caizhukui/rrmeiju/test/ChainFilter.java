package com.caizhukui.rrmeiju.test;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月17日
 */
public abstract class ChainFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(ChainFilter.class);

	@Override
	public boolean execute(Context context) throws Exception {
		if (context instanceof ChainContext) {
            return execute((ChainContext) context);
        }
		return CONTINUE_PROCESSING;
	}

	@Override
	public boolean postprocess(Context context, Exception exception) {
		if (context instanceof ChainContext) {
			return doPostprocess((ChainContext) context, exception);
		}
		return CONTINUE_PROCESSING;
	}
	
	public abstract boolean execute(ChainContext context) throws Exception;

    public boolean doPostprocess(ChainContext context, Exception exception) {
        return CONTINUE_PROCESSING;
    }

}
