package com.caizhukui.rrmeiju.service.thirdparty;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caizhukui.common.enums.CountryEnum;
import com.caizhukui.common.exception.RestException;
import com.caizhukui.rrmeiju.service.BaseServiceTest;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeEpisodeDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazePeopleDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.TvmazeShowDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.response.PeopleSearchDTO;
import com.caizhukui.rrmeiju.tvmaze.dto.response.ShowSearchDTO;

import junit.framework.TestCase;

/**
 * TVmaze服务测试类
 * 
 * @author caizhukui
 * @date 2018年5月7日
 */
public class TvmazeServiceTest extends BaseServiceTest {
    
    @Autowired
    private TvmazeService tvmazeService;
    
    /**
     * 
     * 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月7日
     */
    @Test
    public void testShowSearch() throws RestException {
        final String showEnglishName = "Prison Break";
        List<ShowSearchDTO> showSearchDTOs = tvmazeService.showSearch(showEnglishName);
        systemOut(showSearchDTOs);
        TestCase.assertNotNull(showSearchDTOs);
    }
    
    /**
     * 
     * 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    @Test
    public void testShowSingleSearch() throws RestException {
        final String showEnglishName = "Vice";
        TvmazeShowDTO tvmazeShowDTO = tvmazeService.showSingleSearch(showEnglishName);
        systemOut(tvmazeShowDTO);
        TestCase.assertNotNull(tvmazeShowDTO);
    }
    
    /**
     * 
     * 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月17日
     */
    @Test
    public void testShowMainInformation() throws RestException {
        final Integer showId = 1;
        TvmazeShowDTO tvmazeShowDTO = tvmazeService.showMainInformation(showId);
        systemOut(tvmazeShowDTO);
        TestCase.assertNotNull(tvmazeShowDTO);
    }
    
    /**
     * 
     * 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月17日
     */
    @Test
    public void testEpisodesByDate() throws RestException {
        final Integer showId = 1;
        List<TvmazeEpisodeDTO> tvmazeEpisodeDTOs = tvmazeService.episodesByDate(showId, new Date());
        systemOut(tvmazeEpisodeDTOs);
        TestCase.assertNotNull(tvmazeEpisodeDTOs);
    }
    
    /**
     * 
     * 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月17日
     */
    @Test
    public void testSchedule() throws RestException {
        List<TvmazeEpisodeDTO> tvmazeEpisodeDTOs = tvmazeService.schedule(CountryEnum.US, new Date());
        systemOut(tvmazeEpisodeDTOs);
        TestCase.assertNotNull(tvmazeEpisodeDTOs);
    }
    
    /**
     * 
     * 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    @Test
    public void testShowUpdates() throws RestException {
        Map<Integer, Long> showUpdates = tvmazeService.showUpdates();
        systemOut(showUpdates);
        TestCase.assertNotNull(showUpdates);
    }
    
    /**
     * 
     * 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    @Test
    public void testPeopleMainInformation() throws RestException {
        final Integer peopleId = 1;
        TvmazePeopleDTO tvmazePeopleDTO = tvmazeService.peopleMainInformation(peopleId);
        systemOut(tvmazePeopleDTO);
        TestCase.assertNotNull(tvmazePeopleDTO);
    }
    
    /**
     * 
     * 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    @Test
    public void testPeopleSearch() throws RestException {
        final String peopleEnglishName = "Kate Beckinsale";
        List<PeopleSearchDTO> peopleSearchDTOs = tvmazeService.peopleSearch(peopleEnglishName);
        systemOut(peopleSearchDTOs);
        TestCase.assertNotNull(peopleSearchDTOs);
    }

    /**
     * 
     * 
     * @throws RestException
     * @author caizhukui
     * @date 2018年5月16日
     */
    @Test
    public void testError() throws RestException {
        final Integer peopleId = -1;
        TvmazePeopleDTO tvmazePeopleDTO = tvmazeService.peopleMainInformation(peopleId);
        systemOut(tvmazePeopleDTO);
        TestCase.assertNull(tvmazePeopleDTO);
    }

}
