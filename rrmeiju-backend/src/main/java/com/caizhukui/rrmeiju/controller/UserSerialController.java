package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.caizhukui.rrmeiju.dto.UserSerialDTO;
import com.caizhukui.rrmeiju.dto.response.BooleanDTO;
import com.caizhukui.rrmeiju.dto.response.FieldsDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;

/**
 * 用户美剧系列关联控制器类
 * 
 * @author caizhukui
 * @date 2018年5月25日
 */
@RestController
@RequestMapping(value = "/v1/userSerials", produces = { APPLICATION_JSON_UTF8_VALUE, APPLICATION_XML_VALUE })
public class UserSerialController extends BaseController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserSerialController.class);
    
    /**
     * 返回用户美剧系列关联的所有可查询字段名
     * 
     * @return FieldsDTO 所有字段名
     * @author caizhukui
     * @date 2017年1月23日
     */
    @RequestMapping(method = OPTIONS)
    public FieldsDTO getFields() {
        List<String> fields = serviceFacade.getMetaDataService().getFieldsOfTable(TableEnum.USER_SERIAL);
        return new FieldsDTO(fields);
    }

    /**
     * 查询用户是否关注了美剧系列
     * 
     * @param userSerialDTO
     * @return BooleanDTO 查询结果
     * @author caizhukui
     * @date 2017年1月26日
     */
    @RequestMapping(method = GET)
    public BooleanDTO exists(@RequestParam UserSerialDTO userSerialDTO) {
        logger.debug("根据用户UUID和美剧系列UUID查询{} - userSerialDTO = {}", getName(), userSerialDTO);
        boolean exists = serviceFacade.getUserSerialService().existsByUserUuidAndSerialUuid(userSerialConvert.dto2Model(userSerialDTO));
        return new BooleanDTO(exists);
    }

    /**
     * 用户关注美剧系列
     * 
     * @param userSerialDTO
     * @param builder
     * @return ResponseEntity<UserSerialDTO>
     * @author caizhukui
     * @date 2017年1月26日
     */
    @RequestMapping(method = POST)
    public ResponseEntity<UserSerialDTO> add(@RequestParam UserSerialDTO userSerialDTO, UriComponentsBuilder builder) {
        logger.debug("新增{} - userSerialDTO = {}", getName(), userSerialDTO);
        userSerialDTO.setUuidIfEmpty();
        serviceFacade.getUserSerialService().add(userSerialConvert.dto2Model(userSerialDTO));
        HttpHeaders headers = new HttpHeaders();
        URI locationUri = builder.path("/userserials/{uuid}").buildAndExpand(userSerialDTO.getUuid()).toUri();
        headers.setLocation(locationUri);
        return new ResponseEntity<>(userSerialDTO, headers, HttpStatus.CREATED);
    }
    
    /**
     * 用户取消关注美剧系列
     * 
     * @param userSerialDTO
     * @return BooleanDTO
     * @author caizhukui
     * @date 2017年4月22日
     */
    @RequestMapping(method = DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BooleanDTO delete(@RequestParam UserSerialDTO userSerialDTO) {
        logger.debug("根据用户UUID和美剧系列UUID删除{} - userSerialDTO = {}", getName(), userSerialDTO);
        serviceFacade.getUserSerialService().deleteByUserUuidAndSerialUuid(userSerialConvert.dto2Model(userSerialDTO));
        return new BooleanDTO(true);
    }
    
    @Override
    protected String getName() {
        return "用户美剧系列关联";
    }

}
