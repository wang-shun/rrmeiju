package com.caizhukui.rrmeiju.service;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.caizhukui.rrmeiju.enums.TableEnum;

/**
 * 数据库元数据服务接口
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
public interface MetaDataService {
    
    /**
     * 查询数据表的所有字段
     * 
     * @param tableEnum 
     * @return List<String> 该表的所有字段名
     * @author caizhukui
     * @date 2018年5月15日
     */
    @Cacheable(value = "metaData", key = "'ColumnNamesOf' + #tableEnum")
    List<String> getColumnNamesOfTable(TableEnum tableEnum);
    
    /**
     * 查询数据表的所有字段
     * 
     * @param tableEnum 
     * @return List<String> 该表的所有字段名
     * @author caizhukui
     * @date 2018年5月15日
     */
    @Cacheable(value = "metaData", key = "'FieldsOf' + #tableEnum")
    List<String> getFieldsOfTable(TableEnum tableEnum);
    
    /**
     * 查询数据表的所有字段
     * 
     * @param tableEnum 
     * @return String 英文逗号分隔的所有字段名
     * @author caizhukui
     * @date 2018年5月15日
     */
    @Cacheable(value = "metaData", key = "'CommaSeparatedColumnNamesOf' + #tableEnum")
    String getCommaSeparatedColumnNamesOfTable(TableEnum tableEnum);
    
    /**
     * 查询数据表的所有字段
     * 
     * @param tableEnum 
     * @return String 英文逗号分隔的所有字段名
     * @author caizhukui
     * @date 2018年5月15日
     */
    @Cacheable(value = "metaData", key = "'CommaSeparatedFieldsOf' + #tableEnum")
    String getCommaSeparatedFieldsOfTable(TableEnum tableEnum);
    
    /**
     * 刷新缓存里数据表的所有字段
     * 
     * @param tableEnum 
     * @return List<String> 所有字段名
     * @author caizhukui
     * @date 2018年5月15日
     */
    @CachePut(value = "metaData", key = "'FieldsOf' + #tableEnum")
    List<String> refreshFieldsOfTable(TableEnum tableEnum);
    
    /**
     * 刷新缓存里数据表的所有字段
     * 
     * @param tableEnum 
     * @return String 英文逗号分隔的所有字段名
     * @author caizhukui
     * @date 2018年5月15日
     */
    @CachePut(value = "metaData", key = "'CommaSeparatedFieldsOf' + #tableEnum")
    String refreshCommaSeparatedFieldsOfTable(TableEnum tableEnum);
	
}
