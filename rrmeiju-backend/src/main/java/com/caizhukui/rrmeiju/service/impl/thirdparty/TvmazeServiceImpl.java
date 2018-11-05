package com.caizhukui.rrmeiju.service.impl.thirdparty;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.caizhukui.common.enums.CountryEnum;
import com.caizhukui.common.exception.RestException;
import com.caizhukui.common.util.JsonUtils;
import com.caizhukui.rrmeiju.service.thirdparty.TvmazeService;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeAkaDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeCastDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeCrewDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeEpisodeDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazePeopleDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeSeasonDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeShowDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.response.PeopleSearchDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.response.ShowSearchDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.response.TvmazeErrorDTO;
import com.caizhukui.rrmeiju.tvmaze.enums.TvmazeUrlPlaceholderEnum;

/**
 * TVmaze服务实现类
 * 
 * @author caizhukui
 * @date 2018年1月2日
 */
@Service
public class TvmazeServiceImpl implements TvmazeService {

    private static final Logger logger = LoggerFactory.getLogger(TvmazeServiceImpl.class);
    
    /** TVmaze接口基础URL */
    private static final String API_BASE_URL = "http://api.tvmaze.com";
    
    private static final String SHOW_SEARCH_URL = API_BASE_URL + "/search/shows?q=:query";
    
    private static final String SHOW_SINGLE_SEARCH_URL = API_BASE_URL + "/singlesearch/shows?q=:query";
    
    private static final String PEOPLE_SEARCH_URL = API_BASE_URL + "/search/people?q=:query";
    
    private static final String SCHEDULE_URL = API_BASE_URL + "/schedule?country=:countrycode&date=:date";
    
    private static final String SHOW_MAIN_INFORMATION_URL = API_BASE_URL + "/shows/:id";
    
    private static final String SHOW_EPISODE_LIST_URL = SHOW_MAIN_INFORMATION_URL + "/episodes";
    
    private static final String EPISODE_BY_NUMBER_URL = SHOW_MAIN_INFORMATION_URL + "/episodebynumber?season=:season&number=:number";
    
    private static final String EPISODES_BY_DATE_URL = SHOW_MAIN_INFORMATION_URL + "/episodesbydate?date=:date";
    
    private static final String SHOW_SEASONS_URL = SHOW_MAIN_INFORMATION_URL + "/seasons";
    
    private static final String SEASON_EPISODES_URL = API_BASE_URL + "/seasons/:id/episodes";
    
    private static final String SHOW_CAST_URL = SHOW_MAIN_INFORMATION_URL + "/cast";
    
    private static final String SHOW_CREW_URL = SHOW_MAIN_INFORMATION_URL + "/crew";
    
    private static final String SHOW_AKAS_URL = SHOW_MAIN_INFORMATION_URL + "/akas";
    
    private static final String PEOPLE_MAIN_INFORMATION_URL = API_BASE_URL + "/people/:id";
    
    private static final String SHOW_UPDATES_URL = API_BASE_URL + "/updates/shows";
    
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Autowired
    protected RestTemplate restTemplate;
    
