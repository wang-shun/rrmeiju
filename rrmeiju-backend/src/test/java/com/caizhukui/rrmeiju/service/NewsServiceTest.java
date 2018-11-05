package com.caizhukui.rrmeiju.service;

import com.caizhukui.rrmeiju.model.News;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月23日
 */
public class NewsServiceTest extends JdbcServiceTest<News> {

    @Override
    public BaseService<News> service() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getExistentUuid() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public News createRecord() {
        News record = new News();
        
        return record;
    }

    @Override
    public void updateRecord(News record) {
        
        
    }

}
