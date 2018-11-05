package com.caizhukui.rrmeiju.service;

import java.util.List;

import com.caizhukui.rrmeiju.model.Video;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 视频服务接口
 * 
 * @author caizhukui
 * @date 2017年7月8日
 */
public interface VideoService extends BaseService<Video> {
	
	/**
	 * 根据美剧集UUID查询视频信息
	 * 
	 * @param episodeUuid 美剧集UUID
	 * @return List<Video>
	 * @author caizhukui
	 * @date 2017年7月8日
	 */
	List<Video> getByEpisodeUuid(String episodeUuid);
	
	/**
	 * 根据剧名、第几季和第几集查询视频信息
	 * 
	 * @param serialName 中文或英文剧名
	 * @param seasonIndex 第几季
	 * @param episodeIndex 第几集
	 * @return List<Video>
	 * @author caizhukui
	 * @date 2017年8月2日
	 */
	List<Video> getBySerialNameAndIndex(String serialName, int seasonIndex, int episodeIndex);
	
}
