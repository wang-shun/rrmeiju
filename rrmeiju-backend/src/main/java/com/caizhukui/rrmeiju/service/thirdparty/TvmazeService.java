package com.caizhukui.rrmeiju.service.thirdparty;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.caizhukui.common.enums.CountryEnum;
import com.caizhukui.common.exception.RestException;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeAkaDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeCastDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeCrewDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeEpisodeDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazePeopleDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeSeasonDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeShowDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.response.PeopleSearchDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.response.ShowSearchDTO;

/**
 * TVmaze服务接口
 * 
 * @author caizhukui
 * @date 2018年1月2日
 */
public interface TvmazeService {
    
    /**
     * 根据英文剧名模糊查询详情
     * 
     * @param showEnglishName 英文剧名
     * @return List<ShowSearchDTO>
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月7日
     */
    List<ShowSearchDTO> showSearch(String showEnglishName) throws RestException;
	
	/**
	 * 根据英文剧名精确查询详情
	 * 
	 * @param showEnglishName 英文剧名
	 * @return TvmazeShowDTO
	 * @throws RestException
	 * @author caizhukui
	 * @date 2018年1月2日
	 */
    TvmazeShowDTO showSingleSearch(String showEnglishName) throws RestException;
    
    /**
     * 
     * 
     * @param peopleEnglishName 英文人名
     * @return List<PeopleSearchDTO>
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月14日
     */
    List<PeopleSearchDTO> peopleSearch(String peopleEnglishName) throws RestException;
    
    /**
     * 
     * 
     * @param countryEnum
     * @param date
     * @return List<TvmazeEpisodeDTO>
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    List<TvmazeEpisodeDTO> schedule(CountryEnum countryEnum, Date date) throws RestException;
    
    /**
     * 
     * 
     * @param showId
     * @return TvmazeShowDTO
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    TvmazeShowDTO showMainInformation(Integer showId) throws RestException;
	
	/**
	 * 
	 * 
	 * @param showId
	 * @return List<TvmazeEpisodeDTO>
	 * @throws RestException
	 * @author caizhukui
	 * @date 2018年5月7日
	 */
	List<TvmazeEpisodeDTO> showEpisodeList(Integer showId) throws RestException;
	
	/**
	 * 
	 * 
	 * @param showId
	 * @param seasonIndex
	 * @param episodeIndex
	 * @return TvmazeEpisodeDTO
	 * @throws RestException
	 * @author caizhukui
	 * @date 2018年5月7日
	 */
	TvmazeEpisodeDTO episodeByNumber(Integer showId, Integer seasonIndex, Integer episodeIndex) throws RestException;
	
	/**
	 * 
	 * 
	 * @param showId
	 * @param date
	 * @return List<TvmazeEpisodeDTO>
	 * @throws RestException
	 * @author caizhukui
	 * @date 2018年5月16日
	 */
	List<TvmazeEpisodeDTO> episodesByDate(Integer showId, Date date) throws RestException;
	
	/**
	 * 
	 * 
	 * @param showId
	 * @return List<TvmazeSeasonDTO>
	 * @throws RestException
	 * @author caizhukui
	 * @date 2018年5月16日
	 */
	List<TvmazeSeasonDTO> showSeasons(Integer showId) throws RestException;
	
	/**
	 * 
	 * 
	 * @param seasonId
	 * @return List<TvmazeEpisodeDTO>
	 * @throws RestException
	 * @author caizhukui
	 * @date 2018年5月16日
	 */
	List<TvmazeEpisodeDTO> seasonEpisodes(Integer seasonId) throws RestException;
	
	/**
	 * 
	 * 
	 * @param showId
	 * @return List<TvmazeCastDTO> 
	 * @throws RestException
	 * @author caizhukui
	 * @date 2018年5月16日
	 */
	List<TvmazeCastDTO> showCast(Integer showId) throws RestException;
	
	/**
     * 
     * 
     * @param showId
     * @return List<TvmazeCrewDTO> 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    List<TvmazeCrewDTO> showCrew(Integer showId) throws RestException;
    
    /**
     * 
     * 
     * @param showId
     * @return List<TvmazeAkaDTO> 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    List<TvmazeAkaDTO> showAkas(Integer showId) throws RestException;
    
    /**
     * 
     * 
     * @param peopleId
     * @return TvmazePeopleDTO
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    TvmazePeopleDTO peopleMainInformation(Integer peopleId) throws RestException;
    
    /**
     * 
     * 
     * @return Map<Integer, Long>
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    Map<Integer, Long> showUpdates() throws RestException;

}
