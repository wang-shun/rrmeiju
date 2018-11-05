package com.caizhukui.rrmeiju.service.thirdparty;

import java.util.List;

import com.caizhukui.common.exception.RestException;
import com.caizhukui.rrmeiju.dto.douban.DoubanSubjectDTO;
import com.caizhukui.rrmeiju.dto.douban.response.DoubanGetMovieDTO;
import com.caizhukui.rrmeiju.exception.RestControllerException;

/**
 * 豆瓣服务接口
 * 
 * @author caizhukui
 * @date 2017年5月5日
 */
public interface DoubanService {
	
	/**
	 * 
	 * 
	 * @param keyword
	 * @return List<DoubanSubject>
	 * @throws RestControllerException
	 * @author caizhukui
	 * @date 2017年5月5日
	 */
	List<DoubanSubjectDTO> searchMovie(String keyword) throws RestException;
	
	/**
	 * 
	 * 
	 * @param doubanId
	 * @return DoubanGetMovieDto
	 * @throws RestControllerException
	 * @author caizhukui
	 * @date 2017年5月9日
	 */
	DoubanGetMovieDTO getMovie(String doubanId) throws RestException;

}
