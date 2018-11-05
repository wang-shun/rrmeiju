package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.caizhukui.rrmeiju.consts.Constant;
import com.caizhukui.rrmeiju.controller.util.Assert;
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.TelevisionDTO;
import com.caizhukui.rrmeiju.dto.response.BooleanDTO;
import com.caizhukui.rrmeiju.dto.response.Breadcrumb;
import com.caizhukui.rrmeiju.dto.response.FieldsDTO;
import com.caizhukui.rrmeiju.dto.response.Paginated;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.echarts.DoughnutChartDTO;
import com.caizhukui.rrmeiju.dto.response.television.TelevisionInfoDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.model.Television;

/**
 * 电视台控制器类
 * 
 * @author caizhukui
 * @date 2016年10月20日
 */
@RestController
@RequestMapping(value = "/v1", produces = { APPLICATION_JSON_UTF8_VALUE, APPLICATION_XML_VALUE })
public class TelevisionController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(TelevisionController.class);
	
	/**
	 * 返回电视台的所有可查询字段名
	 * 
	 * @return FieldsDTO 所有字段名
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/televisions", method = OPTIONS)
	public FieldsDTO getFields() {
	    List<String> fields = serviceFacade.getMetaDataService().getFieldsOfTable(TableEnum.TELEVISION);
	    return new FieldsDTO(fields);
	}

    /**
     * 新增电视台
     * 
     * @param televisionDTO 电视台信息
     * @param result
     * @param builder
     * @return ResponseEntity<TelevisionDTO>
     * @author caizhukui
     * @date 2016年9月27日
     */
    @RequestMapping(value = "/televisions", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TelevisionDTO> add(@Valid @RequestBody TelevisionDTO televisionDTO, BindingResult result,
            UriComponentsBuilder builder) {
        logger.debug("新增{} - televisionDTO = {}", getName(), televisionDTO);
        Assert.isFalse(result.hasErrors(), RestError.PARAMETER_ERROR, convert(result.getFieldErrors()));
        televisionDTO.setUuidIfEmpty();
        serviceFacade.getTelevisionService().add(televisionConvert.dto2Model(televisionDTO));
        HttpHeaders headers = new HttpHeaders();
        URI locationUri = builder.path("/televisions/{uuid}").buildAndExpand(televisionDTO.getUuid()).toUri();
        headers.setLocation(locationUri);
        return new ResponseEntity<>(televisionDTO, headers, HttpStatus.CREATED);
    }

    /**
     * 根据UUID删除电视台
     * 
     * @param uuid 电视台UUID
     * @return BooleanDTO 
     * @author caizhukui
     * @date 2016年9月29日
     */
    @RequestMapping(value = "/televisions/{uuid}", method = DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BooleanDTO delete(@PathVariable String uuid) {
        logger.debug("根据UUID删除{} - uuid = {}", getName(), uuid);
        Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
        serviceFacade.getTelevisionService().deleteByUuid(uuid);
        return new BooleanDTO(true);
    }
    
    /**
     * 根据UUID更新电视台
     * 
     * @param televisionDTO 电视台信息
     * @param result
     * @result BooleanDTO
     * @author caizhukui
     * @date 2016年9月27日
     */
    @RequestMapping(value = "/televisions", method = PUT, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BooleanDTO update(@Valid @RequestBody TelevisionDTO televisionDTO, BindingResult result) {
        logger.debug("根据UUID更新{} - televisionDTO = {}", getName(), televisionDTO);
        Assert.isFalse(result.hasErrors(), RestError.PARAMETER_ERROR, convert(result.getFieldErrors()));
        Assert.notNull(televisionDTO.getUuid(), RestError.PARAMETER_NOT_SATISFIED, getEmptyUuidMessage());
        serviceFacade.getTelevisionService().updateByUuid(televisionConvert.dto2Model(televisionDTO));
        return new BooleanDTO(true);
    }

    /**
     * 根据UUID查询电视台基本信息
     * 
     * @param uuid 电视台UUID
     * @return TelevisionDTO 电视台基本信息
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/televisions/{uuid}", method = GET)
    public TelevisionDTO getTelevisionByUuid(@PathVariable String uuid) {
        logger.debug("根据UUID查询{}基本信息 - uuid = {}", getName(), uuid);
        Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
        Television television = serviceFacade.getTelevisionService().getByUuid(uuid);
        Assert.notNull(television, RestError.RESOURCE_NOT_FOUND, getNonexistUuidMessage(uuid));
        return televisionConvert.model2Dto(television);
    }
    
    /**
     * 根据UUID查询电视台关联信息
     * 
     * @param uuid 电视台UUID
     * @return TelevisionInfoDTO 电视台关联信息
     * @author caizhukui
     * @date 2017年10月19日
     */
    @RequestMapping(value = "/televisionInfos/{uuid}", method = GET)
    public TelevisionInfoDTO getTelevisionInfoByUuid(@PathVariable String uuid) {
        logger.debug("根据UUID查询{}关联信息 - uuid = {}", getName(), uuid);
        Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
        Television television = serviceFacade.getTelevisionService().getByUuid(uuid);
        Assert.notNull(television, RestError.RESOURCE_NOT_FOUND, getNonexistUuidMessage(uuid));
        return televisionInfoConvert.model2Dto(television);
    }

	/**
	 * 分页查询电视台基本信息
	 * 
	 * @param criteriaDTO
	 * @return Paginated<TelevisionDTO>
	 * @author caizhukui
	 * @date 2016年9月28日
	 */
    @RequestMapping(value = "/televisions", method = GET)
    public Paginated<TelevisionDTO> getTelevisionsPaginated(CriteriaDTO criteriaDTO) {
        logger.debug("分页查询{}基本信息 - criteriaDTO = {}", getName(), criteriaDTO);
        Paginated<TelevisionDTO> paginatedDTO = serviceFacade.getTelevisionService().getDataPaginated(criteriaDTO,
                televisionConvert);
        Assert.notEmpty(paginatedDTO.getData(), RestError.NO_DATA, NO_DATA);
        return paginatedDTO;
    }

	/**
	 * 查询Breadcrumb
	 * 
	 * @param uuid 电视台UUID
	 * @return List<Breadcrumb>
	 * @author caizhukui
	 * @date 2016年9月29日
	 */
	@RequestMapping(value = "/televisions/{uuid}/breadcrumb", method = GET)
	public List<Breadcrumb> getBreadcrumbs(@PathVariable String uuid) {
		logger.debug("getBreadcrumbs - uuid = {}", uuid);
		Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
		List<Breadcrumb> breadcrumbs = new ArrayList<>();
		Television television = serviceFacade.getTelevisionService().getByUuid(uuid);
		Assert.notNull(television, RestError.RESOURCE_NOT_FOUND, getNonexistUuidMessage(uuid));
		breadcrumbs.add(new Breadcrumb(Constant.TELEVISION, television.getUuid(), television.getTelevisionName()));
		return breadcrumbs;
	}
	
	/**
	 * 查询所有电视台名称
	 * 
	 * @return List<String>
	 * @author caizhukui
	 * @date 2016年12月14日
	 */
	@RequestMapping(value = "/televisionNames", method = GET)
	public List<String> getAllTelevisionNames() {
		return serviceFacade.getTelevisionService().getAllTelevisionNames();
	}
	
	/**
	 * 查询各电视台的剧集数
	 * 
	 * @return List<Map<String, Object>>
	 * @author caizhukui
	 * @date 2016年12月14日
	 */
	@RequestMapping(value = "/televisions/serialCount", method = GET)
	public List<Map<String, Object>> getAllTelevisionSerialCount() {
	    return serviceFacade.getTelevisionService().getAllTelevisionSerialCount();
	}
	
	/**
	 * 查询
	 * 
	 * @return DoughnutChartDTO
	 * @author caizhukui
	 * @date 2016年12月15日
	 */
	@RequestMapping(value = "/televisions/charts/doughnut", method = GET)
	public DoughnutChartDTO getTelevisionSerialCountDoughnutChartData() {
		DoughnutChartDTO doughnutChartDTO = new DoughnutChartDTO();
		List<String> televisionNames = serviceFacade.getTelevisionService().getAllTelevisionNames();
		doughnutChartDTO.setLegendData(televisionNames);
		List<Map<String, Object>> televisionSerialCounts = serviceFacade.getTelevisionService().getAllTelevisionSerialCount();
		doughnutChartDTO.setSeriesData(televisionSerialCounts);
		return doughnutChartDTO;
	}

    @Override
    protected String getName() {
        return "电视台";
    }
	
}
