package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.common.util.CollectionUtils;
import com.caizhukui.common.util.StringUtils;
import com.caizhukui.rrmeiju.consts.CloudStorageConstant;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.SeasonMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.service.SeasonService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 美剧季服务实现类
 * 
 * @author caizhukui
 * @date 2017年3月6日
 */
@Service
public class SeasonServiceImpl extends BaseServiceImpl<Season> implements SeasonService {
	
	private static final Logger logger = LoggerFactory.getLogger(SeasonServiceImpl.class);
	
	@Autowired
	private SeasonMapper seasonMapper;
	
	@Override
	public int getCountBySerialUuid(String serialUuid) {
		int count = seasonMapper.getCountBySerialUuid(serialUuid);
		return count;
	}

	@Override
	public List<Season> getBySerialUuid(String serialUuid) {
	    return seasonMapper.getBySerialUuid(serialUuid);
	}
	
	@Override
	public List<Season> getByFansubUuid(String fansubUuid, int limit) {
	    return seasonMapper.getByFansubUuid(fansubUuid, limit);
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.SEASON;
    }

    @Override
    protected BaseMapper<Season> getMapper() {
        return seasonMapper;
    }

    @Override
    public void setDefaultPosterUrlOfAll() {
        int pageSize = 50, pageIndex = 1;
        List<Season> seasons = null;
        do {
            seasons = getAllByPagination(pageSize, pageIndex++);
            seasons.forEach(season -> {
                /*if (StringUtils.isBlank(season.getPosterUrl())) {
                    logger.info("设置美剧<{}>的默认海报链接", season.getChineseName());
                    season.setPosterUrl(CloudStorageConstant.OSS_DEFAULT_POSTER_URL);
                    serviceFacade.getSeasonService().updateByUuid(season);
                }*/
                if (season.getPosterUrl() != null && season.getPosterUrl().startsWith("https://ustvseries.oss-cn-shanghai.aliyuncs.com")) {
                    logger.info("设置美剧<{}>的默认海报链接", season.getChineseName());
                    season.setPosterUrl(season.getPosterUrl().replace("https://ustvseries.oss-cn-shanghai.aliyuncs.com", "http://oss.file.ustvseries.cn"));
                    serviceFacade.getSeasonService().updateByUuid(season);
                }
            });
        } while (CollectionUtils.isNotEmpty(seasons));
    }

}
