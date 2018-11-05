package com.caizhukui.rrmeiju.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.TelevisionMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Television;
import com.caizhukui.rrmeiju.service.TelevisionService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 电视台服务实现类
 * 
 * @author caizhukui
 * @date 2017年1月17日
 */
@Service
public class TelevisionServiceImpl extends BaseServiceImpl<Television> implements TelevisionService {
	
	private static final Logger logger = LoggerFactory.getLogger(TelevisionServiceImpl.class);
	
	@Autowired
	private TelevisionMapper televisionMapper;

	@Override
	public List<String> getAllTelevisionNames() {
	    return televisionMapper.getAllTelevisionNames();
	}
	
	@Override
	public List<Map<String, Object>> getAllTelevisionSerialCount() {
	    return televisionMapper.getAllTelevisionSerialCount();
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.TELEVISION;
    }

    @Override
    protected BaseMapper<Television> getMapper() {
        return televisionMapper;
    }

}
