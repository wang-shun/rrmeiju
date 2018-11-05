package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.FansubMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Fansub;
import com.caizhukui.rrmeiju.service.FansubService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 字幕组服务实现类
 * 
 * @author caizhukui
 * @date 2017年1月25日
 */
@Service
@Transactional
public class FansubServiceImpl extends BaseServiceImpl<Fansub> implements FansubService {
    
    private static final Logger logger = LoggerFactory.getLogger(FansubServiceImpl.class);
	
	@Autowired
	private FansubMapper fansubMapper;

	@Override
	public List<Fansub> getByUserUuid(String userUuid) {
		List<Fansub> fansubs = fansubMapper.getByUserUuid(userUuid);
		return fansubs;
	}
	
	@Override
	public List<Fansub> getBySeasonUuid(String seasonUuid) {
		List<Fansub> fansubs = fansubMapper.getBySeasonUuid(seasonUuid);
		return fansubs;
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.FANSUB;
    }

    @Override
    protected BaseMapper<Fansub> getMapper() {
        return fansubMapper;
    }

}
