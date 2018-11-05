package com.caizhukui.rrmeiju.service;

import java.util.List;

import com.caizhukui.rrmeiju.model.Fansub;
import com.caizhukui.rrmeiju.service.base.BaseService;

public interface FansubService extends BaseService<Fansub> {
	
	/**
	 * 查询某一用户加入的所有字幕组
	 * 
	 * @param userUuid 用户UUID
	 * @return List<Fansub> 字幕组列表
	 * @author caizhukui
	 * @date 2017年1月26日
	 */
	List<Fansub> getByUserUuid(String userUuid);
	
	/**
	 * 查询上传了某一季字幕的所有字幕组
	 * 
	 * @param seasonUuid 季ID
	 * @return List<Fansub>
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	List<Fansub> getBySeasonUuid(String seasonUuid);

}
