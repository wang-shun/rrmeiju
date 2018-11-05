package com.caizhukui.rrmeiju.mapper.base;

/**
 * SQL语句常量
 * 
 * @author caizhukui
 * @date 2018年4月24日
 */
public interface MapperSql {

    /** 根据ID查询记录 */
    String GET_BY_ID = "SELECT * FROM ${tableName} WHERE id = #{id}";
    
    /** 根据UUID查询记录 */
    String GET_BY_UUID = "SELECT * FROM ${tableName} WHERE uuid = #{uuid}";
    
    /** 分页查询所有记录 */
    String GET_ALL_BY_PAGINATION = "SELECT * FROM ${tableName} LIMIT #{pageSize} OFFSET #{startIndex}";
    
    /** 根据ID删除记录 */
    String DELETE_BY_ID = "DELETE FROM ${tableName} WHERE id = #{id}";
    
    /** 根据UUID删除记录 */
    String DELETE_BY_UUID = "DELETE FROM ${tableName} WHERE uuid = #{uuid}";
    
}
