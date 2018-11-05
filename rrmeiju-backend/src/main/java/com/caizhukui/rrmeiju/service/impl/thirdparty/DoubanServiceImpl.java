package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.caizhukui.common.exception.RestException;
import com.caizhukui.common.util.JsonUtils;
import com.caizhukui.rrmeiju.dto.douban.DoubanSubjectDTO;
import com.caizhukui.rrmeiju.dto.douban.response.DoubanGetMovieDTO;
import com.caizhukui.rrmeiju.dto.douban.response.DoubanSearchMovieDTO;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.service.thirdparty.DoubanService;

/**
 * 豆瓣服务实现类
 * 
 * @author caizhukui
 * @date 2017年5月5日
 */
@Service
public class DoubanServiceImpl implements DoubanService {
	
	private static final Logger logger = LoggerFactory.getLogger(DoubanServiceImpl.class);
	
	private static final String DOUBAN_SERVICE_URI = "http://api.douban.com/v2";
	
	private static final String DOUBAN_MOVIE_SERVICE_URI = DOUBAN_SERVICE_URI + "/movie";
	
	@Autowired
	protected RestTemplate restTemplate;

	@Override
	public List<DoubanSubjectDTO> searchMovie(String keyword) throws RestException {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("q", keyword);
		return searchMovie(params);
	}
	
	@Override
	public DoubanGetMovieDTO getMovie(String doubanId) throws RestException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(DOUBAN_MOVIE_SERVICE_URI + "/subject/" + doubanId);
		URI uri = builder.build().encode().toUri();
		ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
		DoubanGetMovieDTO doubanGetMovieDTO = JsonUtils.consume(entity, DoubanGetMovieDTO.class);
		logger.info("doubanGetMovieDTO = {}", doubanGetMovieDTO);
		return doubanGetMovieDTO;
	}
	
	/**
	 * 
	 * 
	 * @param params
	 * @return List<DoubanSubjectDto>
	 * @throws RestControllerException
	 * @author caizhukui
	 * @date 2017年5月5日
	 */
	private List<DoubanSubjectDTO> searchMovie(MultiValueMap<String, String> params) throws RestException {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(DOUBAN_MOVIE_SERVICE_URI + "/search").queryParams(params);
		URI uri = builder.build().encode().toUri();
		ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
		DoubanSearchMovieDTO doubanSearchMovieDTO = JsonUtils.consume(entity, DoubanSearchMovieDTO.class);
		List<DoubanSubjectDTO> doubanSubjectDTOs = doubanSearchMovieDTO.getSubjects();
		logger.info("doubanSubjectDTOs = {}", doubanSubjectDTOs);
		return doubanSubjectDTOs;
	}

}
