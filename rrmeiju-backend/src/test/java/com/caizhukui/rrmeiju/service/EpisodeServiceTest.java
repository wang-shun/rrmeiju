package com.caizhukui.rrmeiju.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.service.EpisodeService;
import com.caizhukui.rrmeiju.service.base.BaseService;

import junit.framework.TestCase;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月23日
 */
public class EpisodeServiceTest extends JdbcServiceTest<Episode> {
    
    /**  */
    private static final String EXISTENT_EPISODE_UUID = "00038eaf1f1e11e7beeb00163e0521c8";
    
    /**  */
    private static final String EXISTENT_SEASON_UUID = "a44ed5d01eb311e7beeb00163e0521c8";
    
    @Autowired
    private EpisodeService episodeService;

    @Override
    public BaseService<Episode> service() {
        return episodeService;
    }

    @Override
    public String getExistentUuid() {
        return EXISTENT_EPISODE_UUID;
    }

    @Override
    public Episode createRecord() {
        Episode record = new Episode();
        record.setTvmazeShowId(21);
        record.setSeasonIndex(3);
        record.setEpisodeIndex(12);
        record.setEpisodeName("episodeName");
        record.setSeasonUuid("seasonUuid");
        record.setAirDate(new Date());
        record.setAirTime("airTime");
        record.setAirStamp(new Date());
        record.setRuntime(5);
        record.setEnglishSummary("englishSummary");
        record.setChineseSummary("chineseSummary");
        record.setTvmazeUrl("tvmazeUrl");
        return record;
    }

    @Override
    public void updateRecord(Episode record) {
        record.setTvmazeShowId(22);
        record.setSeasonIndex(3);
        record.setEpisodeIndex(13);
        record.setEpisodeName("episodeNameNew");
        record.setSeasonUuid("seasonUuidNew");
        record.setAirDate(new Date());
        record.setAirTime("airTimeNew");
        record.setAirStamp(new Date());
        record.setRuntime(6);
        record.setEnglishSummary("englishSummaryNew");
        record.setChineseSummary("chineseSummaryNew");
        record.setTvmazeUrl("tvmazeUrlNew");
    }
    
    /**
     * 根据美剧季UUID查询集数
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetCountBySeasonUuid() {
        int count = episodeService.getCountBySeasonUuid(EXISTENT_SEASON_UUID);
        TestCase.assertTrue(count > 0);
    }
    
    /**
     * 查询某一季的所有集
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetBySeasonUuid() {
        List<Episode> episodes = episodeService.getBySeasonUuid(EXISTENT_SEASON_UUID);
        systemOut(episodes);
        TestCase.assertTrue(episodes.size() > 0);
    }
    
    /**
     * 根据季度UUID和第几集查询集信息
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetBySeasonUuidAndEpisodeIndex() {
        final int episodeIndex = 2;
        Episode episode = episodeService.getBySeasonUuidAndEpisodeIndex(EXISTENT_SEASON_UUID, episodeIndex);
        systemOut(episode);
        TestCase.assertNotNull(episode);
    }
    
    /**
     * 查询指定日期播出的剧集
     * 
     * @throws ParseException
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetByAirDate() throws ParseException {
        Date airDate = new SimpleDateFormat("yyyy-MM-dd").parse("2008-08-21");
        List<Episode> episodes = episodeService.getByAirDate(airDate);
        systemOut(episodes);
        TestCase.assertTrue(episodes.size() > 0);
    }
    
}
