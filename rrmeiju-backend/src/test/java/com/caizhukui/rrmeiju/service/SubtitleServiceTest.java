package com.caizhukui.rrmeiju.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.SubtitleFile;
import com.caizhukui.rrmeiju.service.SubtitleService;
import com.caizhukui.rrmeiju.service.base.BaseService;

import junit.framework.TestCase;

/**
 * 字幕服务测试类
 * 
 * @author caizhukui
 * @date 2018年4月24日
 */
public class SubtitleServiceTest extends JdbcServiceTest<Subtitle> {
    
    /**  */
    private static final String EXISTENT_SUBTITLE_UUID = "001f02689b7145f399e3914fa9ec625e";
    
    @Autowired
    private SubtitleService subtitleService;

    @Override
    public BaseService<Subtitle> service() {
        return subtitleService;
    }

    @Override
    public String getExistentUuid() {
        return EXISTENT_SUBTITLE_UUID;
    }

    @Override
    public Subtitle createRecord() {
        Subtitle record = new Subtitle();
        record.setSubtitleTitle("subtitleTitle");
        record.setSubtitleUrl("subtitleUrl");
        record.setSubtitleLang("subtitleLang");
        record.setFileFormat("fileFormat");
        record.setEpisodeUuid("episodeUuid");
        record.setSeasonUuid("seasonUuid");
        record.setUserUuid("userUuid");
        record.setFansubUuid("fansubUuid");
        record.setRemark("remark");
        record.setDownloadCount(23);
        record.setUploadTime(new Date());
        record.setFileMd5("fileMd5");
        record.setFileSize(204478L);
        return record;
    }

    @Override
    public void updateRecord(Subtitle record) {
        record.setSubtitleTitle("subtitleTitleNew");
        record.setSubtitleUrl("subtitleUrlNew");
        record.setSubtitleLang("subtitleLangNew");
        record.setFileFormat("fileFormatNew");
        record.setEpisodeUuid("episodeUuidNew");
        record.setSeasonUuid("seasonUuidNew");
        record.setUserUuid("userUuidNew");
        record.setFansubUuid("fansubUuidNew");
        record.setRemark("remarkNew");
        record.setDownloadCount(24);
        record.setUploadTime(new Date());
        record.setFileMd5("fileMd5New");
        record.setFileSize(204479L);
    }
    
    /**
     * 
     * 
     * @author caizhukui
     * @date 2018年4月28日
     */
    @Test
    public void testGetByUuid() {
        Subtitle subtitle = subtitleService.getByUuid(EXISTENT_SUBTITLE_UUID);
        systemOut(subtitle);
        TestCase.assertNotNull(subtitle);
        TestCase.assertNotNull(subtitle.getEpisode());
        TestCase.assertNotNull(subtitle.getSeason());
        TestCase.assertNotNull(subtitle.getUser());
        TestCase.assertNotNull(subtitle.getFansub());
        List<SubtitleFile> subtitleFiles = subtitle.getSubtitleFiles();
        TestCase.assertNotNull(subtitleFiles);
        TestCase.assertTrue(subtitleFiles.size() > 0);
    }

}
