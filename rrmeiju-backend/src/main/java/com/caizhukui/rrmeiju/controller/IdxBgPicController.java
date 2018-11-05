package com.caizhukui.rrmeiju.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caizhukui.rrmeiju.dto.IdxBgPicDTO;
import com.caizhukui.rrmeiju.model.IdxBgPic;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月14日
 */
@RestController
@RequestMapping(value = "v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class IdxBgPicController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(IdxBgPicController.class);
	
	/**
	 * 随机获取首页的背景图片，能保证连续两次获取到的图片不一样
	 * 
	 * @param currentFileId 当前文件ID
	 * @return IdxBgPicDTO
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	@RequestMapping(value = "/idx-bg-pics", method = RequestMethod.GET)
	public IdxBgPicDTO getByRandom(@RequestParam(required = false) String currentFileId) {
		IdxBgPic idxBgPic = serviceFacade.getIdxBgPicService().getByRandom(currentFileId);
		return convertIdxBgPic(idxBgPic);
	}
	
	/**
	 * 把IdxBgPic从Model转换成DTO
	 * 
	 * @param idxBgPic
	 * @return IdxBgPicDTO
	 * @author caizhukui
	 * @date 2017年4月12日
	 */
	private IdxBgPicDTO convertIdxBgPic(IdxBgPic idxBgPic) {
		IdxBgPicDTO idxBgPicDTO = new IdxBgPicDTO();
		idxBgPicDTO.setFileId(idxBgPic.getUuid());
		idxBgPicDTO.setFileUrl(idxBgPic.getFileUrl());
		return idxBgPicDTO;
	}
	
	/**
	 * 把IdxBgPic从DTO转换成Model
	 * 
	 * @param idxBgPicDTO
	 * @return IdxBgPic
	 * @author caizhukui
	 * @date 2017年4月12日
	 */
	private IdxBgPic convertIdxBgPic(IdxBgPicDTO idxBgPicDTO) {
		IdxBgPic idxBgPic = new IdxBgPic();
		idxBgPic.setUuid(idxBgPicDTO.getFileId());
		idxBgPic.setFileUrl(idxBgPicDTO.getFileUrl());
		return idxBgPic;
	}

    @Override
    protected String getName() {
        return null;
    }

}
