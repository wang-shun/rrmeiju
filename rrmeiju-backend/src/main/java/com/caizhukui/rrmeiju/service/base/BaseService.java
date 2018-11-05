package com.caizhukui.rrmeiju.service.base;

import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import com.caizhukui.rrmeiju.convert.Convert;
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.response.Paginated;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年3月19日
 */
@Transactional
public interface BaseService<T> {
    
    /**
     * 新增记录
     * 
     * @param t
     * @return T
     * @author caizhukui
     * @date 2016年10月19日
     */
    @Async
    T add(T t);
    
    /**
     * 批量新增记录
     * 
     * @param list
     * @return List<T>
     * @author caizhukui
     * @date 2018年7月4日
     */
    @Async
    List<T> batchAdd(List<T> list);

    /**
     * 根据ID删除记录
     * 
     * @param id
     * @author caizhukui
     * @date 2018年4月24日
     */
    @Async
    void deleteById(Long id);
    
    /**
     * 根据UUID删除记录
     * 
     * @param uuid 记录UUID
     * @author caizhukui
     * @date 2016年10月20日
     */
    @Async
    void deleteByUuid(String uuid);

    /**
     * 根据ID更新记录
     * 
     * @param t
     * @author caizhukui
     * @date 2018年4月24日
     */
    @Async
    void updateById(T t);
    
    /**
     * 根据UUID更新记录
     * 
     * @param t
     * @author caizhukui
     * @date 2016年10月19日
     */
    @Async
    void updateByUuid(T t);

    /**
     * 根据ID查询记录
     * 
     * @param id 记录ID
     * @return T 记录信息
     * @author caizhukui
     * @date 2018年4月24日
     */
    T getById(Long id);
    
    /**
     * 根据UUID查询记录
     * 
     * @param uuid 记录UUID
     * @return T 记录信息
     * @author caizhukui
     * @date 2016年10月19日
     */
    T getByUuid(String uuid);
    
    /**
     * 根据过滤条件分页查询记录
     * 
     * @param criteriaDTO 过滤条件
     * @param convert
     * @return Paginated<DTO> 
     * @author caizhukui
     * @date 2018年5月26日
     */
    <DTO> Paginated<DTO> getDataPaginated(CriteriaDTO criteriaDTO, Convert<T, DTO> convert);
    
    /**
     * 分页查询所有记录
     * 
     * @param pageSize
     * @param pageIndex
     * @return List<T> 记录信息列表
     * @author caizhukui
     * @date 2017年4月12日
     */
    List<T> getAllByPagination(int pageSize, int pageIndex);
    
}
