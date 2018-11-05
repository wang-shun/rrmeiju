package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.caizhukui.common.util.DateUtils;
import com.caizhukui.core.consts.CloudStorageConstant;
import com.caizhukui.rrmeiju.controller.util.Assert;
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.EpisodeDTO;
import com.caizhukui.rrmeiju.dto.response.BooleanDTO;
import com.caizhukui.rrmeiju.dto.response.FieldsDTO;
import com.caizhukui.rrmeiju.dto.response.Paginated;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.episode.EpisodeInfoDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.Episode;

/**
 * 美剧集控制器类
 * 
 * @author caizhukui
 * @date 2016年10月20日
 */
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_UTF8_VALUE)
@ManagedResource(objectName = "rrmeiju:name=EpisodeController")
public class EpisodeController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(EpisodeController.class);

    /**
     * 返回美剧集的所有可查询字段名
     * 
     * @return FieldsDTO 所有字段名
     * @author caizhukui
     * @date 2017年1月23日
     */
    @RequestMapping(value = "/episodes", method = OPTIONS)
    public FieldsDTO getFields() {
        List<String> fields = serviceFacade.getMetaDataService().getFieldsOfTable(TableEnum.EPISODE);
        return new FieldsDTO(fields);
    }

    /**
     * 查询当天播出的剧集（总数不会很多，不考虑分页）
     * 
     * @return List<EpisodeDTO>
     * @author caizhukui
     * @date 2017年6月7日
     */
    @RequestMapping(value = "/episodes/today", method = GET)
    public List<EpisodeInfoDTO> getTodayAirEpisodes() {
        Date date = new Date();
        List<Episode> episodes = serviceFacade.getEpisodeService().getByAirDate(date);
        return episodeInfoConvert.model2Dto(episodes);
    }

    /**
     * 查询昨天播出的剧集（总数不会很多，不考虑分页）
     * 
     * @return List<EpisodeInfoDTO>
     * @author caizhukui
     * @date 2017年6月15日
     */
    @RequestMapping(value = "/episodes/yesterday", method = GET)
    public List<EpisodeInfoDTO> getYesterdayAirEpisodes() {
        Date date = DateUtils.getYesterdayDate();
        List<Episode> episodes = serviceFacade.getEpisodeService().getByAirDate(date);
        return episodeInfoConvert.model2Dto(episodes);
    }

    /**
     * 查询明天播出的剧集（总数不会很多，不考虑分页）
     * 
     * @return List<EpisodeInfoDTO>
     * @author caizhukui
     * @date 2017年6月15日
     */
    @RequestMapping(value = "/episodes/tomorrow", method = GET)
    public List<EpisodeInfoDTO> getTomorrowAirEpisodes() {
        Date date = DateUtils.getTomorrowDate();
        List<Episode> episodes = serviceFacade.getEpisodeService().getByAirDate(date);
        return episodeInfoConvert.model2Dto(episodes);
    }

    /**
     * 查询指定日期播出的剧集（总数不会很多，不考虑分页）
     * 
     * @param airDateStr 日期
     * @return List<EpisodeInfoDTO>
     * @author caizhukui
     * @date 2017年6月15日
     */
    @RequestMapping(value = "/episodes/search/{airDateStr}", method = GET)
    public List<EpisodeInfoDTO> getByAirDate(String airDateStr) {
        Date date = null;
        try {
            date = new SimpleDateFormat(CloudStorageConstant.DATE_FORMAT).parse(airDateStr);
        } catch (ParseException ignore) {
            String developerMessage = "转换日期格式错误";
            logger.error(developerMessage + " - {}", ignore.getMessage());
            throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetail(developerMessage));
        }
        List<Episode> episodes = serviceFacade.getEpisodeService().getByAirDate(date);
        return episodeInfoConvert.model2Dto(episodes);
    }

    /**
     * 分页查询美剧集基本信息
     * 
     * @param criteriaDTO
     * @return Paginated<EpisodeDTO> 
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/episodes", method = GET)
    public Paginated<EpisodeDTO> get(CriteriaDTO criteriaDTO) {
        logger.info("分页查询{}基本信息 - criteriaDTO = {}", getName(), criteriaDTO);
        Paginated<EpisodeDTO> paginatedDTO = serviceFacade.getEpisodeService().getDataPaginated(criteriaDTO, episodeConvert);
        Assert.notEmpty(paginatedDTO.getData(), RestError.NO_DATA, NO_DATA);
        return paginatedDTO;
    }

    /**
     * 根据UUID查询美剧集基本信息
     * 
     * @param uuid 美剧集UUID
     * @return EpisodeDTO 美剧集基本信息
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/episodes/{episodeId}", method = GET)
    public EpisodeDTO getByEpisodeId(@PathVariable String uuid) {
        logger.info("根据UUID查询{}基本信息 - episodeId = {}", getName(), uuid);
        Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
        Episode episode = serviceFacade.getEpisodeService().getByUuid(uuid);
        Assert.notNull(episode, RestError.RESOURCE_NOT_FOUND, getNonexistUuidMessage(uuid));
        return episodeConvert.model2Dto(episode);
    }

    /**
     * 根据美剧季UUID分页查询美剧集基本信息
     * 
     * @param seasonUuid 美剧季UUID
     * @return Paginated<EpisodeDTO>
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/seasons/{seasonUuid}/episodes", method = GET)
    public Paginated<EpisodeDTO> getBySeasonId(@PathVariable String seasonUuid, CriteriaDTO criteriaDTO) {
        logger.info("根据美剧季UUID分页查询{}基本信息 - seasonUuid = {}, criteriaDTO = {}", getName(), seasonUuid, criteriaDTO);
        String filter = criteriaDTO.getFilter();
        if (filter == null) {
            filter = "";
        }
        filter += ",seasonUuid";
        criteriaDTO.setFilter(filter);
        String keyword = criteriaDTO.getKeyword();
        if (keyword == null) {
            keyword = "";
        }
        keyword = keyword + "," + seasonUuid;
        criteriaDTO.setKeyword(keyword);
        Paginated<EpisodeDTO> paginatedDTO = serviceFacade.getEpisodeService().getDataPaginated(criteriaDTO, episodeConvert);
        Assert.notEmpty(paginatedDTO.getData(), RestError.NO_DATA, NO_DATA);
        return paginatedDTO;
    }

    /**
     * 新增美剧集
     * 
     * @param episodeDTO
     * @param result
     * @param builder
     * @return ResponseEntity<EpisodeDTO>
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/episodes", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<EpisodeDTO> add(@Valid @RequestBody EpisodeDTO episodeDTO, BindingResult result,
            UriComponentsBuilder builder) {
        logger.info("新增{} - episodeDTO = {}", getName(), episodeDTO);
        Assert.isFalse(result.hasErrors(), RestError.PARAMETER_ERROR, convert(result.getFieldErrors()));
        episodeDTO.setUuidIfEmpty();
        serviceFacade.getEpisodeService().add(episodeConvert.dto2Model(episodeDTO));
        HttpHeaders headers = new HttpHeaders();
        URI locationUri = builder.path("/episodes/{uuid}").buildAndExpand(episodeDTO.getUuid()).toUri();
        headers.setLocation(locationUri);
        return new ResponseEntity<>(episodeDTO, headers, HttpStatus.CREATED);
    }

    /**
     * 根据UUID更新美剧集
     * 
     * @param episodeDTO
     * @param result
     * @return BooleanDTO
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/episodes", method = PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BooleanDTO update(@Valid @RequestBody EpisodeDTO episodeDTO, BindingResult result) {
        logger.info("根据UUID更新{}基本信息 - episodeDTO = {}", getName(), episodeDTO);
        Assert.isFalse(result.hasErrors(), RestError.PARAMETER_ERROR, convert(result.getFieldErrors()));
        Assert.notNull(episodeDTO.getUuid(), RestError.PARAMETER_NOT_SATISFIED, getEmptyUuidMessage());
        serviceFacade.getEpisodeService().updateByUuid(episodeConvert.dto2Model(episodeDTO));
        return new BooleanDTO(true);
    }

    /**
     * 根据UUID删除美剧集
     * 
     * @param uuid 美剧集UUID
     * @return BooleanDTO
     * @author caizhukui
     * @date 2016年9月28日
     */
    @RequestMapping(value = "/episodes/{episodeId}", method = DELETE)
    public BooleanDTO deleteByUuid(@PathVariable String uuid) {
        logger.info("根据UUID删除{} - uuid = {}", uuid);
        Assert.isUuid(uuid, RestError.PARAMETER_ERROR, getInvalidUuidMessage(uuid));
        serviceFacade.getEpisodeService().deleteByUuid(uuid);
        return new BooleanDTO(true);
    }

    @Override
    protected String getName() {
        return "美剧集";
    }

}
