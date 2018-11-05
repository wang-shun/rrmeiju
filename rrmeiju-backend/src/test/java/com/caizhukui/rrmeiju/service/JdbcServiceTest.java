package com.caizhukui.rrmeiju.service;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;

import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.bo.CriteriaBO;
import com.caizhukui.rrmeiju.model.BaseModel;
import com.caizhukui.rrmeiju.service.base.BaseService;

import junit.framework.TestCase;

/**
 * 数据库相关操作公共测试类
 * 
 * @author caizhukui
 * @param <T>
 * @date 2018年3月20日
 */
public abstract class JdbcServiceTest<T extends BaseModel> extends BaseServiceTest {

    /**  */
    private static final int DEFAULT_PAGE_INDEX = 1;
    
    /**  */
    private static final int DEFAULT_PAGE_SIZE = 2;
    
    /**  */
    private static final int DEFAULT_START_INDEX = (DEFAULT_PAGE_INDEX - 1) * DEFAULT_PAGE_SIZE;
    
    /** 数据表中不存在的ID */
    private static final Long NONEXIST_ID = 9999999999999999L;
    
    /** 数据表中不存在的UUID */
    private static final String NONEXIST_UUID = "00000000000000000000000000000000";

    /** 控制台的正确输出 */
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    /** 控制台的错误输出 */
    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule();
    
    /**
     * 执行步骤：新增记录>根据UUID查询记录>根据UUID更新记录>根据ID查询记录>根据UUID删除记录>根据UUID查询记录，记录不存在
     * 
     * @author caizhukui
     * @date 2018年4月23日
     */
    @Test
    public void testSequence() {
        T record = createRecord();
        setCommonFields(record);
        // 新增记录
        service().add(record);
        String uuid = record.getUuid();
        TestCase.assertNotNull(uuid);
        // 根据UUID查询记录
        T recordInDb = service().getByUuid(uuid);
        systemOut(recordInDb);
        TestCase.assertNotNull(recordInDb);
        Long id = recordInDb.getId();
        record.setId(id);
        TestCase.assertEquals(record, recordInDb);
        // 根据UUID更新记录
        updateRecord(record);
        updateCommonFields(record);
        service().updateByUuid(record);
        // 根据ID查询记录
        recordInDb = service().getById(id);
        systemOut(recordInDb);
        TestCase.assertEquals(record, recordInDb);
        // 根据UUID删除记录
        service().deleteByUuid(uuid);
        // 根据UUID查询记录，记录不存在
        recordInDb = service().getByUuid(uuid);
        TestCase.assertNull(recordInDb);
    }
    
    /**
     * 查询全部字段，无过滤和排序条件
     * 
     * @author caizhukui
     * @date 2018年3月20日
     */
    @Test
    public void testGetAllFieldsNoFilterNoSort() {
        CriteriaBO criteriaBO = new CriteriaBO();
        criteriaBO.setStartIndex(DEFAULT_START_INDEX);
        criteriaBO.setPageSize(DEFAULT_PAGE_SIZE);
        List<T> records = service().get(criteriaBO);
        systemOut(records);
        TestCase.assertEquals(DEFAULT_PAGE_SIZE, records.size());
    }
    
    /**
     * 查询全部数量，无过滤条件
     * 
     * @author caizhukui
     * @date 2018年4月23日
     */
    @Test
    public void testGetCountNoFilter() {
        CriteriaBO criteriaBO = new CriteriaBO();
        criteriaBO.setStartIndex(DEFAULT_START_INDEX);
        criteriaBO.setPageSize(DEFAULT_PAGE_SIZE);
        int count = service().getCount(criteriaBO);
        TestCase.assertTrue(count >= 0);
    }
    
    /**
     * 分页查询所有
     * 
     * @author caizhukui
     * @date 2018年4月23日
     */
    @Test
    public void testGetAllByPagination() {
        List<T> records = service().getAllByPagination(DEFAULT_PAGE_SIZE, DEFAULT_PAGE_INDEX);
        systemOut(records);
        TestCase.assertEquals(DEFAULT_PAGE_SIZE, records.size());
    }
    
    /**
     * 根据UUID删除记录，记录不存在
     * 
     * @author caizhukui
     * @date 2018年4月23日
     */
    @Test
    public void testDeleteByUuidNonexist() {
        service().deleteByUuid(NONEXIST_UUID);
    }
    
    /**
     * 根据ID删除记录，记录不存在
     * 
     * @author caizhukui
     * @date 2018年4月23日
     */
    @Ignore
    public void testDeleteByIdNonexist() {
        service().deleteById(NONEXIST_ID);
    }
    
    /**
     * 设置测试记录的公共属性值
     * 
     * @param record 测试记录
     * @author caizhukui
     * @date 2018年4月23日
     */
    private void setCommonFields(T record) {
        record.setUuid(UuidUtils.getUuid());
        Date now = new Date();
        record.setGmtCreate(now);
        record.setGmtModified(now);
    }
    
    /**
     * 更新测试记录的公共属性值
     * 
     * @param record 测试记录
     * @author caizhukui
     * @date 2018年4月25日
     */
    private void updateCommonFields(T record) {
        record.setGmtModified(new Date());
    }
    
    /**
     * 返回待测试的Service实现类
     * 
     * @return BaseService<T>
     * @author caizhukui
     * @date 2018年4月23日
     */
    public abstract BaseService<T> service();

    /**
     * 返回相应数据表一个存在的UUID
     * 
     * @return String 记录UUID
     * @author caizhukui
     * @date 2018年4月21日
     */
    public abstract String getExistentUuid();
    
    /**
     * 生成测试记录
     * 
     * @return T
     * @author caizhukui
     * @date 2018年4月23日
     */
    public abstract T createRecord();
    
    /**
     * 更新测试记录
     * 
     * @param record 测试记录
     * @author caizhukui
     * @date 2018年4月25日
     */
    public abstract void updateRecord(T record);

}
