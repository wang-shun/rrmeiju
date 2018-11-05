package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.dto.IndexSearchRecordDTO;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.IndexSearchRecord;

/**
 * 控制器类
 *
 * @author caizhukui
 * @date 2017年3月11日
 */
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_UTF8_VALUE)
public class IndexSearchRecordController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexSearchRecordController.class);
	
	/**
	 * 
	 * @param recordDTO
	 * @param result
	 * @return IndexSearchRecordDTO
	 * @author caizhukui
	 * @date 2017年3月11日
	 */
	@RequestMapping(value = "/records/search/index", method = POST)
	public IndexSearchRecordDTO add(@Valid @RequestBody IndexSearchRecordDTO recordDTO, BindingResult result) {
		logger.info("add index search record - {}", recordDTO);
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();  
            throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetails(convert(errors)));
		}
		String recordId = UuidUtils.getUuid();
		recordDTO.setRecordId(recordId);
		// 异步新增
		serviceFacade.getIndexSearchRecordService().add(convertIndexSearchRecord(recordDTO));
		return recordDTO;
	}
	
	/**
	 * 
	 * @param recordDTO
	 * @return IndexSearchRecord
	 * @author caizhukui
	 * @date 2017年3月11日
	 */
	private IndexSearchRecord convertIndexSearchRecord(IndexSearchRecordDTO recordDTO) {
		IndexSearchRecord record = new IndexSearchRecord();
		record.setUuid(recordDTO.getRecordId());
		record.setUserId(recordDTO.getUserId());
		record.setRemoteIp(recordDTO.getRemoteIp());
		record.setKeyword(recordDTO.getKeyword());
		return record;
	}

    @Override
    protected String getName() {
        // TODO Auto-generated method stub
        return null;
    }

}
