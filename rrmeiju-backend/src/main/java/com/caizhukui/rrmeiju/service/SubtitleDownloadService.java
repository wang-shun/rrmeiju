package com.caizhukui.rrmeiju.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.caizhukui.rrmeiju.model.SubtitleDownload;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 字幕下载记录服务接口
 * 
 * @author caizhukui
 * @date 2017年5月10日
 */
public interface SubtitleDownloadService extends BaseService<SubtitleDownload> {
	
	/**
	 * 查询字幕下载记录的所有IP
	 * 
	 * @return Set<String>
	 * @author caizhukui
	 * @date 2017年6月6日
	 */
	Set<String> getAllIps();
	
	/**
	 * 根据用户UUID查询字幕下载记录
	 * 
	 * @param userUuid 用户UUID
	 * @return List<SubtitleDownload>
	 * @author caizhukui
	 * @date 2017年5月10日
	 */
	List<SubtitleDownload> getByUserUuid(String userUuid);
	
	/**
	 * 根据字幕UUID查询字幕下载记录
	 * 
	 * @param subtitleUuid 字幕UUID
	 * @return List<SubtitleDownload>
	 * @author caizhukui
	 * @date 2017年7月21日
	 */
	List<SubtitleDownload> getBySubtitleUuid(String subtitleUuid);
	
	/**
	 * 查询字幕下载量的全国地域分布数据
	 * 
	 * @return List<Map<String, Object>>
	 * @author caizhukui
	 * @date 2017年7月18日
	 */
	List<Map<String, Object>> getGeoData();

}
