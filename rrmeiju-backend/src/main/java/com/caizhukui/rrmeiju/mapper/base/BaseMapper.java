package com.caizhukui.rrmeiju.mapper.base;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.caizhukui.rrmeiju.bo.CriteriaBO;

/**
 * 公共Mapper接口定义
 * 
 * @author caizhukui
 * @date 2018年3月16日
 */
@CacheNamespace
public interface BaseMapper<T> extends MapperSql {
    
    String BASE_MAP = "baseMap";

    /**
     * 新增记录
     * 
     * @param tableName 表名
     * @param record 待新增的记录
     * @return int 受影响的记录数
     * @author caizhukui
     * @date 2017年1月19日
     */
    @InsertProvider(type = MapperSqlBuilder.class, method = "buildAdd")
    @Options(useGeneratedKeys = true, keyProperty = "param2.id", keyColumn = "id")
    int add(String tableName, T record);
    
    /**
     * 根据ID查询记录（子接口需覆写该方法）
     * 
     * @param tableName 表名
     * @param id 记录ID
     * @return T 记录信息
     * @author caizhukui
     * @date 2018年3月16日
     */
    T getById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID查询记录（子接口需覆写该方法）
     * 
     * @param tableName 表名
     * @param uuid 记录UUID
     * @return T 记录信息
     * @author caizhukui
     * @date 2017年1月19日
     */
    T getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);
    
    /**
     * 分页查询所有记录
     * 
     * @param tableName 表名
     * @param pageSize 每页记录数
     * @param startIndex 开始下标
     * @return List<T> 记录信息列表
     * @author caizhukui
     * @date 2017年7月12日
     */
    @Select(GET_ALL_BY_PAGINATION)
    List<T> getAllByPagination(@Param("tableName") String tableName, @Param("pageSize") int pageSize, @Param("startIndex") int startIndex);
    
    /**
     * 根据选择字段、过滤条件、排序规则、分页参数查询所有记录
     * 
     * @param tableName 表名
     * @param criteriaBO
     * @return List<T>
     * @author caizhukui
     * @date 2017年1月19日
     */
    @SelectProvider(type = MapperSqlBuilder.class, method = "buildGet")
    List<T> get(String tableName, CriteriaBO criteriaBO);
    
    /**
     * 根据过滤条件查询记录数
     * 
     * @param tableName 表名
     * @param criteriaBO
     * @return int
     * @author caizhukui
     * @date 2017年1月19日
     */
    @SelectProvider(type = MapperSqlBuilder.class, method = "buildGetCount")
    int getCount(String tableName, CriteriaBO criteriaBO);
    
    /**
     * 根据ID更新记录信息
     * 
     * @param tableName 表名
     * @param record 待更新的记录
     * @return int 受影响的记录数
     * @author caizhukui
     * @date 2017年1月19日
     */
    @UpdateProvider(type = MapperSqlBuilder.class, method = "buildUpdateById")
    int updateById(String tableName, T record);
    
    /**
     * 根据UUID更新记录信息
     * 
     * @param tableName 表名
     * @param record 待更新的记录
     * @return int 受影响的记录数
     * @author caizhukui
     * @date 2017年1月19日
     */
    @UpdateProvider(type = MapperSqlBuilder.class, method = "buildUpdateByUuid")
    int updateByUuid(String tableName, T record);
    
    /**
     * 根据ID删除记录
     * 
     * @param tableName 表名
     * @param id 记录ID
     * @return int 受影响的记录数
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Delete(DELETE_BY_ID)
    int deleteById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID删除记录
     * 
     * @param tableName 表名
     * @param uuid 记录UUID
     * @return int 受影响的记录数
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Delete(DELETE_BY_UUID)
    int deleteByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);

}
