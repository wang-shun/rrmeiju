package com.caizhukui.rrmeiju.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.IndexSearchRecordMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.IndexSearchRecord;
import com.caizhukui.rrmeiju.service.IndexSearchRecordService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 服务实现类
 *
 * @author caizhukui
 * @date 2017年3月11日
 */
@Service
public class IndexSearchRecordServiceImpl extends BaseServiceImpl<IndexSearchRecord> implements IndexSearchRecordService {

	private static final Logger logger = LoggerFactory.getLogger(IndexSearchRecordServiceImpl.class);
	
	@Autowired
	private IndexSearchRecordMapper indexSearchRecordMapper;
	
	@Override
	public Set<String> getAllIps() {
		Set<String> ips = indexSearchRecordMapper.getAllIps();
		return ips;
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.INDEX_SEARCH_RECORD;
    }

    @Override
    protected BaseMapper<IndexSearchRecord> getMapper() {
        return indexSearchRecordMapper;
    }

}