    @Override
    public List<ShowSearchDTO> showSearch(String showEnglishName) throws RestException {
        List<ShowSearchDTO> showSearchDTOs = null;
        String urlString = getShowSearchUrl(SHOW_SEARCH_URL, showEnglishName);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlString);
        URI uri = builder.build().encode().toUri();
        logger.info("showSearch - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("showSearch - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            showSearchDTOs = JsonUtils.consumeList(entity, ShowSearchDTO.class);
            logger.info("showSearch - showSearchDTOs = {}", showSearchDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return showSearchDTOs;
    }
    
	@Override
	public TvmazeShowDTO showSingleSearch(String showEnglishName) throws RestException {
	    TvmazeShowDTO tvmazeShowDTO = null;
        String urlString = getShowSingleSearchUrl(SHOW_SINGLE_SEARCH_URL, showEnglishName);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlString);
        URI uri = builder.build().encode().toUri();
        logger.info("showSingleSearch - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("showSingleSearch - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeShowDTO = JsonUtils.consume(entity, TvmazeShowDTO.class);
            logger.info("showSingleSearch - tvmazeShowDTO = {}", tvmazeShowDTO);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeShowDTO;
	}

    @Override
    public List<PeopleSearchDTO> peopleSearch(String peopleEnglishName) throws RestException {
        List<PeopleSearchDTO> peopleSearchDTOs = null;
        String urlString = getPeopleSearchUrl(PEOPLE_SEARCH_URL, peopleEnglishName);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlString);
        URI uri = builder.build().encode().toUri();
        logger.info("peopleSearch - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("peopleSearch - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            peopleSearchDTOs = JsonUtils.consumeList(entity, PeopleSearchDTO.class);
            logger.info("peopleSearch - peopleSearchDTOs = {}", peopleSearchDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return peopleSearchDTOs;
    }

    @Override
    public List<TvmazeEpisodeDTO> schedule(CountryEnum countryEnum, Date date) throws RestException {
        List<TvmazeEpisodeDTO> tvmazeEpisodeDTOs = null;
        String urlString = getScheduleUrl(SCHEDULE_URL, countryEnum, date);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlString);
        URI uri = builder.build().encode().toUri();
        logger.info("schedule - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("schedule - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeEpisodeDTOs = JsonUtils.consumeList(entity, TvmazeEpisodeDTO.class);
            logger.info("schedule - tvmazeEpisodeDTOs = {}", tvmazeEpisodeDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeEpisodeDTOs;
    }

    @Override
    public TvmazeShowDTO showMainInformation(Integer showId) throws RestException {
        TvmazeShowDTO tvmazeShowDTO = null;
        String urlString = getShowMainInformationUrl(SHOW_MAIN_INFORMATION_URL, showId);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlString);
        URI uri = builder.build().encode().toUri();
        logger.info("showMainInformation - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("showMainInformation - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeShowDTO = JsonUtils.consume(entity, TvmazeShowDTO.class);
            logger.info("showMainInformation - tvmazeShowDTO = {}", tvmazeShowDTO);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeShowDTO;
    }

    @Override
    public List<TvmazeEpisodeDTO> showEpisodeList(Integer showId) throws RestException {
        List<TvmazeEpisodeDTO> tvmazeEpisodeDTOs = null;
        String uriString = getShowEpisodeListUrl(SHOW_EPISODE_LIST_URL, showId);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriString);
        URI uri = builder.build().encode().toUri();
        logger.info("showEpisodeList - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("showEpisodeList - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeEpisodeDTOs = JsonUtils.consumeList(entity, TvmazeEpisodeDTO.class);
            logger.info("showEpisodeList - tvmazeEpisodeDTOs = {}", tvmazeEpisodeDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeEpisodeDTOs;
    }
    
    @Override
    public TvmazeEpisodeDTO episodeByNumber(Integer showId, Integer seasonIndex, Integer episodeIndex)
            throws RestException {
        TvmazeEpisodeDTO tvmazeEpisodeDTO = null;
        String uriString = getEpisodeByNumberUrl(EPISODE_BY_NUMBER_URL, showId, seasonIndex, episodeIndex);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriString);
        URI uri = builder.build().encode().toUri();
        logger.info("episodeByNumber - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("episodeByNumber - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeEpisodeDTO = JsonUtils.consume(entity, TvmazeEpisodeDTO.class);
            logger.info("episodeByNumber - tvmazeEpisodeDTO = {}", tvmazeEpisodeDTO);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeEpisodeDTO;
    }

    @Override
    public List<TvmazeEpisodeDTO> episodesByDate(Integer showId, Date date) throws RestException {
        List<TvmazeEpisodeDTO> tvmazeEpisodeDTOs = null;
        String uriString = getEpisodesByDateUrl(EPISODES_BY_DATE_URL, showId, date);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriString);
        URI uri = builder.build().encode().toUri();
        logger.info("episodesByDate - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("episodesByDate - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeEpisodeDTOs = JsonUtils.consumeList(entity, TvmazeEpisodeDTO.class);
            logger.info("episodesByDate - tvmazeEpisodeDTOs = {}", tvmazeEpisodeDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeEpisodeDTOs;
    }

    @Override
    public List<TvmazeSeasonDTO> showSeasons(Integer showId) throws RestException {
        List<TvmazeSeasonDTO> tvmazeSeasonDTOs = null;
        String uriString = getShowSeasonsUrl(SHOW_SEASONS_URL, showId);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriString);
        URI uri = builder.build().encode().toUri();
        logger.info("showSeasons - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("showSeasons - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeSeasonDTOs = JsonUtils.consumeList(entity, TvmazeSeasonDTO.class);
            logger.info("showSeasons - tvmazeSeasonDTOs = {}", tvmazeSeasonDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeSeasonDTOs;
    }

    @Override
    public List<TvmazeEpisodeDTO> seasonEpisodes(Integer seasonId) throws RestException {
        List<TvmazeEpisodeDTO> tvmazeEpisodeDTOs = null;
        String uriString = getSeasonEpisodesUrl(SEASON_EPISODES_URL, seasonId);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriString);
        URI uri = builder.build().encode().toUri();
        logger.info("seasonEpisodes - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("seasonEpisodes - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeEpisodeDTOs = JsonUtils.consumeList(entity, TvmazeEpisodeDTO.class);
            logger.info("seasonEpisodes - tvmazeEpisodeDTOs = {}", tvmazeEpisodeDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeEpisodeDTOs;
    }

    @Override
    public List<TvmazeCastDTO> showCast(Integer showId) throws RestException {
        List<TvmazeCastDTO> tvmazeCastDTOs = null;
        String uriString = getShowCastUrl(SHOW_CAST_URL, showId);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriString);
        URI uri = builder.build().encode().toUri();
        logger.info("showCast - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("showCast - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeCastDTOs = JsonUtils.consumeList(entity, TvmazeCastDTO.class);
            logger.info("showCast - tvmazeCastDTOs = {}", tvmazeCastDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeCastDTOs;
    }

    @Override
    public List<TvmazeCrewDTO> showCrew(Integer showId) throws RestException {
        List<TvmazeCrewDTO> tvmazeCrewDTOs = null;
        String uriString = getShowCrewUrl(SHOW_CREW_URL, showId);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriString);
        URI uri = builder.build().encode().toUri();
        logger.info("showCrew - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("showCrew - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeCrewDTOs = JsonUtils.consumeList(entity, TvmazeCrewDTO.class);
            logger.info("showCrew - tvmazeCrewDTOs = {}", tvmazeCrewDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeCrewDTOs;
    }

    @Override
    public List<TvmazeAkaDTO> showAkas(Integer showId) throws RestException {
        List<TvmazeAkaDTO> tvmazeAkaDTOs = null;
        String uriString = getShowAkasUrl(SHOW_AKAS_URL, showId);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uriString);
        URI uri = builder.build().encode().toUri();
        logger.info("showAkas - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("showAkas - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazeAkaDTOs = JsonUtils.consumeList(entity, TvmazeAkaDTO.class);
            logger.info("showAkas - tvmazeAkaDTOs = {}", tvmazeAkaDTOs);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazeAkaDTOs;
    }

    @Override
    public TvmazePeopleDTO peopleMainInformation(Integer peopleId) throws RestException {
        TvmazePeopleDTO tvmazePeopleDTO = null;
        String urlString = getPeopleMainInformationUrl(PEOPLE_MAIN_INFORMATION_URL, peopleId);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(urlString);
        URI uri = builder.build().encode().toUri();
        logger.info("peopleMainInformation - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("peopleMainInformation - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            tvmazePeopleDTO = JsonUtils.consume(entity, TvmazePeopleDTO.class);
            logger.info("peopleMainInformation - tvmazePeopleDTO = {}", tvmazePeopleDTO);
        } else {
            handleTvmazeError(entity);
        }
        return tvmazePeopleDTO;
    }

    @Override
    public Map<Integer, Long> showUpdates() throws RestException {
        Map<Integer, Long> showUpdates = null;
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(SHOW_UPDATES_URL);
        URI uri = builder.build().encode().toUri();
        logger.info("showUpdates - uri = {}", uri);
        ResponseEntity<String> entity = restTemplate.getForEntity(uri, String.class);
        logger.info("showUpdates - statusCode = {}, responseBody = {}", entity.getStatusCode(), entity.getBody());
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            showUpdates = JsonUtils.consumeMap(entity, Integer.class, Long.class);
            logger.info("showUpdates - showUpdates = {}", showUpdates);
        } else {
            handleTvmazeError(entity);
        }
        return showUpdates;
    }

	private String getShowSearchUrl(String urlTemplate, String query) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.QUERY.getValue(), query);
    }

    private String getShowSingleSearchUrl(String urlTemplate, String query) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.QUERY.getValue(), query);
    }
    
    private String getPeopleSearchUrl(String urlTemplate, String query) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.QUERY.getValue(), query);
    }
    
    private String getScheduleUrl(String urlTemplate, CountryEnum countryEnum, Date date) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.COUNTRY_CODE.getValue(), String.valueOf(countryEnum.getCode()))
                .replaceAll(TvmazeUrlPlaceholderEnum.DATE.getValue(), new SimpleDateFormat(DATE_FORMAT).format(date));
    }
    
