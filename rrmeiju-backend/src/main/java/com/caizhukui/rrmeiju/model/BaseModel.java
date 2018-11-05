package com.caizhukui.rrmeiju.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Transient;

import com.caizhukui.common.util.UuidUtils;

import lombok.Data;

/**
 * 根据阿里巴巴MySQL数据库规约，所有数据表必须有id、gmt_create、gmt_modified这3个字段<br>
 * 另外为了方便分布式存储，所有数据表必须有uuid这个字段<br>
 * 所有映射数据库表的实体类必须继承该类<br>
 * 定义属性名时必须与数据表列名对应，将下划线命名转驼峰命名即可
 * POJO中使用包装类型而不是基础类型（比如说Long而不是long）
 * 
 * @author caizhukui
 * @date 2018年1月8日
 */
@Data
public class BaseModel implements Serializable {

    private static final long serialVersionUID = -6646752002151932903L;
    
    /** 数据表主键ID，通过MyBatis生成插入语句时不指定值，由MySQL数据库自动生成，不可更新 */
    @Transient
    private Long id;
    
    /** 数据表UUID，不可更新 */
    private String uuid;
    
    /** 数据记录创建时间，通过MyBatis生成插入语句时不指定值，由MySQL数据库自动生成 */
    @Transient
    private Date gmtCreate;
    
    /** 数据记录最后更新时间，通过MyBatis生成更新语句时不指定值，由MySQL数据库自动更新 */
    @Transient
    private Date gmtModified;
    
    /**
     * 如果UUID为空，则自动生成UUID
     * 
     * @author caizhukui
     * @date 2018年3月15日
     */
    public void setUuidIfEmpty() {
        if (StringUtils.isBlank(uuid)) {
            uuid = UuidUtils.getUuid();
        }
    }
    
    /**
     * 通过调用实体类的该方法触发MyBatis立即加载所有延迟加载的属性
     * 
     * @author caizhukui
     * @date 2018年5月24日
     */
    public void lazyLoadAll() {
        
    }

}
