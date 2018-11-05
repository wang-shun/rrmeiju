package com.caizhukui.rrmeiju.service;

import java.util.Date;
import java.util.List;

import com.caizhukui.rrmeiju.model.Episode;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 美剧集服务接口
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
public interface EpisodeService extends BaseService<Episode> {
    
	/**
	 * 根据美剧季UUID查询集数
	 * 
	 * @param seasonUuid 美剧季UUID
	 * @return int
	 * @author caizhukui
	 * @date 2017年3月6日
	 */
	int getCountBySeasonUuid(String seasonUuid);

	/**
	 * 查询某一季的所有集
	 * 
	 * @param seasonUuid 美剧季UUID
	 * @return List<Episode>
	 * @author caizhukui
	 * @date 2017年1月17日
	 */
	List<Episode> getBySeasonUuid(String seasonUuid);
	
	/**
	 * 根据季度UUID和第几集查询集信息
	 * 
	 * @param seasonUuid 美剧季UUID
	 * @param episodeIndex 第几集
	 * @return Episode
	 * @author caizhukui
	 * @date 2017年7月12日
	 */
	Episode getBySeasonUuidAndEpisodeIndex(String seasonUuid, int episodeIndex);
	
	/**
	 * 批量新增美剧集
	 * 
	 * @param episodes
	 * @author caizhukui
	 * @date 2017年1月13日
	 */
	void batchAdd(List<Episode> episodes);
	
	/**
	 * 批量更新美剧集
	 * 
	 * @param episodes
	 * @author caizhukui
	 * @date 2017年7月12日
	 */
	void batchUpdateByUuid(List<Episode> episodes);
	
	/**
	 * 查询指定日期播出的剧集
	 * 
	 * @param date 日期
	 * @return List<Episode>
	 * @author caizhukui
	 * @date 2017年6月15日
	 */
	List<Episode> getByAirDate(Date date);

}
