package com.caizhukui.rrmeiju.test;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月17日
 */
@Component
public class PongFilter extends ChainFilter {
	
	@Override
	public boolean execute(ChainContext context) throws Exception {
		SmsContext smsContext = (SmsContext) context;
		List<String> messages = smsContext.getMessages();
		System.out.println(messages.get(1));
		return CONTINUE_PROCESSING;
	}

}
