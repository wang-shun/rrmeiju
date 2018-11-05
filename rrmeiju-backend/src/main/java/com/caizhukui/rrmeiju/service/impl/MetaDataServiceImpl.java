package com.caizhukui.rrmeiju.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.common.util.StringUtils;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.MetaDataMapper;
import com.caizhukui.rrmeiju.service.MetaDataService;

/**
 * 数据库元数据服务实现类
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
@Service
public class MetaDataServiceImpl implements MetaDataService {
	
	private static final Logger logger = LoggerFactory.getLogger(MetaDataServiceImpl.class);
	
	@Autowired
	private MetaDataMapper metaDataMapper;

    @Override
    public List<String> getColumnNamesOfTable(TableEnum tableEnum) {
        return metaDataMapper.getColumnNamesOfTable(tableEnum.getTableName());
    }

    @Override
    public List<String> getFieldsOfTable(TableEnum tableEnum) {
        List<String> columnNames = getColumnNamesOfTable(tableEnum);
        List<String> fields = new ArrayList<>(columnNames.size());
        columnNames.stream().filter(columnName -> isDisplayableColumnName(columnName))
                .forEach(columnName -> fields.add(StringUtils.underlineToCamel(columnName)));
        return fields;
    }

    @Override
    public String getCommaSeparatedColumnNamesOfTable(TableEnum tableEnum) {
        List<String> columnNames = getColumnNamesOfTable(tableEnum);
        return StringUtils.list2CommaSeparatedString(columnNames);
    }

    @Override
    public String getCommaSeparatedFieldsOfTable(TableEnum tableEnum) {
        List<String> fields = getFieldsOfTable(tableEnum);
        return StringUtils.list2CommaSeparatedString(fields);
    }
    
    @Override
    public List<String> refreshFieldsOfTable(TableEnum tableEnum) {
        return getFieldsOfTable(tableEnum);
    }
    
    @Override
    public String refreshCommaSeparatedFieldsOfTable(TableEnum tableEnum) {
        return getCommaSeparatedFieldsOfTable(tableEnum);
    }
    
    /**
     * 根据字段名返回是否需要显示
     * 
     * @param columnName 字段名
     * @return boolean 是否需要显示
     * @author caizhukui
     * @date 2018年5月25日
     */
    private boolean isDisplayableColumnName(String columnName) {
        final String[] nondisplayableColumnNames = new String[] { "id", "gmt_create", "gmt_modified" };
        for (String nondisplayableColumnName : nondisplayableColumnNames) {
            if (nondisplayableColumnName.equals(columnName)) {
                return false;
            }
        }
        return true;
    }

}
