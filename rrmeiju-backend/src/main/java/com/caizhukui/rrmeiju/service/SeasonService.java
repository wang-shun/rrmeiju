package com.caizhukui.rrmeiju.service;

import java.util.List;

import com.caizhukui.rrmeiju.model.Season;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 美剧季服务接口
 * 
 * @author caizhukui
 * @date 2016年10月20日
 */
public interface SeasonService extends BaseService<Season> {
	
	/**
	 * 根据美剧系列UUID查询季数量
	 * 
	 * @param serialUuid
	 * @return int
	 * @author caizhukui
	 * @date 2017年3月6日
	 */
	int getCountBySerialUuid(String serialUuid);
	
	/**
	 * 根据美剧系列UUID查询全部季
	 * 
	 * @param serialUuid 美剧系列UUID
	 * @return List<Season>
	 * @author caizhukui
	 * @date 2017年1月13日
	 */
	List<Season> getBySerialUuid(String serialUuid);
	
	/**
	 * 根据字幕组UUID查询美剧季
	 * 
	 * @param fansubUuid 字幕组UUID
	 * @param limit
	 * @return List<Season>
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	List<Season> getByFansubUuid(String fansubUuid, int limit);
	
	/**
	 * 
	 * 
	 * @author caizhukui
	 * @date 2018年5月23日
	 */
	void setDefaultPosterUrlOfAll();

}