package com.caizhukui.rrmeiju.service;

import java.util.List;

import com.caizhukui.rrmeiju.model.IdxBgPic;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年3月14日
 */
public interface IdxBgPicService {
	
	/**
	 * 
	 * 
	 * @param idxBgPic
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	void add(IdxBgPic idxBgPic);
	
	/**
	 * 
	 * 
	 * @param fileUrl
	 * @return IdxBgPic
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	IdxBgPic getByFileUrl(String fileUrl);
	
	/**
	 * 
	 * 
	 * @return IdxBgPic
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	IdxBgPic getByRandom(String currentFileId);
	
	/**
	 * 
	 * 
	 * @return List<IdxBgPic>
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	List<IdxBgPic> getAll();
	
	/**
	 * 
	 * 
	 * @param uuid 文件UUID
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	void deleteByUuid(String uuid);

}
