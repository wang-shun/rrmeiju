package com.caizhukui.rrmeiju.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caizhukui.common.util.CollectionUtils;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.model.Television;
import com.caizhukui.rrmeiju.service.SerialService;
import com.caizhukui.rrmeiju.service.base.BaseService;

import junit.framework.TestCase;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月21日
 */
public class SerialServiceTest extends JdbcServiceTest<Serial> {
    
    /**  */
    private static final String EXISTENT_SERIAL_UUID = "0032513a566f11e798eb00163e0521c8";
    
    @Autowired
    private SerialService serialService;
    
    @Override
    public BaseService<Serial> service() {
        return serialService;
    }

    @Override
    public String getExistentUuid() {
        return EXISTENT_SERIAL_UUID;
    }

    @Override
    public Serial createRecord() {
        Serial record = new Serial();
        record.setEnglishName("englishName");
        record.setChineseName("chineseName");
        record.setChineseAlias("chineseAlias");
        record.setChineseSummary("chineseSummary");
        return record;
    }

    @Override
    public void updateRecord(Serial record) {
        // TODO Auto-generated method stub
        
    }

    /**
     * 查询某一电视台拥有的所有美剧
     * 
     * @author caizhukui
     * @date 2018年4月21日
     */
    @Test
    public void testGetByTelevisionUuidExist() {
        final String televisionUuid = "69f9addb7d7f11e69cf6a0d3c1483ed9";
        List<Serial> serials = serialService.getByTelevisionUuid(televisionUuid);
        systemOut(serials);
        TestCase.assertNotNull(serials);
    }
    
    /**
     * 查询某一电视台拥有的所有美剧
     * 
     * @author caizhukui
     * @date 2018年4月23日
     */
    @Test
    public void testGetByTelevisionUuidNonexist() {
        final String televisionUuid = "69f9addb7d7f11e69cf6a0d3c1483ed0";
        List<Serial> serials = serialService.getByTelevisionUuid(televisionUuid);
        TestCase.assertTrue(CollectionUtils.isEmpty(serials));
    }

}
