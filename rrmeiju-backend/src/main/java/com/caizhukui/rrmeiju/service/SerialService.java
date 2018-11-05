package com.caizhukui.rrmeiju.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.caizhukui.rrmeiju.model.Serial;
import com.caizhukui.rrmeiju.service.base.BaseService;

/**
 * 美剧系列服务接口
 * 
 * @author caizhukui
 * @date 2018年4月21日
 */
public interface SerialService extends BaseService<Serial> {
    
	/**
	 * 查询某一用户关注的所有美剧
	 * 
	 * @param userUuid 用户UUID
	 * @return List<Serial>
	 * @author caizhukui
	 * @date 2017年1月26日
	 */
	List<Serial> getByUserUuid(String userUuid);
	
	/**
	 * 查询某一电视台拥有的所有美剧
	 * 
	 * @param televisionUuid 电视台UUID
	 * @return List<Serial>
	 * @author caizhukui
	 * @date 2017年10月19日
	 */
	List<Serial> getByTelevisionUuid(String televisionUuid);
	
	/**
	 * 批量新增Serial
	 * 
	 * @param serials
	 * @author caizhukui
	 * @date 2017年7月12日
	 */
	void batchAdd(List<Serial> serials);
	
	/**
	 * 批量更新Serial
	 * 
	 * @param serials
	 * @author caizhukui
	 * @date 2017年7月12日下午5:00:28
	 */
	void batchUpdate(List<Serial> serials);
	
	/**
	 * 用户关注剧集
	 * 
	 * @param userUuid 用户UUID
	 * @param serialUuid 剧集UUID
	 * @return boolean 操作结果
	 * @author caizhukui
	 * @date 2017年1月26日
	 */
	@Async
	boolean followSerial(String userUuid, String serialUuid);
	
	/**
	 * 用户取消关注剧集
	 * 
	 * @param userUuid 用户UUID
	 * @param serialUuid 剧集UUID
	 * @return boolean 操作结果
	 * @author caizhukui
	 * @date 2017年4月22日
	 */
	@Async
	boolean cancelFollowSerial(String userUuid, String serialUuid);
	
	/**
	 * 查询用户是否关注了某一剧集
	 * 
	 * @param userUuid 用户UUID
	 * @param serialUuid 剧集UUID
	 * @return boolean 查询结果
	 * @author caizhukui
	 * @date 2017年1月26日
	 */
	boolean isFollowSerial(String userUuid, String serialUuid);

}
