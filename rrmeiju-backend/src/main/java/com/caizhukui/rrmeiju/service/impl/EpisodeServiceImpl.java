package com.caizhukui.rrmeiju.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.EpisodeMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.service.EpisodeService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 美剧集服务实现类
 * 
 * @author caizhukui
 * @date 2017年1月17日
 */
@Service
public class EpisodeServiceImpl extends BaseServiceImpl<Episode> implements EpisodeService {
	
	private static final Logger logger = LoggerFactory.getLogger(EpisodeServiceImpl.class);
	
	@Autowired
	private EpisodeMapper episodeMapper;

	@Override
	public int getCountBySeasonUuid(String seasonId) {
		int count = episodeMapper.getCountBySeasonUuid(seasonId);
		return count;
	}

	@Override
	public List<Episode> getBySeasonUuid(String seasonUuid) {
		List<Episode> episodes = episodeMapper.getBySeasonUuid(seasonUuid);
		return episodes;
	}
	
	@Override
	public Episode getBySeasonUuidAndEpisodeIndex(String seasonUuid, int episodeIndex) {
		Episode episode = episodeMapper.getBySeasonUuidAndEpisodeIndex(seasonUuid, episodeIndex);
		return episode;
	}

	@Override
	public void batchAdd(List<Episode> episodes) {
	    episodeMapper.batchAdd(episodes);
	}

	@Override
	public void batchUpdateByUuid(List<Episode> episodes) {
		for (Episode episode : episodes) {
			updateByUuid(episode);
		}
	}

	@Override
	public List<Episode> getByAirDate(Date airDate) {
		List<Episode> episodes = episodeMapper.getByAirDate(airDate);
		if (episodes == null) {
			episodes = new ArrayList<Episode>();
		}
		return episodes;
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.EPISODE;
    }

    @Override
    protected BaseMapper<Episode> getMapper() {
        return episodeMapper;
    }

}
