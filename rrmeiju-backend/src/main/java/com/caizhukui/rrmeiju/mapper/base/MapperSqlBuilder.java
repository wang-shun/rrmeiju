package com.caizhukui.rrmeiju.mapper.base;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.data.annotation.Transient;

import com.caizhukui.common.util.StringUtils;
import com.caizhukui.rrmeiju.bo.CriteriaBO;

/**
 * 动态SQL生成类
 * 
 * @author caizhukui
 * @date 2018年4月24日
 */
public class MapperSqlBuilder {
    
    /**
     * 动态生成“根据选择字段、过滤条件、排序规则、分页参数查询所有记录”的SQL语句
     * 
     * @param tableName 表名
     * @param criteriaBO 封装好的选择字段、过滤条件、排序规则、分页参数
     * @return String 动态生成的SQL语句
     * @author caizhukui
     * @date 2018年4月24日
     */
    public static String buildGet(final String tableName, final CriteriaBO criteriaBO) {
        StringBuffer sb = new StringBuffer();
        String sqlWithoutPagination = new SQL() {
            {
                SELECT(criteriaBO.getSelectedFields());
                FROM(tableName);
                String filterCondition = criteriaBO.getFilterCondition();
                if (filterCondition != null) {
                    WHERE(filterCondition);
                }
                String sortCondition = criteriaBO.getSortCondition();
                if (sortCondition != null) {
                    ORDER_BY(sortCondition);
                }
            }
        }.toString();
        sb.append(sqlWithoutPagination);
        sb.append(" LIMIT ");
        sb.append(criteriaBO.getPageSize());
        sb.append(" OFFSET ");
        sb.append(criteriaBO.getStartIndex());
        return sb.toString();
    }
    
    /**
     * 动态生成“根据过滤条件查询记录数”的SQL语句
     * 
     * @param tableName 表名
     * @param criteriaBO 封装好的选择字段、过滤条件、排序规则、分页参数
     * @return String 动态生成的SQL语句
     * @author caizhukui
     * @date 2018年4月24日
     */
    public static String buildGetCount(final String tableName, final CriteriaBO criteriaBO) {
        return new SQL() {
            {
                SELECT("COUNT(id)");
                FROM(tableName);
                String filterCondition = criteriaBO.getFilterCondition();
                if (filterCondition != null) {
                    WHERE(filterCondition);
                }
            }
        }.toString();
    }
    
    /**
     * 动态生成“新增记录”的SQL语句
     * 
     * @param tableName 表名
     * @param record 待新增的记录
     * @return String 动态生成的SQL语句
     * @author caizhukui
     * @date 2018年5月22日
     */
    public static String buildAdd(final String tableName, final Object record) {
        Set<String> fieldNames = getInsertFieldNames(record);
        int fieldCount = fieldNames.size();
        List<String> columnNames = new ArrayList<>(fieldCount);
        List<String> valuePlaceholders = new ArrayList<>(fieldCount);
        for (String fieldName : fieldNames) {
            columnNames.add(getColumnName(fieldName));
            valuePlaceholders.add(getValuePlaceholder(fieldName));
        }
        String commaSeparatedColumnNames = StringUtils.list2CommaSeparatedString(columnNames);
        String commaSeparatedValuePlaceholders = StringUtils.list2CommaSeparatedString(valuePlaceholders);
        return new SQL()
            .INSERT_INTO(tableName)
            .VALUES(commaSeparatedColumnNames, commaSeparatedValuePlaceholders)
            .toString();
    }
    
    /**
     * 动态生成“根据UUID更新记录信息”的SQL语句
     * 
     * @param tableName 表名
     * @param record 待更新的记录
     * @return String 动态生成的SQL语句
     * @author caizhukui
     * @date 2018年5月22日
     */
    public static String buildUpdateByUuid(final String tableName, final Object record) {
        Set<String> fieldNames = getUpdateFieldNames(record);
        Map<String, String> map = new HashMap<>();
        for (String fieldName : fieldNames) {
            map.put(getColumnName(fieldName), getValuePlaceholder(fieldName));
        }
        return new SQL() {
            {
                UPDATE(tableName);
                if (map.size() == 0) {
                    SET("uuid = #{param2.uuid}");
                } else {
                    map.forEach((columnName, valuePlaceholder) -> SET(columnName + " = " + valuePlaceholder));
                }
                WHERE("uuid = #{param2.uuid}");
            }
        }.toString();
    }
    
    /**
     * 动态生成“根据ID更新记录信息”的SQL语句
     * 
     * @param tableName 表名
     * @param record 待更新的记录
     * @return String 动态生成的SQL语句
     * @author caizhukui
     * @date 2018年5月22日
     */
    public static String buildUpdateById(final String tableName, final Object record) {
        Set<String> fieldNames = getUpdateFieldNames(record);
        Map<String, String> map = new HashMap<>();
        for (String fieldName : fieldNames) {
            map.put(getColumnName(fieldName), getValuePlaceholder(fieldName));
        }
        return new SQL() {
            {
                UPDATE(tableName);
                if (map.size() == 0) {
                    SET("id = #{param2.id}");
                } else {
                    map.forEach((columnName, valuePlaceholder) -> SET(columnName + " = " + valuePlaceholder));
                }
                WHERE("id = #{param2.id}");
            }
        }.toString();
    }

    /**
     * 通过反射获取新增时与数据表列名对应的字段名
     * 
     * @param object
     * @return Set<String>
     * @author caizhukui
     * @date 2018年5月22日
     */
    private static Set<String> getInsertFieldNames(final Object object) {
        Set<String> insertFieldNames = new HashSet<>();
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Annotation transientAnnotation = field.getDeclaredAnnotation(Transient.class);
                boolean isTransient = transientAnnotation == null ? false : true;
                boolean isStatic = Modifier.isStatic(field.getModifiers());
                boolean isInsertField = ! (isTransient || isStatic); 
                if (isInsertField) {
                    insertFieldNames.add(field.getName());
                }
            }
        }
        return insertFieldNames;
    }
    
    /**
     * 通过反射获取更新时与数据表列名对应的字段名
     * 
     * @param object
     * @return Set<String>
     * @author caizhukui
     * @date 2018年5月22日
     */
    private static Set<String> getUpdateFieldNames(final Object object) {
        Set<String> updateFieldNames = new HashSet<>();
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                Annotation transientAnnotation = field.getDeclaredAnnotation(Transient.class);
                boolean isTransient = transientAnnotation == null ? false : true;
                boolean isNull = true;
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(object);
                    isNull = fieldValue == null ? true : false;
                } catch (IllegalArgumentException | IllegalAccessException ignore) {}
                String fieldName = field.getName();
                boolean isUuid = StringUtils.equals(fieldName, "uuid");
                boolean isStatic = Modifier.isStatic(field.getModifiers());
                boolean isUpdateField = ! (isTransient || isNull || isUuid || isStatic); 
                if (isUpdateField) {
                    updateFieldNames.add(fieldName);
                }
            }
        }
        return updateFieldNames;
    }
    
    /**
     * 
     * 
     * @param fieldName 字段名
     * @return String 
     * @author caizhukui
     * @date 2018年5月22日
     */
    private static String getColumnName(String fieldName) {
        return StringUtils.camelToUnderline(fieldName);
    }
    
    /**
     * 
     * 
     * @param fieldName 字段名
     * @return String 
     * @author caizhukui
     * @date 2018年5月22日
     */
    private static String getValuePlaceholder(String fieldName) {
        return StringUtils.concat("#{param2.", fieldName, "}");
    }

}
