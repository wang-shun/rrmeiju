package com.caizhukui.rrmeiju.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caizhukui.rrmeiju.model.Television;
import com.caizhukui.rrmeiju.service.TelevisionService;
import com.caizhukui.rrmeiju.service.base.BaseService;

import junit.framework.TestCase;

/**
 * 电视台服务测试类
 * 
 * @author caizhukui
 * @date 2018年3月20日
 */
public class TelevisionServiceTest extends JdbcServiceTest<Television> {
    
    @Autowired
    private TelevisionService televisionService;

    @Override
    public BaseService<Television> service() {
        return televisionService;
    }

    @Override
    public String getExistentUuid() {
        return "034db06da50f11e789a000163e05314b";
    }

    @Override
    public Television createRecord() {
        Television record = new Television();
        record.setTelevisionName("televisionName");
        record.setTelevisionInfo("televisionInfo");
        record.setHomepageUrl("homepageUrl");
        record.setLogoUrl("logoUrl");
        return record;
    }

    @Override
    public void updateRecord(Television record) {
        record.setTelevisionName("televisionNameNew");
        record.setTelevisionInfo("televisionInfoNew");
        record.setHomepageUrl("homepageUrlNew");
        record.setLogoUrl("logoUrlNew");
    }

    /**
     * 查询所有电视台名称
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetAllTelevisionNames() {
        List<String> televisionNames = televisionService.getAllTelevisionNames();
        systemOut(televisionNames);
        TestCase.assertTrue(televisionNames.size() > 0);
    }

    /**
     * 查询所有电视台旗下的美剧数量
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetAllTelevisionSerialCount() {
        List<Map<String, Object>> mapList = televisionService.getAllTelevisionSerialCount();
        systemOut(mapList);
        TestCase.assertTrue(mapList.size() > 0);
    }

}
