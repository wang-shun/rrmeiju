package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.SubtitleMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.SubtitleFile;
import com.caizhukui.rrmeiju.service.SubtitleService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 字幕服务实现类
 * 
 * @author caizhukui
 * @date 2017年1月19日
 */
@Service
public class SubtitleServiceImpl extends BaseServiceImpl<Subtitle> implements SubtitleService {
	
	private static final Logger logger = LoggerFactory.getLogger(SubtitleServiceImpl.class);
	
	@Autowired
	private SubtitleMapper subtitleMapper;
	
	@Override
	public int getCountByFansubUuid(String fansubUuid) {
		int count = subtitleMapper.getCountByFansubUuid(fansubUuid);
		return count;
	}
	
	@Override
	public int getCountByUserUuid(String userId) {
		int count = subtitleMapper.getCountByUserUuid(userId);
		return count;
	}

	@Override
	public Subtitle getByFileMd5(String fileMd5) {
		Subtitle subtitle = subtitleMapper.getByFileMd5(fileMd5);
		return subtitle;
	}

	@Override
	public List<Subtitle> getByTitle(String subtitleTitle) {
		List<Subtitle> subtitles = subtitleMapper.getByTitle(subtitleTitle);
		return subtitles;
	}

	@Override
	public List<Subtitle> getByEpisodeUuid(String episodeUuid) {
		List<Subtitle> subtitles = subtitleMapper.getByEpisodeUuid(episodeUuid);
		return subtitles;
	}
	
	@Override
	public List<Subtitle> getUserFollowSubtitlesPaginated(String userUuid, int pageSize, int pageIndex) {
		int startIndex = (pageIndex - 1) * pageSize;
		List<Subtitle> subtitles = subtitleMapper.getUserFollowSubtitlesPaginated(userUuid, pageSize, startIndex);
		return subtitles;
	}

	@Override
	public Subtitle add(Subtitle subtitle) {
	    // 新增字幕同时需要新增字幕文件
	    List<SubtitleFile> subtitleFiles = serviceFacade.getSubtitleFileService().batchAdd(subtitle.getSubtitleFiles());
	    subtitle.setSubtitleFiles(subtitleFiles);
		return super.add(subtitle);
	}

	@Override
	public void increaseDownloadCount(String subtitleUuid) {
		subtitleMapper.increaseDownloadCount(subtitleUuid);
	}

	@Override
	public List<Subtitle> getMostDownloadedSubtitlesOfLastWeek() {
		return subtitleMapper.getMostDownloadedSubtitlesOfLastWeek();
	}
	
    @Override
    protected TableEnum getTable() {
        return TableEnum.SUBTITLE;
    }

    @Override
    protected BaseMapper<Subtitle> getMapper() {
        return subtitleMapper;
    }

}
