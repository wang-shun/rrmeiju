package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.bo.CriteriaBO;
import com.caizhukui.rrmeiju.dto.CriteriaDTO;
import com.caizhukui.rrmeiju.dto.FansubDTO;
import com.caizhukui.rrmeiju.dto.SeasonDTO;
import com.caizhukui.rrmeiju.dto.UserDTO;
import com.caizhukui.rrmeiju.dto.VideoDTO;
import com.caizhukui.rrmeiju.dto.response.Pagination;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.dto.response.video.VideoInfoDTO;
import com.caizhukui.rrmeiju.dto.response.video.VideoInfoPaginatedDTO;
import com.caizhukui.rrmeiju.dto.response.video.VideoPaginatedDTO;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.model.Fansub;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.model.User;
import com.caizhukui.rrmeiju.model.Video;

/**
 * 视频控制器类
 * 
 * @author caizhukui
 * @date 2017年7月8日
 */
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_UTF8_VALUE)
public class VideoController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);
	
	/**
	 * 查询视频表的所有字段
	 * 
	 * @return List<String> 所有字段名
	 * @author caizhukui
	 * @date 2017年8月2日
	 */
	@RequestMapping(value = "/videos", method = OPTIONS)
	public List<String> getFields() {
		return serviceFacade.getMetaDataService().getFieldsOfTable(TableEnum.VIDEO);
	}
	
	/**
	 * 分页查询视频扩展信息（单表查询都使用这个方法）
	 * 
	 * @param criteriaDto
	 * @return VideoInfoPaginatedDto
	 * @author caizhukui
	 * @date 2017年9月2日
	 */
	@RequestMapping(value = "/videoInfos", method = GET)
	public VideoInfoPaginatedDTO getVideoInfos(CriteriaDTO criteriaDto) {
		logger.info("getVideoInfos - criteriaDto = {}", criteriaDto);
		checkCriteria(criteriaDto, TableEnum.VIDEO);
		CriteriaBO criteriaBo = convertCriteria(criteriaDto, TableEnum.VIDEO);
    	List<Video> videos = serviceFacade.getVideoService().get(criteriaBo);
    	VideoInfoPaginatedDTO videoInfoPaginationDto = new VideoInfoPaginatedDTO();
    	videoInfoPaginationDto.setVideoInfos(convertVideoInfo(videos));
    	int videoCount = serviceFacade.getVideoService().getCount(criteriaBo);
    	Pagination pagination = new Pagination(videoCount, criteriaDto.getPageSize(), criteriaDto.getPageIndex());
    	videoInfoPaginationDto.setPagination(pagination);
    	return videoInfoPaginationDto;
	}
	
	/**
	 * 分页查询视频信息（单表查询都使用这个方法）
	 * 
	 * @param criteriaDTO
	 * @return VideoPaginatedDto
	 * @author caizhukui
	 * @date 2017年8月2日
	 */
	@RequestMapping(value = "/videos", method = GET)
    public VideoPaginatedDTO get(CriteriaDTO criteriaDTO) {
		logger.info("get - criteriaDTO = {}", criteriaDTO);
		checkCriteria(criteriaDTO, TableEnum.VIDEO);
		CriteriaBO criteriaBO = convertCriteria(criteriaDTO, TableEnum.VIDEO);
    	List<Video> videos = serviceFacade.getVideoService().get(criteriaBO);
    	VideoPaginatedDTO videoPaginatedDTO = new VideoPaginatedDTO();
    	videoPaginatedDTO.setVideos(convertVideo(videos));
    	int videoCount = serviceFacade.getVideoService().getCount(criteriaBO);
    	Pagination pagination = new Pagination(videoCount, criteriaDTO.getPageSize(), criteriaDTO.getPageIndex());
    	videoPaginatedDTO.setPagination(pagination);
    	return videoPaginatedDTO;
    }

	/**
	 * 根据剧名、第几季和第几集查询视频信息
	 * 
	 * @param serialName 中文或英文剧名
	 * @param seasonIndex 第几季
	 * @param episodeIndex 第几集
	 * @return List<VideoDto>
	 * @author caizhukui
	 * @date 2017年8月2日
	 */
	@RequestMapping(value = "/videos", params = {"serialName", "seasonIndex", "episodeIndex"}, method = GET)
	public List<VideoDTO> getBySerialNameAndIndex(@RequestParam String serialName, 
			@RequestParam int seasonIndex, @RequestParam int episodeIndex) {
		try {
			serialName = URLDecoder.decode(serialName, "UTF-8");
		} catch (UnsupportedEncodingException ignore) {}
		logger.info("getBySerialNameAndIndex - serialName = {}, seasonIndex = {}, episodeIndex = {}", 
				serialName, seasonIndex, episodeIndex);
		if (seasonIndex <= 0 || episodeIndex <= 0) {
			String developerMessage = "季或集下标无效";
			logger.info(developerMessage);
			throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetail(developerMessage));
		}
		List<Video> videos = serviceFacade.getVideoService().getBySerialNameAndIndex(serialName, seasonIndex, episodeIndex);
		List<VideoDTO> videoDTOs = convertVideo(videos);
		return videoDTOs;
	}

	/**
	 * 根据集ID查询视频信息
	 * 
	 * @param episodeId 集ID
	 * @return List<VideoDTO>
	 * @author caizhukui
	 * @date 2017年7月8日
	 */
	@RequestMapping(value = "episodes/{episodeId}/videos", method = GET)
	public List<VideoDTO> getByEpisodeId(@PathVariable String episodeId) {
		logger.info("getByEpisodeId - episodeId = {}", episodeId);
		List<Video> videos = serviceFacade.getVideoService().getByEpisodeUuid(episodeId);
		if (CollectionUtils.isEmpty(videos)) {
			String developerMessage = "集ID为" + episodeId + "的视频不存在";
    		throw new RestControllerException(RestError.RESOURCE_NOT_FOUND.setDetail(developerMessage));
		}
		return convertVideo(videos);
	}
	
	/**
	 * 新增视频
	 * 
	 * @param videoDTO 视频文件信息
	 * @param result
	 * @return VideoDTO 视频文件信息
	 * @author caizhukui
	 * @date 2017年8月4日
	 */
	@RequestMapping(value = "/videos", method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
	public VideoDTO add(@Valid @RequestBody VideoDTO videoDTO, BindingResult result) {
		logger.info("add - videoDto = {}", videoDTO);
		if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            throw new RestControllerException(RestError.PARAMETER_NOT_SATISFIED.setDetails(convert(errors)));
		}
		String videoUuid = UuidUtils.getUuid();
		videoDTO.setUuid(videoUuid);
		// 把DTO转换成Model
		Video video = convertVideo(videoDTO);
		// 异步保存到数据库
		serviceFacade.getVideoService().add(video);
		return videoDTO;
	}

	/**
	 * 把Video从Model转换成DTO
	 * 
	 * @param video
	 * @return VideoInfoDTO
	 * @author caizhukui
	 * @date 2017年9月2日
	 */
	private VideoInfoDTO convertVideoInfo(Video video) {
		VideoInfoDTO videoInfoDTO = new VideoInfoDTO();
		videoInfoDTO.setUuid(video.getUuid());
		videoInfoDTO.setVideoTitle(video.getVideoTitle());
		videoInfoDTO.setVideoUrl(video.getVideoUrl());
		videoInfoDTO.setVideoFormat(video.getVideoFormat());
		videoInfoDTO.setVideoSource(video.getVideoSource());
		videoInfoDTO.setViewCount(video.getViewCount());
		videoInfoDTO.setCreateTime(video.getUploadTime());
		videoInfoDTO.setSubtitleLang(video.getSubtitleLang());
		videoInfoDTO.setRemark(video.getRemark());
		// 集信息
		Episode episode = serviceFacade.getEpisodeService().getByUuid(video.getEpisodeUuid());
		videoInfoDTO.setEpisode(convertEpisode(episode));
		// 季信息
		Season season = serviceFacade.getSeasonService().getByUuid(video.getSeasonUuid());
		SeasonDTO seasonDTO = new SeasonDTO();
		seasonDTO.setUuid(season.getUuid());
		seasonDTO.setChineseName(season.getChineseName());
		seasonDTO.setSeasonIndex(season.getSeasonIndex());
		seasonDTO.setPosterUrl(season.getPosterUrl());
		videoInfoDTO.setSeason(seasonDTO);
		// 用户信息
		User user = serviceFacade.getUserService().getByUuid(video.getUserUuid());
		UserDTO userDTO = new UserDTO();
		userDTO.setUuid(user.getUuid());
		userDTO.setUserName(user.getUserName());
		userDTO.setNickname(user.getNickname());
		videoInfoDTO.setUser(userDTO);
		// 字幕组信息
		Fansub fansub = serviceFacade.getFansubService().getByUuid(video.getFansubUuid());
		FansubDTO fansubDTO = new FansubDTO();
		fansubDTO.setUuid(fansub.getUuid());
		fansubDTO.setFansubName(fansub.getFansubName());
		videoInfoDTO.setFansub(fansubDTO);
		return videoInfoDTO;
	}
	
	/**
	 * 把Video从Model转换成DTO
	 * 
	 * @param videos
	 * @return List<VideoInfoDto>
	 * @author caizhukui
	 * @date 2017年9月2日
	 */
	private List<VideoInfoDTO> convertVideoInfo(List<Video> videos) {
		List<VideoInfoDTO> videoInfoDTOs = new ArrayList<VideoInfoDTO>();
		for (Video video : videos) {
			videoInfoDTOs.add(convertVideoInfo(video));
		}
		return videoInfoDTOs;
	}

    @Override
    protected String getName() {
        return "视频";
    }
	
}
