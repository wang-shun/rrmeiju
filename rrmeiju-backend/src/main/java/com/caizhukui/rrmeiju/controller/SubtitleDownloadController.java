package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.caizhukui.common.util.CollectionUtils;
import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.bo.IpLocation;
import com.caizhukui.rrmeiju.controller.util.Assert;
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.SubtitleDownloadDTO;
import com.caizhukui.rrmeiju.dto.response.BooleanDTO;
import com.caizhukui.rrmeiju.dto.response.FieldsDTO;
import com.caizhukui.rrmeiju.dto.response.Paginated;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.subtitle.SubtitleDownloadInfoDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.model.Ip;
import com.caizhukui.rrmeiju.model.SubtitleDownload;

/**
 * 字幕下载记录控制器类
 * 
 * @author caizhukui
 * @date 2018年6月11日
 */
@RestController
@RequestMapping(value = "/v1", produces = { APPLICATION_JSON_UTF8_VALUE, APPLICATION_XML_VALUE })
public class SubtitleDownloadController extends BaseController {
    
    private static final Logger logger = LoggerFactory.getLogger(SubtitleDownloadController.class);
    
    /**
     * 返回字幕下载记录的所有可查询字段名
     * 
     * @return FieldsDTO 所有字段名
     * @author caizhukui
     * @date 2018年6月11日
     */
    @RequestMapping(value = "/subtitleDownloads", method = OPTIONS)
    public FieldsDTO getFields() {
        List<String> fields = serviceFacade.getMetaDataService().getFieldsOfTable(TableEnum.SUBTITLE_DOWNLOAD);
        return new FieldsDTO(fields);
    }

    /**
     * 新增字幕下载记录
     * 
     * @param subtitleDownloadDTO 字幕下载记录信息
     * @param result
     * @param builder
     * @return ResponseEntity<SubtitleDownloadDTO>
     * @author caizhukui
     * @date 2017年3月8日
     */
    @RequestMapping(value = "/subtitleDownloads", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SubtitleDownloadDTO> add(@Valid @RequestBody SubtitleDownloadDTO subtitleDownloadDTO,
            BindingResult result, UriComponentsBuilder builder) {
        logger.debug("新增{} - subtitleDownloadDTO = {}", getName(), subtitleDownloadDTO);
        Assert.isFalse(result.hasErrors(), RestError.PARAMETER_ERROR, convert(result.getFieldErrors()));
        subtitleDownloadDTO.setUuidIfEmpty();
        serviceFacade.getSubtitleDownloadService().add(subtitleDownloadConvert.dto2Model(subtitleDownloadDTO));
        HttpHeaders headers = new HttpHeaders();
        URI locationUri = builder.path("/subtitleDownloads/{uuid}").buildAndExpand(subtitleDownloadDTO.getUuid())
                .toUri();
        headers.setLocation(locationUri);
        return new ResponseEntity<>(subtitleDownloadDTO, headers, HttpStatus.CREATED);
    }
    
    /**
     * 分页查询字幕下载记录基本信息
     * 
     * @param criteriaDTO
     * @return Paginated<SubtitleDownloadInfoDTO>
     * @author caizhukui
     * @date 2017年5月22日
     */
    @RequestMapping(value = "/subtitleDownloads", method = GET)
    public Paginated<SubtitleDownloadInfoDTO> getSubtitleDownloadInfosPaginated(CriteriaDTO criteriaDTO) {
        logger.debug("分页查询{}基本信息 - criteriaDTO = {}", getName(), criteriaDTO);
        Paginated<SubtitleDownloadInfoDTO> paginatedDTO = serviceFacade.getSubtitleDownloadService()
                .getDataPaginated(criteriaDTO, subtitleDownloadInfoConvert);
        Assert.notEmpty(paginatedDTO.getData(), RestError.NO_DATA, NO_DATA);
        return paginatedDTO;
    }

    /**
     * 根据字幕UUID查询字幕下载记录，暂时不考虑分页
     * 
     * @param uuid 字幕UUID
     * @return List<SubtitleDownloadInfoDTO>
     * @author caizhukui
     * @date 2017年7月21日
     */
    @RequestMapping(value = "subtitles/{uuid}/subtitleDownloads", method = GET)
    public List<SubtitleDownloadInfoDTO> getSubtitleDownloadBySubtitleId(@PathVariable String uuid) {
        logger.debug("根据字幕UUID查询{} - uuid = {}", uuid);
        List<SubtitleDownload> subtitleDownloads = serviceFacade.getSubtitleDownloadService().getBySubtitleUuid(uuid);
        // 把Model转换成DTO
        List<SubtitleDownloadInfoDTO> subtitleDownloadInfoDTOs = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(subtitleDownloads)) {
            for (SubtitleDownload subtitleDownload : subtitleDownloads) {
                SubtitleDownloadInfoDTO subtitleDownloadInfoDTO = new SubtitleDownloadInfoDTO();
                subtitleDownloadInfoDTO.setSubtitleDownloadId(subtitleDownload.getUuid());
                subtitleDownloadInfoDTO.setDownloadTime(subtitleDownload.getDownloadTime());
                // IP地址信息
                String remoteIp = subtitleDownload.getRemoteIp();
                Ip ip = commonServiceFacade.getIpService().getByIp(remoteIp);
                if (ip == null) {
                    ip = new Ip();
                    ip.setIp(remoteIp);
                }
                subtitleDownloadInfoDTO.setIp(ipConvert.model2Dto(ip));
                subtitleDownloadInfoDTOs.add(subtitleDownloadInfoDTO);
            }
        }
        return subtitleDownloadInfoDTOs;
    }

    @Override
    protected String getName() {
        return "字幕下载记录";
    }

}
