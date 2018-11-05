package com.caizhukui.rrmeiju.service.base;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.common.util.CollectionUtils;
import com.caizhukui.common.util.StringUtils;
import com.caizhukui.rrmeiju.bo.CriteriaBO;
import com.caizhukui.rrmeiju.consts.Constant;
import com.caizhukui.rrmeiju.consts.DatabaseConstant;
import com.caizhukui.rrmeiju.convert.Convert;
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.response.Paginated;
import com.caizhukui.rrmeiju.dto.response.Pagination;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.BaseModel;
import com.caizhukui.rrmeiju.service.CommonServiceFacade;
import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * 基础服务实现类
 * 
 * @author caizhukui
 * @date 2017年6月10日
 */
@Service
public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {
    
    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Autowired
	protected ServiceFacade serviceFacade;
	
	@Autowired
	protected CommonServiceFacade commonServiceFacade;

    @Override
    public T add(T t) {
        t.setUuidIfEmpty();
        preProcess(t);
        int count = getMapper().add(getTableName(), t);
        if (count != 1) {
            logger.warn("新增记录失败 - {}, {}", getTableName(), t);
        }
        return t;
    }
    
    @Override
    public List<T> batchAdd(List<T> list) {
        for (T t : list) {
            add(t);
        }
        return list;
    }
    
    @Override
    public void updateById(T t) {
        int count = getMapper().updateById(getTableName(), t);
        if (count != 1) {
            logger.warn("根据ID更新记录失败 - {}, {}", getTableName(), t);
        }
    }

    @Override
    public void updateByUuid(T t) {
        int count = getMapper().updateByUuid(getTableName(), t);
        if (count != 1) {
            logger.warn("根据UUID更新记录失败 - {}, {}", getTableName(), t);
        }
    }
    
    @Override
    public void deleteById(Long id) {
        int count = getMapper().deleteById(getTableName(), id);
        if (count != 1) {
            logger.warn("根据ID删除记录失败 - {}, {}", getTableName(), id);
        }
    }

    @Override
    public void deleteByUuid(String uuid) {
        int count = getMapper().deleteByUuid(getTableName(), uuid);
        if (count != 1) {
            logger.warn("根据UUID删除记录失败 - {}, {}", getTableName(), uuid);
        }
    }

    @Override
    public T getById(Long id) {
        return getMapper().getById(getTableName(), id);
    }

    @Override
    public T getByUuid(String uuid) {
        return getMapper().getByUuid(getTableName(), uuid);
    }

    @Override
    public <DTO> Paginated<DTO> getDataPaginated(CriteriaDTO criteriaDTO, Convert<T, DTO> convert) {
        Paginated<DTO> paginatedDTO = new Paginated<>();
        checkCriteria(criteriaDTO);
        CriteriaBO criteriaBO = convertCriteria(criteriaDTO);
        List<T> models = getData(criteriaBO);
        paginatedDTO.setData(convert.model2Dto(models));
        int count = getCount(criteriaBO);
        Pagination pagination = new Pagination(count, criteriaDTO.getPageSize(), criteriaDTO.getPageIndex());
        paginatedDTO.setPagination(pagination);
        return paginatedDTO;
    }

    @Override
    public List<T> getAllByPagination(int pageSize, int pageIndex) {
        int startIndex = (pageIndex - 1) * pageSize;
        return getMapper().getAllByPagination(getTableName(), pageSize, startIndex);
    }
    
    /**
     * 返回相应的DAO接口
     * 
     * @return Mapper<T>
     * @author caizhukui
     * @date 2018年4月21日
     */
    protected abstract BaseMapper<T> getMapper();
    
    /**
     * 将实体类映射保存到数据库之前的操作
     * 
     * @param t
     * @return T
     * @author caizhukui
     * @date 2018年4月21日
     */
    protected T preProcess(T t) {
        return t;
    }

    /**
     * 获取数据库表的枚举类型
     * 
     * @return TableEnum 数据库表的枚举类型
     * @author caizhukui
     * @date 2018年4月24日
     */
    protected abstract TableEnum getTable();

    /**
     * 获取数据库表名
     * 
     * @return String 数据库表名
     * @author caizhukui
     * @date 2018年5月17日
     */
    private String getTableName() {
        return getTable().getTableName();
    }

    /**
     * 根据选择字段、过滤条件、排序规则、分页参数查询
     * 
     * @param criteriaBO
     * @return List<T> 如果没有记录，返回空列表而不是null
     * @author caizhukui
     * @date 2016年10月19日
     */
    private List<T> getData(CriteriaBO criteriaBO) {
        List<T> records = getMapper().get(getTableName(), criteriaBO);
        return CollectionUtils.emptyListInsteadOfNull(records);
    }

    /**
     * 根据过滤条件查询数量
     * 
     * @param criteriaBO
     * @return int
     * @author caizhukui
     * @date 2016年10月19日
     */
    private int getCount(CriteriaBO criteriaBO) {
        return getMapper().getCount(getTableName(), criteriaBO);
    }
    
    /**
     * 校验CriteriaDTO参数
     * 
     * @param criteriaDTO
     * @param tableEnum
     * @throws InvalidParameterException
     * @author caizhukui
     * @date 2016年10月11日
     */
    private void checkCriteria(CriteriaDTO criteriaDTO) throws InvalidParameterException {
        List<String> allFields = serviceFacade.getMetaDataService().getFieldsOfTable(getTable());
        // 校验resultFields参数
        String commaSeparatedResultFields = criteriaDTO.getFields();
        if (commaSeparatedResultFields != null) {
            checkResultFields(commaSeparatedResultFields, allFields);
        }
        // 校验orderFields参数
        String commaSeparatedOrderFields = criteriaDTO.getSort();
        if (commaSeparatedOrderFields != null) {
            checkOrderFields(commaSeparatedOrderFields, allFields);
        }
        // 校验filterFields参数
        String commaSeparatedFilterFields = criteriaDTO.getFilter();
        if (commaSeparatedFilterFields != null) {
            checkFilterFields(commaSeparatedFilterFields, allFields);
        }
        // 校验分页参数
        int pageIndex = criteriaDTO.getPageIndex();
        int pageSize = criteriaDTO.getPageSize();
        checkPagination(pageIndex, pageSize);
    }
    
    /**
     * 把CriteriaDTO转换成CriteriaBO
     * 
     * @param criteriaDTO
     * @param tableEnum
     * @return CriteriaBO
     * @author caizhukui
     * @date 2016年10月11日
     */
    private CriteriaBO convertCriteria(CriteriaDTO criteriaDTO) {
        CriteriaBO criteriaBO = new CriteriaBO();
        int pageIndex = criteriaDTO.getPageIndex();
        int pageSize = criteriaDTO.getPageSize();
        int startIndex = (pageIndex - 1) * pageSize;
        criteriaBO.setStartIndex(startIndex);
        criteriaBO.setPageSize(pageSize);
        // 转换resultFields参数
        String commaSeparatedAllColumnNames = serviceFacade.getMetaDataService().getCommaSeparatedColumnNamesOfTable(getTable());
        String commaSeparatedSelectedColumnNames = null;
        String commaSeparatedSelectedFields = criteriaDTO.getFields();
        if (commaSeparatedSelectedFields == null) {
            commaSeparatedSelectedColumnNames = commaSeparatedAllColumnNames;
        } else {
            commaSeparatedSelectedColumnNames = StringUtils.camelToUnderline(commaSeparatedSelectedFields);
        }
        criteriaBO.setSelectedFields(commaSeparatedSelectedColumnNames);
        // 转换filterFields参数
        String commaSeparatedFilterFields = criteriaDTO.getFilter();
        String keyword = criteriaDTO.getKeyword();
        criteriaBO.setFilterCondition(convertFilterFields(commaSeparatedFilterFields, keyword));
        // 转换orderFields参数
        String commaSeparatedSortFields = criteriaDTO.getSort();
        criteriaBO.setSortCondition(convertSortFields(commaSeparatedSortFields));
        return criteriaBO;
    }

    /**
     * 校验结果字段参数
     * 
     * @param commaSeparatedResultFields
     * @param allFields
     * @throws InvalidParameterException
     * @author caizhukui
     * @date 2016年10月11日
     */
    private void checkResultFields(String commaSeparatedResultFields, List<String> allFields) throws InvalidParameterException {
        List<String> resultFields = StringUtils.commaSeparatedString2List(commaSeparatedResultFields);
        checkFields(resultFields, allFields, "结果字段");
    }
    
    /**
     * 校验过滤字段参数
     * 
     * @param commaSeparatedFilterFields
     * @param allFields
     * @throws InvalidParameterException
     * @author caizhukui
     * @date 2016年10月11日
     */
    private void checkFilterFields(String commaSeparatedFilterFields, List<String> allFields) throws InvalidParameterException {
        List<String> filterFields = StringUtils.commaSeparatedString2List(commaSeparatedFilterFields);
        for (String filterField : filterFields) {
            if (filterField.startsWith(Constant.FILTER_STRICT_SYMBOL)) {
                filterField = filterField.substring(Constant.FILTER_STRICT_SYMBOL.length());
            }
        }
        checkFields(filterFields, allFields, "过滤字段");
    }

    /**
     * 校验排序字段参数
     * 
     * @param commaSeparatedOrderFields
     * @param allFields
     * @throws InvalidParameterException
     * @author caizhukui
     * @date 2016年10月11日
     */
    private void checkOrderFields(String commaSeparatedOrderFields, List<String> allFields) throws InvalidParameterException {
        List<String> orderFields = StringUtils.commaSeparatedString2List(commaSeparatedOrderFields);
        for (String orderField : orderFields) {
            if (orderField.startsWith(Constant.ORDER_ASC_SYMBOL)) {
                orderField = orderField.substring(Constant.ORDER_ASC_SYMBOL.length());
            } else if (orderField.startsWith(Constant.ORDER_DESC_SYMBOL)) {
                orderField = orderField.substring(Constant.ORDER_DESC_SYMBOL.length());
            }
        }
        checkFields(orderFields, allFields, "排序字段");
    }
    
    /**
     * 转换过滤字段参数，*表示严格匹配。转换成SQL时，不带*的字段使用LIKE，带*的字段使用=
     * 
     * @param commaSeparatedFilterFields 逗号分隔的过滤字段参数
     * @param keyword 关键字
     * @return String
     * @author caizhukui
     * @date 2016年10月11日
     */
    private String convertFilterFields(String commaSeparatedFilterFields, String keyword) {
        if (commaSeparatedFilterFields != null) {
            if (StringUtils.isEmpty(keyword)) {
                commaSeparatedFilterFields = null;
            } else {
                StringBuffer sb = new StringBuffer();
                String[] filterFields = commaSeparatedFilterFields.split(Constant.FIELD_SEPARATOR);
                keyword = keyword.trim();
                String[] keywords = keyword.split(Constant.FIELD_SEPARATOR);
                int index = 0;
                for (String field : filterFields) {
                    field = StringUtils.camelToUnderline(field.trim());
                    if (field.startsWith(Constant.FILTER_STRICT_SYMBOL)) {
                        sb.append(" AND "); // 前后各1个空格，长度为5
                        sb.append(field.substring(Constant.FILTER_STRICT_SYMBOL.length()));
                        sb.append(" = '");
                        sb.append(keywords[index++]);
                        sb.append("'");
                    } else {
                        sb.append("  OR "); // 前面2个空格，后面1个空格，长度为5
                        sb.append(field);
                        sb.append(" LIKE '%");
                        sb.append(keyword);
                        sb.append("%'");
                    }
                }
                commaSeparatedFilterFields = sb.toString().substring(5);
                sb.setLength(0);
                sb.append("(");
                sb.append(commaSeparatedFilterFields);
                sb.append(")");
                commaSeparatedFilterFields = sb.toString();
            }
        }
        logger.debug("commaSeparatedFilterFields = {}", commaSeparatedFilterFields);
        return commaSeparatedFilterFields;
    }
    
    /**
     * 转换排序字段参数
     * 
     * @param commaSeparatedSortFields 逗号分隔的排序字段参数
     * @return String
     * @author caizhukui
     * @date 2016年10月11日
     */
    private String convertSortFields(String commaSeparatedSortFields) {
        if (commaSeparatedSortFields != null) {
            StringBuffer sb = new StringBuffer();
            String[] orderFields = commaSeparatedSortFields.split(Constant.FIELD_SEPARATOR);
            for (String field : orderFields) {
                field = StringUtils.camelToUnderline(field.trim());
                if (field.startsWith(Constant.ORDER_ASC_SYMBOL)) {
                    field = field.substring(Constant.ORDER_ASC_SYMBOL.length());
                    sb.append(DatabaseConstant.COMMA);
                    sb.append(field);
                    sb.append(DatabaseConstant.SPACE);
                    sb.append(DatabaseConstant.ORDER_ASC);
                } else if (field.startsWith(Constant.ORDER_DESC_SYMBOL)) {
                    field = field.substring(Constant.ORDER_DESC_SYMBOL.length());
                    sb.append(DatabaseConstant.COMMA);
                    sb.append(field);
                    sb.append(DatabaseConstant.SPACE);
                    sb.append(DatabaseConstant.ORDER_DESC);
                } else {
                    sb.append(DatabaseConstant.COMMA);
                    sb.append(field);
                    sb.append(DatabaseConstant.SPACE);
                    sb.append(DatabaseConstant.ORDER_ASC);
                }
            }
            commaSeparatedSortFields = sb.toString().substring(DatabaseConstant.COMMA.length());
        }
        logger.info("commaSeparatedSortFields = {}", commaSeparatedSortFields);
        return commaSeparatedSortFields;
    }
    
    /**
     * 校验字段名<br>
     * REST接口中的字段名是小驼峰命名法，数据库表字段名是下划线命名法，需要转换
     * 
     * @param fields 待校验的字段名
     * @param allFields 所有有效字段名
     * @param paramName 参数名
     * @throws InvalidParameterException
     * @author caizhukui
     * @date 2016年10月11日
     */
    private void checkFields(List<String> fields, List<String> allFields, String paramName) throws InvalidParameterException {
        List<String> developerMessages = new ArrayList<>();
        for (String field : fields) {
            if (!allFields.contains(StringUtils.camelToUnderline(field.trim()))) {
                developerMessages.add(paramName + field + "不存在");
            }
        }
        if (CollectionUtils.isNotEmpty(developerMessages)) {
            throw new RestControllerException(RestError.PARAMETER_ERROR.setDetails(developerMessages));
        }
    }
    
    /**
     * 校验分页参数
     * 
     * @param pageIndex 第几页
     * @param pageSize 每页记录数
     * @throws InvalidParameterException
     * @author caizhukui
     * @date 2016年10月13日
     */
    private void checkPagination(int pageIndex, int pageSize) throws InvalidParameterException {
        List<String> developerMessages = new ArrayList<String>();
        if (pageIndex <= 0) {
            developerMessages.add("分页参数 pageIndex（第几页）必须大于0");
        }
        if (pageSize <= 0) {
            developerMessages.add("分页参数 pageSize（每页记录数）必须大于0");
        }
        if (CollectionUtils.isNotEmpty(developerMessages)) {
            throw new RestControllerException(RestError.PARAMETER_ERROR.setDetails(developerMessages));
        }
    }
    
}
