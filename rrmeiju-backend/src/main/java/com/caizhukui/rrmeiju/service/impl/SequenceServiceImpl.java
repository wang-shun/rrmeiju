package com.caizhukui.rrmeiju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.mapper.SequenceMapper;
import com.caizhukui.rrmeiju.service.SequenceService;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月16日
 */
@Service
public class SequenceServiceImpl implements SequenceService {
	
	@Autowired
	private SequenceMapper sequenceDao;

	/**
	 * (non-Javadoc)
	 * @see com.caizhukui.rrmeiju.service.SequenceService#getNextVal(java.lang.String)
	 */
	@Override
	public int getNextVal(String sequenceName) {
		int value = sequenceDao.getNextVal(sequenceName);
		return value;
	}

}
