package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.Fansub;

/**
 * 字幕组Mapper接口
 * 
 * @author caizhukui
 * @date 2017年1月25日
 */
public interface FansubMapper extends BaseMapper<Fansub> {
	
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
	 * @param seasonUuid 美剧季度UUID
	 * @return List<Fansub>
	 * @author caizhukui
	 * @date 2017年5月4日
	 */
	List<Fansub> getBySeasonUuid(String seasonUuid);

}
