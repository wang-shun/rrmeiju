package com.caizhukui.rrmeiju.service;

import java.util.List;

import com.caizhukui.rrmeiju.model.SubtitleFile;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 字幕文件服务接口
 * 
 * @author caizhukui
 * @date 2017年3月17日
 */
public interface SubtitleFileService extends BaseService<SubtitleFile> {
	
	/**
	 * 根据subtitleId查询SubtitleFile<br>
	 * 如果查询结果为空，返回空的List而不是null
	 * 
	 * @param subtitleUuid 字幕UUID
	 * @return List<SubtitleFile>
	 * @author caizhukui
	 * @date 2017年3月17日
	 */
	List<SubtitleFile> getBySubtitleUuid(String subtitleUuid);

}
