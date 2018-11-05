package com.caizhukui.rrmeiju.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.NewsMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.News;
import com.caizhukui.rrmeiju.service.NewsService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 资讯服务类
 * 
 * @author caizhukui
 * @date 2017年9月13日
 */
@Service
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {
    
    @Autowired
    private NewsMapper newsMapper;

    @Override
    protected TableEnum getTable() {
        return TableEnum.NEWS;
    }

    @Override
    protected BaseMapper<News> getMapper() {
        return newsMapper;
    }

}
