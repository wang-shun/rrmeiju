package com.caizhukui.rrmeiju.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caizhukui.rrmeiju.model.Video;
import com.caizhukui.rrmeiju.service.VideoService;
import com.caizhukui.rrmeiju.service.base.BaseService;

import junit.framework.TestCase;

/**
 * 视频服务测试类
 * 
 * @author caizhukui
 * @date 2018年4月23日
 */
public class VideoServiceTest extends JdbcServiceTest<Video> {
    
    @Autowired
    private VideoService videoService;

    @Override
    public BaseService<Video> service() {
        return videoService;
    }

    @Override
    public String getExistentUuid() {
        return "00bb94478b5044da8bd653921c1a86fa";
    }

    @Override
    public Video createRecord() {
        Video record = new Video();
        record.setVideoTitle("videoTitle");
        record.setVideoUrl("videoUrl");
        record.setSubtitleLang("subtitleLang");
        record.setVideoFormat("videoFormat");
        record.setVideoSource("videoSource");
        record.setEpisodeUuid("episodeUuid");
        record.setSeasonUuid("seasonUuid");
        record.setUserUuid("userUuid");
        record.setFansubUuid("fansubUuid");
        record.setRemark("remark");
        record.setViewCount(200);
        record.setDeleted(false);
        record.setUploadTime(new Date());
        return record;
    }

    @Override
    public void updateRecord(Video record) {
        record.setVideoTitle("videoTitleNew");
        record.setVideoUrl("videoUrlNew");
        record.setSubtitleLang("subtitleLangNew");
        record.setVideoFormat("videoFormatNew");
        record.setVideoSource("videoSourceNew");
        record.setEpisodeUuid("episodeUuidNew");
        record.setSeasonUuid("seasonUuidNew");
        record.setUserUuid("userUuidNew");
        record.setFansubUuid("fansubUuidNew");
        record.setRemark("remarkNew");
        record.setViewCount(201);
        record.setDeleted(true);
        record.setUploadTime(new Date());
    }
    
    /**
     * 根据美剧集UUID查询视频信息
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetByEpisodeUuid() {
        final String episodeUuid = "338a6507982211e798eb00163e0521c8";
        List<Video> videos = videoService.getByEpisodeUuid(episodeUuid);
        systemOut(videos);
        TestCase.assertTrue(videos.size() > 0);
    }

}