    private String getShowMainInformationUrl(String urlTemplate, Integer id) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id));
    }

    private String getEpisodeByNumberUrl(String urlTemplate, Integer id, Integer season, Integer number) {
        return urlTemplate
                .replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id))
                .replaceAll(TvmazeUrlPlaceholderEnum.SEASON.getValue(), String.valueOf(season))
                .replaceAll(TvmazeUrlPlaceholderEnum.NUMBER.getValue(), String.valueOf(number));
    }

    private String getShowEpisodeListUrl(String urlTemplate, Integer id) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id));
    }
    
    private String getEpisodesByDateUrl(String urlTemplate, Integer id, Date date) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id))
                .replaceAll(TvmazeUrlPlaceholderEnum.DATE.getValue(), new SimpleDateFormat(DATE_FORMAT).format(date));
    }
    
    private String getShowSeasonsUrl(String urlTemplate, Integer id) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id));
    }
    
    private String getSeasonEpisodesUrl(String urlTemplate, Integer id) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id));
    }
    
    private String getShowCastUrl(String urlTemplate, Integer id) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id));
    }
    
    private String getShowCrewUrl(String urlTemplate, Integer id) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id));
    }
    
    private String getShowAkasUrl(String urlTemplate, Integer id) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id));
    }
    
    private String getPeopleMainInformationUrl(String urlTemplate, Integer id) {
        return urlTemplate.replaceAll(TvmazeUrlPlaceholderEnum.ID.getValue(), String.valueOf(id));
    }

    /**
     * 
     * 
     * @param entity
     * @author caizhukui
     * @date 2018年5月16日
     */
    private void handleTvmazeError(ResponseEntity<String> entity) {
        try {
            TvmazeErrorDTO tvmazeErrorDTO = JsonUtils.consume(entity, TvmazeErrorDTO.class);
            logger.warn("调用TVmaze接口出错", tvmazeErrorDTO.getMesage());
        } catch (Exception e) {
            logger.error("解析TVmaze错误信息出错", e);
        }
    }

}
