package com.caizhukui.rrmeiju.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.service.SeasonService;
import com.caizhukui.rrmeiju.service.base.BaseService;

import junit.framework.TestCase;

/**
 * 美剧季服务测试类
 * 
 * @author caizhukui
 * @date 2018年3月20日
 */
public class SeasonServiceTest extends JdbcServiceTest<Season> {
    
    /**  */
    private static final String EXISTENT_SEASON_UUID = "005d797beb9b11e7ac1600163e05314b";
    
    /**  */
    private static final String EXISTENT_SERIAL_UUID = "b7dc170aeb9a11e7ac1600163e05314b";
    
    @Autowired
    private SeasonService seasonService;

    @Override
    public BaseService<Season> service() {
        return seasonService;
    }

    @Override
    public String getExistentUuid() {
        return EXISTENT_SEASON_UUID;
    }

    @Override
    public Season createRecord() {
        Season record = new Season();
        record.setEnglishName("englishName");
        record.setChineseName("chineseName");
        record.setSerialUuid("serialUuid");
        record.setPremiereDate(new Date());
        record.setEpisodeCount(20);
        record.setSeasonIndex(2);
        record.setPosterUrl("posterUrl");
        record.setFinished(false);
        record.setDoubanId("177645");
        record.setDoubanUrl("doubanUrl");
        record.setDoubanRating(7.2F);
        record.setSummary("summary");
        record.setDirectors("directors");
        record.setCasts("casts");
        record.setCountries("countries");
        record.setGenres("genres");
        return record;
    }
    
    @Override
    public void updateRecord(Season record) {
        record.setEnglishName("englishNameNew");
        record.setChineseName("chineseNameNew");
        record.setSerialUuid("serialUuidNew");
        record.setPremiereDate(new Date());
        record.setEpisodeCount(21);
        record.setSeasonIndex(3);
        record.setPosterUrl("posterUrlNew");
        record.setFinished(true);
        record.setDoubanId("177646");
        record.setDoubanUrl("doubanUrlNew");
        record.setDoubanRating(7.3F);
        record.setSummary("summaryNew");
        record.setDirectors("directorsNew");
        record.setCasts("castsNew");
        record.setCountries("countriesNew");
        record.setGenres("genresNew");
    }
    
    /**
     * 根据字幕组UUID查询美剧季
     * 
     * @author caizhukui
     * @date 2018年3月20日
     */
    @Test
    public void testGetByFansubUuid() {
        final String fansubUuid = "b222dc7fe21611e6913800163e0521c8";
        final int limit = 2;
        List<Season> seasons = seasonService.getByFansubUuid(fansubUuid, limit);
        systemOut(seasons);
        TestCase.assertEquals(limit, seasons.size());
    }
    
    /**
     * 根据美剧系列UUID查询季数量
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetCountBySerialUuid() {
        int count = seasonService.getCountBySerialUuid(EXISTENT_SERIAL_UUID);
        TestCase.assertTrue(count > 0);
    }
    
    /**
     * 根据美剧系列UUID查询全部季
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetBySerialUuid() {
        List<Season> seasons = seasonService.getBySerialUuid(EXISTENT_SERIAL_UUID);
        systemOut(seasons);
        TestCase.assertTrue(seasons.size() > 0);
    }
    
    /**
     * 给没有海报的美剧季设置默认海报
     * 
     * @author caizhukui
     * @date 2018年5月23日
     */
    @Test
    public void testSetDefaultPosterUrlOfAll() {
        seasonService.setDefaultPosterUrlOfAll();
    }

}
