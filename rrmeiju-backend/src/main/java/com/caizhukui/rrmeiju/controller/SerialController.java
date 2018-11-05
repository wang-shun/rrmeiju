package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
import com.caizhukui.rrmeiju.dto.SerialDTO;
import com.caizhukui.rrmeiju.dto.response.BooleanDTO;
import com.caizhukui.rrmeiju.dto.response.Breadcrumb;
import com.caizhukui.rrmeiju.dto.response.FieldsDTO;
import com.caizhukui.rrmeiju.dto.response.Paginated;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.serial.SerialInfoDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.model.Television;

/**
 * 美剧系列控制器类
 * 
 * @author caizhukui
 * @date 2016年10月20日
 */
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_UTF8_VALUE)
public class SerialController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(SerialController.class);
	
	/**
	 * 返回美剧系列的所有可查询字段名
	 * 
	 * @return FieldsDTO 所有字段名
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/serials", method = OPTIONS)
	public FieldsDTO getFields() {
	    List<String> fields = serviceFacade.getMetaDataService().getFieldsOfTable(TableEnum.SERIAL);
        return new FieldsDTO(fields);
	}

    /**
     * 分页查询美剧系列基本信息
     * 
     * @param criteriaDTO
     * @return SerialPaginatedDTO
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/serials", method = GET)
    public Paginated<SerialDTO> getSerialsPaginated(CriteriaDTO criteriaDTO) {
        logger.debug("分页查询{}基本信息 - criteriaDTO = {}", getName(), criteriaDTO);
        Paginated<SerialDTO> paginatedDTO = serviceFacade.getSerialService().getDataPaginated(criteriaDTO, serialConvert);
        Assert.notEmpty(paginatedDTO.getData(), RestError.NO_DATA, NO_DATA);
        return paginatedDTO;
    }
    
	/**
	 * 分页查询美剧系列关联信息
	 * 
	 * @param criteriaDTO
	 * @return SerialInfoPaginatedDTO
	 * @author caizhukui
	 * @date 2017年10月19日
	 */
	@RequestMapping(value = "/serialInfos", method = GET)
	public Paginated<SerialInfoDTO> getSerialInfosPaginated(CriteriaDTO criteriaDTO) {
    	logger.debug("分页查询{}关联信息 - criteriaDTO = {}", getName(), criteriaDTO);
    	Paginated<SerialInfoDTO> paginatedDTO = serviceFacade.getSerialService().getDataPaginated(criteriaDTO, serialInfoConvert);
        Assert.notEmpty(paginatedDTO.getData(), RestError.NO_DATA, NO_DATA);
        return paginatedDTO;
	}

    /**
     * 根据电视台UUID分页查询美剧系列基本信息
     * 
     * @param televisionUuid 电视台UUID
     * @param criteriaDTO
     * @return Paginated<SerialDTO>
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/televisions/{televisionUuid}/serials", method = GET)
    public Paginated<SerialDTO> getByTelevisionId(@PathVariable String televisionUuid, CriteriaDTO criteriaDTO) {
        logger.debug("根据电视台UUID分页查询{}基本信息 - televisionUuid = {}, criteriaDTO = {}", getName(), televisionUuid, criteriaDTO);
        String filter = criteriaDTO.getFilter();
        if (filter == null) {
            filter = "";
        }
        filter += ",televisionUuid";
        criteriaDTO.setFilter(filter);
        String keyword = criteriaDTO.getKeyword();
        if (keyword == null) {
            keyword = "";
        }
        keyword = keyword + "," + televisionUuid;
        criteriaDTO.setKeyword(keyword);
        Paginated<SerialDTO> paginatedDTO = serviceFacade.getSerialService().getDataPaginated(criteriaDTO, serialConvert);
        Assert.notEmpty(paginatedDTO.getData(), RestError.NO_DATA, NO_DATA);
        return paginatedDTO;
    }
    
    /**
     * 根据UUID查询美剧系列
     * 
     * @param serialUuid 美剧系列UUID
     * @return SerialDTO
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/serials/{uuid}", method = GET)
    public SerialDTO getSerialByUuid(@PathVariable String uuid) {
    	logger.debug("根据UUID查询{}基本信息 - uuid = {}", getName(), uuid);
    	Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
    	Serial serial = serviceFacade.getSerialService().getByUuid(uuid);
    	Assert.notNull(serial, RestError.RESOURCE_NOT_FOUND, getNonexistUuidMessage(uuid));
    	return serialConvert.model2Dto(serial);
    }
    
    /**
     * 新增美剧系列
     * 
     * @param serialDTO
     * @param result
     * @param builder
     * @return ResponseEntity<SerialDTO>
     * @author caizhukui
     * @date 2016年9月27日
     */
    @RequestMapping(value = "/serials", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SerialDTO> add(@Valid @RequestBody SerialDTO serialDTO, BindingResult result,
            UriComponentsBuilder builder) {
        logger.debug("新增{} - serialDTO = {}", getName(), serialDTO);
        Assert.isFalse(result.hasErrors(), RestError.PARAMETER_ERROR, convert(result.getFieldErrors()));
        serialDTO.setUuidIfEmpty();
        serviceFacade.getSerialService().add(serialConvert.dto2Model(serialDTO));
        HttpHeaders headers = new HttpHeaders();
        URI locationUri = builder.path("/serials/{uuid}").buildAndExpand(serialDTO.getUuid()).toUri();
        headers.setLocation(locationUri);
        return new ResponseEntity<>(serialDTO, headers, HttpStatus.CREATED);
    }
	
	/**
	 * 根据UUID更新美剧系列
	 * 
	 * @param serialDTO 美剧系列信息
	 * @param result
	 * @return BooleanDTO
	 * @author caizhukui
	 * @date 2016年9月28日
	 */
	@RequestMapping(value = "/serials", method = PUT, consumes = APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public BooleanDTO updateByUuid(@Valid @RequestBody SerialDTO serialDTO, BindingResult result) {
        logger.debug("根据UUID更新{}基本信息 - serialDTO = {}", getName(), serialDTO);
        Assert.isFalse(result.hasErrors(), RestError.PARAMETER_ERROR, convert(result.getFieldErrors()));
        Assert.notNull(serialDTO.getUuid(), RestError.PARAMETER_NOT_SATISFIED, getEmptyUuidMessage());
        serviceFacade.getSerialService().updateByUuid(serialConvert.dto2Model(serialDTO));
        return new BooleanDTO(true);
	}
	
	/**
	 * 根据UUID删除美剧系列
	 * 
	 * @param uuid 美剧系列UUID
	 * @return BooleanDTO 
	 * @author caizhukui
	 * @date 2016年9月28日
	 */
	@RequestMapping(value = "/serials/{uuid}", method = DELETE)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public BooleanDTO deleteByUuid(@PathVariable String uuid) {
		logger.debug("根据UUID删除{} - uuid = {}", getName(), uuid);
		Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
		serviceFacade.getSerialService().deleteByUuid(uuid);
		return new BooleanDTO(true);
	}
	
	/**
	 * 查询Breadcrumb
	 * 
	 * @param uuid 美剧系列UUID
	 * @return List<Breadcrumb>
	 * @author caizhukui
	 * @date 2016年9月29日
	 */
	@RequestMapping(value = "/serials/{uuid}/breadcrumb", method = GET)
	public List<Breadcrumb> getBreadcrumbs(@PathVariable String uuid) {
	    logger.debug("getBreadcrumbs - uuid = {}", uuid);
	    Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
		List<Breadcrumb> breadcrumbs = new ArrayList<>();
		Serial serial = serviceFacade.getSerialService().getByUuid(uuid);
		if (serial == null) {
			String developerMessage = "Unable to find serial with id '" + uuid + "'";
    		throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setDetail(developerMessage));
		}
		Television television = serviceFacade.getTelevisionService().getByUuid(serial.getTelevisionUuid());
		breadcrumbs.add(new Breadcrumb(Constant.TELEVISION, television.getUuid(), television.getTelevisionName()));
		breadcrumbs.add(new Breadcrumb(Constant.SERIAL, serial.getUuid(), serial.getEnglishName()));
		return breadcrumbs;
	}

    @Override
    protected String getName() {
        return "美剧系列";
    }
	
}
