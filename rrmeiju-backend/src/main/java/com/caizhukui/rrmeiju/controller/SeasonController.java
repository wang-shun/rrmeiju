package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.bo.CriteriaBO;
import com.caizhukui.rrmeiju.consts.Constant;
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.SeasonDTO;
import com.caizhukui.rrmeiju.dto.response.Breadcrumb;
import com.caizhukui.rrmeiju.dto.response.Pagination;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.season.SeasonPaginatedDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.model.Television;

/**
 * 美剧季控制器类
 * 
 * @author caizhukui
 * @date 2017年1月17日
 */
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_UTF8_VALUE)
public class SeasonController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(SeasonController.class);
	
	/**
	 * 查询美剧季所有字段
	 * 
	 * @return List<String> 所有字段名
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/seasons", method = OPTIONS)
	public List<String> getFields() {
		return serviceFacade.getMetaDataService().getFieldsOfTable(TableEnum.SEASON);
	}
	
	/**
	 * 分页查询美剧季
	 * 
	 * @param pageSize 每页记录数
	 * @param pageIndex 页数下标
	 * @return SeasonPaginatedDTO
	 * @author caizhukui
	 * @date 2016年9月28日
	 */
	@RequestMapping(value = "/seasons", method = GET)
    public SeasonPaginatedDTO get(CriteriaDTO criteriaDTO) {
		logger.info("get - criteriaDTO = {}", criteriaDTO);
		checkCriteria(criteriaDTO, TableEnum.SEASON);
		CriteriaBO criteriaBO = convertCriteria(criteriaDTO, TableEnum.SEASON);
    	List<Season> seasons = serviceFacade.getSeasonService().get(criteriaBO);
    	SeasonPaginatedDTO seasonPaginatedDTO = new SeasonPaginatedDTO();
    	seasonPaginatedDTO.setSeasons(seasonConvert.model2Dto(seasons));
    	int seasonCount = serviceFacade.getSeasonService().getCount(criteriaBO);
    	Pagination pagination = new Pagination(seasonCount, criteriaDTO.getPageSize(), criteriaDTO.getPageIndex());
    	seasonPaginatedDTO.setPagination(pagination);
    	return seasonPaginatedDTO;
    }
	
	/**
	 * 根据seasonId查询Season
	 * 
	 * @param seasonId 季ID
	 * @return SeasonDTO
	 * @author caizhukui
	 * @date 2016年9月28日
	 */
	@RequestMapping(value = "/seasons/{seasonId}", method = GET)
    public SeasonDTO getBySeasonId(@PathVariable String seasonId) {
		logger.info("getBySeasonId - seasonId = {}", seasonId);
    	Season season = serviceFacade.getSeasonService().getByUuid(seasonId);
    	if (season == null) {
    		String developerMessage = "Unable to find season with id '" + seasonId + "'";
    		throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setDetail(developerMessage));
    	}
    	return seasonConvert.model2Dto(season);
    }
	
	/**
	 * 根据serialId分页查询Season
	 * 
	 * @param serialId 季ID
	 * @param criteriaDTO
	 * @return SeasonPaginatedDTO
	 * @author caizhukui
	 * @date 2016/9/28
	 */
	@RequestMapping(value = "/serials/{serialId}/seasons", method = GET)
    public SeasonPaginatedDTO getBySerialId(@PathVariable String serialId, CriteriaDTO criteriaDTO) {
		logger.info("getBySerialId - serialId = {}, criteriaDTO = {}", serialId, criteriaDTO);
		checkCriteria(criteriaDTO, TableEnum.SEASON);
		CriteriaBO criteriaBo = convertCriteria(criteriaDTO, TableEnum.SEASON);
		// 增加SerialId过滤条件
    	StringBuffer sb = new StringBuffer();
    	sb.append("serial_id = '");
    	sb.append(serialId);
    	sb.append("'");
    	String filterCondition = criteriaBo.getFilterCondition();
    	if (filterCondition != null) {
    		sb.append(" AND ");
    		sb.append(filterCondition);
		} 
		criteriaBo.setFilterCondition(sb.toString());
    	List<Season> seasons = serviceFacade.getSeasonService().get(criteriaBo);
    	SeasonPaginatedDTO seasonPaginationDTO = new SeasonPaginatedDTO();
    	seasonPaginationDTO.setSeasons(seasonConvert.model2Dto(seasons));
    	int seasonCount = serviceFacade.getSeasonService().getCount(criteriaBo);
    	Pagination pagination = new Pagination(seasonCount, criteriaDTO.getPageSize(), criteriaDTO.getPageIndex());
    	seasonPaginationDTO.setPagination(pagination);
    	return seasonPaginationDTO;
    }
    
	/**
	 * 新增美剧季
	 * 
	 * @param seasonDTO
	 * @param result
	 * @return SeasonDTO
	 * @author caizhukui
	 * @date 2016/9/27
	 */
	@RequestMapping(value = "/seasons", method = POST)
	public SeasonDTO add(@Valid @RequestBody SeasonDTO seasonDTO, BindingResult result) {
		logger.info("add - seasonDTO = {}", seasonDTO);
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();  
			throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetails(convert(errors)));
		}
		String seasonUuid = UuidUtils.getUuid();
		seasonDTO.setUuid(seasonUuid);
		// 异步新增
		serviceFacade.getSeasonService().add(seasonConvert.dto2Model(seasonDTO));
		return seasonDTO;
	}
	
	/**
	 * 更新Season
	 * 
	 * @param seasonDTO
	 * @param result
	 * @return SeasonDTO
	 * @author caizhukui
	 * @date 2016/9/27
	 */
	@RequestMapping(value = "/seasons", method = PUT)
	public void update(@Valid @RequestBody SeasonDTO seasonDTO, BindingResult result) {
		logger.info("update - seasonDTO = {}", seasonDTO);
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetails(convert(errors)));
		}
		// 异步更新
		serviceFacade.getSeasonService().updateByUuid(seasonConvert.dto2Model(seasonDTO));
	}
	
	/**
	 * 删除美剧季
	 * 
	 * @param seasonUuid 美剧季UUID
	 * @author caizhukui
	 * @date 2016/9/27
	 */
	@RequestMapping(value = "/seasons/{seasonId}", method = DELETE)
	public void delete(@PathVariable String seasonUuid) {
		logger.info("delete - seasonUuid = {}", seasonUuid);
		// 异步删除
		serviceFacade.getSeasonService().deleteByUuid(seasonUuid);
	}
	
	/**
	 * 查询Breadcrumb
	 * 
	 * @param seasonId 季ID
	 * @return List<Breadcrumb>
	 * @author caizhukui
	 * @date 2016/9/29
	 */
	@RequestMapping(value = "/seasons/{seasonId}/breadcrumb", method = GET)
	public List<Breadcrumb> getBreadcrumbs(@PathVariable String seasonId) {
		logger.info("getBreadcrumbs - seasonId = {}", seasonId);
		List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();
		Season season = serviceFacade.getSeasonService().getByUuid(seasonId);
		if (season == null) {
			String developerMessage = "Unable to find season with id '" + seasonId + "'";
    		throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setDetail(developerMessage));
		}
		Serial serial = serviceFacade.getSerialService().getByUuid(season.getSerialUuid());
		Television television = serviceFacade.getTelevisionService().getByUuid(serial.getTelevisionUuid());
		breadcrumbs.add(new Breadcrumb(Constant.TELEVISION, television.getUuid(), television.getTelevisionName()));
		breadcrumbs.add(new Breadcrumb(Constant.SERIAL, serial.getUuid(), serial.getEnglishName()));
		breadcrumbs.add(new Breadcrumb(Constant.SEASON, season.getUuid(), season.getEnglishName()));
		return breadcrumbs;
	}

    @Override
    protected String getName() {
        return "美剧季";
    }
	
}
