package com.caizhukui.rrmeiju.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.caizhukui.rrmeiju.model.Subtitle;
import com.caizhukui.rrmeiju.model.SubtitleFile;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 美剧字幕服务接口
 * 
 * @author caizhukui
 * @date 2017年1月19日
 */
public interface SubtitleService extends BaseService<Subtitle> {
	
	/**
	 * 查询某一字幕组上传的字幕数量
	 * 
	 * @param fansubUuid 字幕组UUID
	 * @return int 该字幕组上传的字幕数量
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	int getCountByFansubUuid(String fansubUuid);
	
	/**
	 * 查询某一用户上传的字幕数量
	 * 
	 * @param userUuid 用户UUID
	 * @return int 该用户上传的字幕数量
	 * @author caizhukui
	 * @date 2017年5月8日
	 */
	int getCountByUserUuid(String userUuid);
	
	/**
	 * 根据文件MD5值查询字幕
	 * 
	 * @param fileMd5 字幕文件MD5值
	 * @return Subtitle
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	Subtitle getByFileMd5(String fileMd5);
	
	/**
	 * 根据字幕标题查询Subtitle
	 * 
	 * @param subtitleTitle 字幕标题
	 * @return List<Subtitle>
	 * @author caizhukui
	 * @date 2017年1月19日
	 */
	List<Subtitle> getByTitle(String subtitleTitle);
	
	/**
	 * 根据EpisodeId查询Subtitle
	 * 
	 * @param episodeId
	 * @return List<Subtitle>
	 * @author caizhukui
	 * @date 2017年1月19日
	 */
	List<Subtitle> getByEpisodeUuid(String episodeId);
	
	/**
	 * 分页查询某一用户关注的剧集的所有字幕
	 * 
	 * @param userUuid 用户UUID
	 * @param pageSize 每页记录数
	 * @param pageIndex 第几页
	 * @return List<Subtitle>
	 * @author caizhukui
	 * @date 2017年6月13日
	 */
	List<Subtitle> getUserFollowSubtitlesPaginated(String userUuid, int pageSize, int pageIndex);

	/**
	 * 更新字幕下载次数，自增1
	 * 
	 * @author caizhukui
	 * @date 2017年3月8日
	 */
	void increaseDownloadCount(String subtitleId);
	
	/**
	 * 查询最近一周（当前日期的前7天）内下载次数最多的字幕
	 * 
	 * @return List<Subtitle>
	 * @author caizhukui
	 * @date 2017年10月14日
	 */
	List<Subtitle> getMostDownloadedSubtitlesOfLastWeek();
	
}
