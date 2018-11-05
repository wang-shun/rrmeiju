package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.Collections;
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
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.FansubDTO;
import com.caizhukui.rrmeiju.dto.response.Pagination;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.fansub.FansubInfoDTO;
import com.caizhukui.rrmeiju.dto.response.fansub.FansubInfoPaginatedDTO;
import com.caizhukui.rrmeiju.dto.response.fansub.FansubPaginatedDTO;
import com.caizhukui.rrmeiju.dto.response.fansub.FansubStatDTO;
import com.caizhukui.rrmeiju.dto.response.fansub.FansubStatPaginatedDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.Fansub;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.User;

/**
 * 字幕组控制器类
 * 
 * @author caizhukui
 * @date 2017年1月25日
 */
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_UTF8_VALUE)
public class FansubController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(FansubController.class);
	
	/**
	 * 查询Fansub所有字段
	 * 
	 * @return List<String>
	 * @author caizhukui
	 * @date 2017年1月25日
	 */
	@RequestMapping(value = "/fansubs", method = OPTIONS)
	public List<String> getFields() {
		return serviceFacade.getMetaDataService().getFieldsOfTable(TableEnum.FANSUB);
	}
	
	/**
	 * 分页查询FansubStat
	 * 
	 * @param criteriaDTO
	 * @return FansubStatPaginatedDTO
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	@RequestMapping(value = "/fansubs/stat", method = GET)
	public FansubStatPaginatedDTO getFansubStats(CriteriaDTO criteriaDTO) {
		logger.info("getFansubStats - criteriaDTO = {}", criteriaDTO);
		checkCriteria(criteriaDTO, TableEnum.FANSUB);
		CriteriaBO criteriaBO = convertCriteria(criteriaDTO, TableEnum.FANSUB);
		List<Fansub> fansubs = serviceFacade.getFansubService().get(criteriaBO);
		FansubStatPaginatedDTO fansubStatPaginatedDTO = new FansubStatPaginatedDTO();
		List<FansubStatDTO> fansubStatDTOs = convertFansubStat(fansubs);
		// 根据上传字幕数倒序排序
		Collections.sort(fansubStatDTOs);
		fansubStatPaginatedDTO.setFansubStats(fansubStatDTOs);
		int fansubCount = serviceFacade.getFansubService().getCount(criteriaBO);
    	Pagination pagination = new Pagination(fansubCount, criteriaDTO.getPageSize(), criteriaDTO.getPageIndex());
    	fansubStatPaginatedDTO.setPagination(pagination);
		return fansubStatPaginatedDTO;
	}
	
	/**
	 * 分页查询FansubInfo
	 * 
	 * @param criteriaDTO
	 * @return FansubInfoPaginatedDTO
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	@RequestMapping(value = "/fansubs/info", method = GET)
	public FansubInfoPaginatedDTO getFansubInfos(CriteriaDTO criteriaDTO) {
		logger.info("getFansubInfos - criteriaDTO = {}", criteriaDTO);
		checkCriteria(criteriaDTO, TableEnum.FANSUB);
		CriteriaBO criteriaBO = convertCriteria(criteriaDTO, TableEnum.FANSUB);
		List<Fansub> fansubs = serviceFacade.getFansubService().get(criteriaBO);
		FansubInfoPaginatedDTO fansubInfoPaginatedDTO = new FansubInfoPaginatedDTO();
		fansubInfoPaginatedDTO.setFansubInfos(convertFansubInfo(fansubs, 5));
		int fansubCount = serviceFacade.getFansubService().getCount(criteriaBO);
    	Pagination pagination = new Pagination(fansubCount, criteriaDTO.getPageSize(), criteriaDTO.getPageIndex());
    	fansubInfoPaginatedDTO.setPagination(pagination);
		return fansubInfoPaginatedDTO;
	}
	
	/**
	 * 分页查询字幕组
	 * 
	 * @param criteriaDTO
	 * @return FansubPaginatedDTO
	 * @author caizhukui
	 * @date 2017年1月25日
	 */
	@RequestMapping(value = "/fansubs", method = GET)
	public FansubPaginatedDTO getFansubs(CriteriaDTO criteriaDTO) {
		logger.info("getFansubs - criteriaDTO = {}", criteriaDTO);
		checkCriteria(criteriaDTO, TableEnum.FANSUB);
		CriteriaBO criteriaBO = convertCriteria(criteriaDTO, TableEnum.FANSUB);
    	List<Fansub> fansubs = serviceFacade.getFansubService().get(criteriaBO);
    	FansubPaginatedDTO fansubPaginationDTO = new FansubPaginatedDTO();
    	fansubPaginationDTO.setFansubs(convertFansub(fansubs));
    	int fansubCount = serviceFacade.getFansubService().getCount(criteriaBO);
    	Pagination pagination = new Pagination(fansubCount, criteriaDTO.getPageSize(), criteriaDTO.getPageIndex());
    	fansubPaginationDTO.setPagination(pagination);
    	return fansubPaginationDTO;
	}
	
	/**
	 * 根据fansubId查询Fansub
	 * 
	 * @param fansubId 字幕组ID
	 * @return FansubDTO
	 * @author caizhukui
	 * @date 2017年4月8日
	 */
	@RequestMapping(value = "/fansubs/{fansubId}", method = GET)
    public FansubDTO getByFansubId(@PathVariable String fansubId) {
		logger.info("getByFansubId - fansubId = {}", fansubId);
		Fansub fansub = serviceFacade.getFansubService().getByUuid(fansubId);
    	if (fansub == null) {
    		String developerMessage = "Unable to find fansub with id '" + fansubId + "'";
    		throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setDetail(developerMessage));
    	}
    	return convertFansub(fansub);
    }
	
	/**
	 * 根据fansubId查询FansubInfo
	 * 
	 * @param fansubId 字幕组ID
	 * @return FansubInfoDTO
	 * @author caizhukui
	 * @date 2017年5月8日
	 */
	@RequestMapping(value = "/fansubs/{fansubId}/info", method = GET)
	public FansubInfoDTO getFansubInfoByFansubId(@PathVariable String fansubId) {
		logger.info("getFansubInfoByFansubId - fansubId = {}", fansubId);
		Fansub fansub = serviceFacade.getFansubService().getByUuid(fansubId);
    	if (fansub == null) {
    		String developerMessage = "Unable to find fansub with id '" + fansubId + "'";
    		throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setDetail(developerMessage));
    	}
    	return convertFansubInfo(fansub, 16);
	}
	
	/**
	 * 查询上传了某一季字幕的所有字幕组（数据量不会太多，不考虑分页）
	 * 
	 * @param seasonId 季ID
	 * @return List<FansubDTO>
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	@RequestMapping(value = "/seasons/{seasonId}/fansubs", method = GET)
	public List<FansubDTO> getBySeasonId(@PathVariable String seasonId) {
		logger.info("getBySeasonId - seasonId = {}", seasonId);
		List<Fansub> fansubs = serviceFacade.getFansubService().getBySeasonUuid(seasonId);
		return convertFansub(fansubs);
	}

	/**
	 * 根据用户ID查询用户所属字幕组信息（数据量不会太多，不考虑分页）
	 * 
	 * @param userId 用户ID
	 * @return List<FansubDTO> 用户所属字幕组信息
	 * @author caizhukui
	 * @date 2017年6月12日
	 */
	@RequestMapping(value = "/users/{userId}/fansubs", method = GET)
	public List<FansubDTO> getByUserId(@PathVariable String userId) {
		logger.info("getByUserId - userId = {}", userId);
		List<Fansub> fansubs = serviceFacade.getFansubService().getByUserUuid(userId);
		return convertFansub(fansubs);
	}
	
	/**
	 * 新增Fansub
	 * 
	 * @param fansubDTO
	 * @param result
	 * @return FansubDTO
	 * @author caizhukui
	 * @date 2017年1月25日
	 */
	@RequestMapping(value = "/fansubs", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
	public FansubDTO add(@Valid @RequestBody FansubDTO fansubDTO, BindingResult result) {
		logger.info("add - fansubDTO = {}", fansubDTO);
		if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetails(convert(errors)));
		}
		String fansubUuid = UuidUtils.getUuid();
		fansubDTO.setUuid(fansubUuid);
		// 异步新增
		serviceFacade.getFansubService().add(convertFansub(fansubDTO));
		return fansubDTO;
	}
	
	/**
	 * 
	 * 
	 * @param fansub
	 * @return FansubStatDTO
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	private FansubStatDTO convertFansubStat(Fansub fansub) {
		FansubStatDTO fansubStatDTO = new FansubStatDTO();
		String fansubUuid = fansub.getUuid();
		fansubStatDTO.setUuid(fansubUuid);
		fansubStatDTO.setFansubName(fansub.getFansubName());
		fansubStatDTO.setFoundationYear(fansub.getFoundationYear());
		fansubStatDTO.setHomepageUrl(fansub.getHomepageUrl());
		fansubStatDTO.setWeiboUrl(fansub.getWeiboUrl());
		int subtitleCount = serviceFacade.getSubtitleService().getCountByFansubUuid(fansubUuid);
		fansubStatDTO.setSubtitleCount(subtitleCount);
		return fansubStatDTO;
	}
	
	/**
	 * 
	 * 
	 * @param fansubs
	 * @return List<FansubStatDto>
	 * @author caizhukui
	 * @date 2017年5月4日下午3:56:41
	 */
	private List<FansubStatDTO> convertFansubStat(List<Fansub> fansubs) {
		List<FansubStatDTO> fansubStats = new ArrayList<FansubStatDTO>();
		for (Fansub fansub : fansubs) {
			fansubStats.add(convertFansubStat(fansub));
		}
		return fansubStats;
	}
	
	/**
	 * 
	 * 
	 * @param fansub
	 * @param limit
	 * @return FansubInfoDto
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	private FansubInfoDTO convertFansubInfo(Fansub fansub, int limit) {
		FansubInfoDTO fansubInfoDTO = new FansubInfoDTO();
		String fansubUuid = fansub.getUuid();
		fansubInfoDTO.setUuid(fansubUuid);
		fansubInfoDTO.setFansubName(fansub.getFansubName());
		fansubInfoDTO.setFoundationYear(fansub.getFoundationYear());
		fansubInfoDTO.setHomepageUrl(fansub.getHomepageUrl());
		fansubInfoDTO.setWeiboUrl(fansub.getWeiboUrl());
		List<Season> seasons = serviceFacade.getSeasonService().getByFansubUuid(fansubUuid, limit);
		fansubInfoDTO.setSeasons(convertSeason(seasons));
		List<User> users = serviceFacade.getUserService().getByFansubUuid(fansubUuid);
		fansubInfoDTO.setUserStats(convertUserStat(users));
		return fansubInfoDTO;
	}
	
	/**
	 * 
	 * 
	 * @param fansubs
	 * @param limit
	 * @return List<FansubInfoDTO>
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	private List<FansubInfoDTO> convertFansubInfo(List<Fansub> fansubs, int limit) {
		List<FansubInfoDTO> fansubInfos = new ArrayList<FansubInfoDTO>();
		for (Fansub fansub : fansubs) {
			fansubInfos.add(convertFansubInfo(fansub, limit));
		}
		return fansubInfos;
	}

    @Override
    protected String getName() {
        return "字幕组";
    }
	
}
