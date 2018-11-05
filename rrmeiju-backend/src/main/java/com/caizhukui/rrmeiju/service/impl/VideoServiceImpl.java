package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.VideoMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Video;
import com.caizhukui.rrmeiju.service.VideoService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 视频服务实现类
 * 
 * @author caizhukui
 * @date 2017年7月8日
 */
@Service
public class VideoServiceImpl extends BaseServiceImpl<Video> implements VideoService {
	
	private static final Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);
	
	@Autowired
	private VideoMapper videoMapper;

	@Override
	public List<Video> getByEpisodeUuid(String episodeUuid) {
		List<Video> videos = videoMapper.getByEpisodeUuid(episodeUuid);
		return videos;
	}

	@Override
	public List<Video> getBySerialNameAndIndex(String serialName, int seasonIndex, int episodeIndex) {
		List<Video> videos = videoMapper.getBySerialNameAndIndex(serialName, seasonIndex, episodeIndex);
		return videos;
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.VIDEO;
    }

    @Override
    protected BaseMapper<Video> getMapper() {
        return videoMapper;
    }

}
