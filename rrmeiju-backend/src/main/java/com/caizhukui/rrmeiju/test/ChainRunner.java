package com.caizhukui.rrmeiju.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.impl.ChainBase;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月17日
 */
@Component
public class ChainRunner implements BeanFactoryAware {
	
	private BeanFactory beanFactory;
	
	public void runChain(String chainName) {
		try {
			SmsContext smsContext = new SmsContext();
			List<String> messages = new ArrayList<String>();
			messages.add("Ping");
			messages.add("Pong");
			messages.add("Pang");
			smsContext.setMessages(messages);
			createChain(chainName).execute(smsContext);
		} catch (Exception e) {
			throw new RuntimeException("Chain \"" + chainName + "\": Execution failed.", e);
		}
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
	protected ChainBase createChain(String chainName) {
		return (ChainBase) beanFactory.getBean(chainName);
	}

}
