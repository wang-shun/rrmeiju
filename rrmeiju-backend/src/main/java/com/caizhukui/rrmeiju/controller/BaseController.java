package com.caizhukui.rrmeiju.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.caizhukui.common.util.CollectionUtils;
import com.caizhukui.rrmeiju.convert.InfoConvert;
import com.caizhukui.rrmeiju.dto.EpisodeDTO;
import com.caizhukui.rrmeiju.dto.FansubDTO;
import com.caizhukui.rrmeiju.dto.IpDTO;
import com.caizhukui.rrmeiju.dto.SubtitleDTO;
import com.caizhukui.rrmeiju.dto.UserDTO;
import com.caizhukui.rrmeiju.dto.VideoDTO;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.user.UserStatDTO;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Fansub;
import com.caizhukui.rrmeiju.model.Ip;
import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.User;
import com.caizhukui.rrmeiju.model.Video;
import com.caizhukui.rrmeiju.service.CommonServiceFacade;
import com.caizhukui.rrmeiju.service.ServiceFacade;

/**
 * 基础控制器类
 * 
 * @author caizhukui
 * @date 2016年10月19日
 */
public abstract class BaseController extends InfoConvert {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	private static final String NAME = "{name}";
	
	private static final String UUID = "{uuid}";
	
	/**  */
	private static final String NONEXIST_UUID = "UUID为{uuid}的{name}不存在";
	
	/**  */
    private static final String EMPTY_UUID = "{name}UUID不能为空";
    
    /**  */
    private static final String INVALID_UUID = "{uuid}是无效的UUID";
    
    /**  */
    protected static final String NO_DATA = "无数据";
	
	@Autowired
	protected ServiceFacade serviceFacade;
	
	/** 基础服务（短信服务、邮件服务等）门面类 */
	@Autowired
	protected CommonServiceFacade commonServiceFacade;
	
    /**
     * 统一处理异常
     * 
     * @param e
     * @return ResponseEntity<RestError>
     * @author caizhukui
     * @date 2016年11月16日
     */
    @ExceptionHandler(RestControllerException.class)
    public ResponseEntity<RestError> cloudStorageError(RestControllerException e) {
        RestError restError = e.getRestError();
        return new ResponseEntity<>(restError, restError.getHttpStatus());
    }

	/**
	 * 
	 * 
	 * @param user
	 * @return UserStatDTO
	 * @author caizhukui
	 * @date 2017年5月8日
	 */
	protected UserStatDTO convertUserStat(User user) {
		UserStatDTO userStatDTO = new UserStatDTO();
		String userUuid = user.getUuid();
		userStatDTO.setUuid(userUuid);
		userStatDTO.setNickname(user.getNickname());
		int subtitleCount = serviceFacade.getSubtitleService().getCountByUserUuid(userUuid);
		userStatDTO.setSubtitleCount(subtitleCount);
		return userStatDTO;
	}
	
	/**
	 * 
	 * 
	 * @param errors
	 * @return List<String>
	 * @author caizhukui
	 * @date 2016年10月11日
	 */
	protected List<String> convert(List<FieldError> errors) {
		List<String> errorMessages = new ArrayList<>(errors.size());
		errors.forEach(error -> errorMessages.add(error.getDefaultMessage()));
		return errorMessages;
	}

    /**
     * 
     * 
     * @return String
     * @author caizhukui
     * @date 2018年5月23日
     */
    protected String getNonexistUuidMessage(String uuid) {
        return NONEXIST_UUID.replace(UUID, uuid).replace(NAME, getName());
    }
    
    /**
     * 
     * 
     * @return String
     * @author caizhukui
     * @date 2018年5月23日
     */
    protected String getEmptyUuidMessage() {
        return EMPTY_UUID.replace(NAME, getName());
    }
    
    /**
     * 
     * 
     * @param uuid
     * @return String
     * @author caizhukui
     * @date 2018年5月25日
     */
    protected String getInvalidUuidMessage(String uuid) {
        return INVALID_UUID.replace(UUID, uuid);
    }

	/**
	 * 
	 * 
	 * @return String
	 * @author caizhukui
	 * @date 2018年5月23日
	 */
	protected abstract String getName();
	
}
