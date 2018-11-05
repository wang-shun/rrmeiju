package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.controller.util.Assert;
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.SubtitleDTO;
import com.caizhukui.rrmeiju.dto.SubtitleFileDTO;
import com.caizhukui.rrmeiju.dto.response.BooleanDTO;
import com.caizhukui.rrmeiju.dto.response.FieldsDTO;
import com.caizhukui.rrmeiju.dto.response.Paginated;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.subtitle.SubtitleInfoDTO;
import com.caizhukui.rrmeiju.dto.response.subtitle.SubtitlePaginatedDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.SubtitleFile;

/**
 * 字幕控制器类
 * 
 * @author caizhukui
 * @date 2017年1月17日
 */
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_UTF8_VALUE)
public class SubtitleController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(SubtitleController.class);
	
	/**
	 * 返回字幕的所有可查询字段名
	 * 
	 * @return FieldsDTO 所有字段名
	 * @author caizhukui
	 * @date 2017年1月23日
	 */
	@RequestMapping(value = "/subtitles", method = OPTIONS)
	public FieldsDTO getFields() {
	    List<String> fields = serviceFacade.getMetaDataService().getFieldsOfTable(TableEnum.SUBTITLE);
		return new FieldsDTO(fields);
	}

    /**
     * 新增字幕
     * 
     * @param subtitleDTO 字幕信息
     * @param result
     * @param builder
     * @return ResponseEntity<SubtitleDTO>
     * @author caizhukui
     * @date 2017年1月19日
     */
    @RequestMapping(value = "/subtitles", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SubtitleDTO> add(@Valid @RequestBody SubtitleDTO subtitleDTO, BindingResult result,
            UriComponentsBuilder builder) {
        logger.debug("新增{} - subtitleDTO = {}", getName(), subtitleDTO);
        Assert.isFalse(result.hasErrors(), RestError.PARAMETER_ERROR, convert(result.getFieldErrors()));
        // 向DTO中填充字幕ID和字幕文件ID
        subtitleDTO.setUuidIfEmpty();
        List<SubtitleFileDTO> subtitleFileDTOs = subtitleDTO.getSubtitleFiles();
        for (SubtitleFileDTO subtitleFileDTO : subtitleFileDTOs) {
            subtitleFileDTO.setUuidIfEmpty();
            subtitleFileDTO.setSubtitleUuid(subtitleDTO.getUuid());
        }
        serviceFacade.getSubtitleService().add(subtitleConvert.dto2Model(subtitleDTO));
        HttpHeaders headers = new HttpHeaders();
        URI locationUri = builder.path("/subtitles/{uuid}").buildAndExpand(subtitleDTO.getUuid()).toUri();
        headers.setLocation(locationUri);
        return new ResponseEntity<>(subtitleDTO, headers, HttpStatus.CREATED);
    }

    /**
     * 根据UUID删除字幕
     * 
     * @param uuid 字幕UUID
     * @return BooleanDTO 
     * @author caizhukui
     * @date 2018年7月4日
     */
    @RequestMapping(value = "/subtitles/{uuid}", method = DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BooleanDTO delete(@PathVariable String uuid) {
        logger.debug("根据UUID删除{} - uuid = {}", getName(), uuid);
        Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
        serviceFacade.getSubtitleService().deleteByUuid(uuid);
        return new BooleanDTO(true);
    }
    
    /**
     * 根据UUID更新字幕
     * 
     * @param subtitleDTO 字幕信息
     * @param result
     * @return BooleanDTO
     * @author caizhukui
     * @date 2017年3月8日
     */
    @RequestMapping(value = "/subtitles", method = PUT, consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BooleanDTO update(@Valid @RequestBody SubtitleDTO subtitleDTO, BindingResult result) {
        logger.debug("根据UUID更新{} - subtitleDTO = {}", getName(), subtitleDTO);
        Assert.isFalse(result.hasErrors(), RestError.PARAMETER_ERROR, convert(result.getFieldErrors()));
        Assert.notNull(subtitleDTO.getUuid(), RestError.PARAMETER_NOT_SATISFIED, getEmptyUuidMessage());
        serviceFacade.getSubtitleService().updateByUuid(subtitleConvert.dto2Model(subtitleDTO));
        return new BooleanDTO(true);
    }

    /**
     * 根据UUID查询字幕基本信息
     * 
     * @param uuid 字幕UUID
     * @return SubtitleDTO 字幕基本信息
     * @author caizhukui
     * @date 2017年4月11日
     */
    @RequestMapping(value = "/subtitles/{uuid}", method = GET)
    public SubtitleDTO getSubtitleByUuid(@PathVariable String uuid) {
        logger.debug("根据UUID查询{}基本信息 - uuid = {}", getName(), uuid);
        Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
        Subtitle subtitle = serviceFacade.getSubtitleService().getByUuid(uuid);
        Assert.notNull(subtitle, RestError.RESOURCE_NOT_FOUND, getNonexistUuidMessage(uuid));
        return subtitleConvert.model2Dto(subtitle);
    }
    
    /**
     * 根据UUID查询字幕关联信息
     * 
     * @param uuid 字幕UUID
     * @return SubtitleInfoDTO 字幕关联信息
     * @author caizhukui
     * @date 2017年6月30日
     */
    @RequestMapping(value = "/subtitleInfos/{uuid}", method = GET)
    public SubtitleInfoDTO getSubtitleInfoByUuid(@PathVariable String uuid) {
        logger.debug("根据UUID查询{}关联信息 - uuid = {}", getName(), uuid);
        Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
        Subtitle subtitle = serviceFacade.getSubtitleService().getByUuid(uuid);
        Assert.notNull(subtitle, RestError.RESOURCE_NOT_FOUND, getNonexistUuidMessage(uuid));
        return subtitleInfoConvert.model2Dto(subtitle);
    }
    
    /**
     * 分页查询字幕基本信息
     * 
     * @param criteriaDTO
     * @return Paginated<SubtitleDTO>
     * @author caizhukui
     * @date 2017年4月21日
     */
    @RequestMapping(value = "/subtitles", method = GET)
    public Paginated<SubtitleDTO> getSubtitlesPaginated(CriteriaDTO criteriaDTO) {
        logger.debug("分页查询{}基本信息 - criteriaDTO = {}", getName(), criteriaDTO);
        Paginated<SubtitleDTO> paginatedDTO = serviceFacade.getSubtitleService().getDataPaginated(criteriaDTO, subtitleConvert);
        Assert.notEmpty(paginatedDTO.getData(), RestError.NO_DATA, NO_DATA);
        return paginatedDTO;
    }
    
	/**
	 * 分页查询字幕关联信息
	 * 
	 * @param criteriaDTO
	 * @return Paginated<SubtitleInfoDTO>
	 * @author caizhukui
	 * @date 2017年1月19日
	 */
	@RequestMapping(value = "/subtitleInfos", method = GET)
	public Paginated<SubtitleInfoDTO> getSubtitleInfosPaginated(CriteriaDTO criteriaDTO) {
		logger.debug("分页查询{}关联信息 - criteriaDTO = {}", getName(), criteriaDTO);
		Paginated<SubtitleInfoDTO> paginatedDTO = serviceFacade.getSubtitleService().getDataPaginated(criteriaDTO, subtitleInfoConvert);
        Assert.notEmpty(paginatedDTO.getData(), RestError.NO_DATA, NO_DATA);
    	return paginatedDTO;
	}
	
	/**
	 * 查询最近一周（当前日期的前7天）内下载次数最多的字幕
	 * 
	 * @return List<SubtitleDTO>
	 * @author caizhukui
	 * @date 2017年10月14日
	 */
	@RequestMapping(value = "/subtitles/mostDownloadedOfLastWeek", method = GET)
	public List<SubtitleDTO> getMostDownloadedSubtitlesOfLastWeek() {
		List<Subtitle> subtitles = serviceFacade.getSubtitleService().getMostDownloadedSubtitlesOfLastWeek();
		return subtitleConvert.model2Dto(subtitles);
	}
	
	/**
	 * 分页查询某一用户关注的剧集的所有字幕
	 * 
	 * @param userId 用户ID
	 * @param pageSize 每页记录数
	 * @param pageIndex 第几页
	 * @return SubtitlePaginatedDTO
	 * @author caizhukui
	 * @date 2017年6月13日
	 */
	@RequestMapping(value = "/users/{userId}/follow/subtitles", method = GET)
	public SubtitlePaginatedDTO getUserFollowSubtitles(@PathVariable String userId, 
			@RequestParam(required = false) String pageSize, @RequestParam(required = false) String pageIndex) {
		logger.debug("getUserFollowSubtitles - userId = {}, pageSize = {}, pageIndex = {}", userId, pageSize, pageIndex);
		// 校验用户ID
		if (UuidUtils.isInvalidUuid(userId)) {
			String developerMessage = "用户ID '" + userId + "' 无效";
			logger.info(developerMessage);
			throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetail(developerMessage));
		}
		// 校验分页参数
		int pageSizeInt = 20, pageIndexInt = 1;
		try {
			pageSizeInt = Integer.valueOf(pageSize);
			pageIndexInt = Integer.valueOf(pageIndex);
		} catch (NumberFormatException ignore) {
			logger.info("转换分页参数出错，使用默认的分页参数 - pageSize = {}, pageIndex = {}", pageSizeInt, pageIndexInt);
		}
		List<Subtitle> subtitles = serviceFacade.getSubtitleService().getUserFollowSubtitlesPaginated(userId, pageSizeInt, pageIndexInt);
		SubtitlePaginatedDTO subtitlePaginationDTO = new SubtitlePaginatedDTO();
		subtitlePaginationDTO.setSubtitles(subtitleConvert.model2Dto(subtitles));
    	return subtitlePaginationDTO;
	}
	
	/**
	 * 查询字幕下载量的全国地域分布数据
	 * 
	 * @return List<Map<String, Object>>
	 * @author caizhukui
	 * @date 2017年7月18日
	 */
	@RequestMapping(value = "/subtitles/download/geodata", method = GET)
	public List<Map<String, Object>> getSubtitleDownloadGeoData() {
		List<Map<String, Object>> subtitleDownloadGeoData = serviceFacade.getSubtitleDownloadService().getGeoData();
		return subtitleDownloadGeoData;
	}

    @Override
    protected String getName() {
        return "字幕";
    }
	
}
