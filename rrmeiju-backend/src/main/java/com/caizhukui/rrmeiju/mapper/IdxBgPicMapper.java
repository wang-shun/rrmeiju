package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.IdxBgPic;

/**
 * Mapper接口
 * 
 * @author caizhukui
 * @date 2017年3月14日
 */
public interface IdxBgPicMapper extends BaseMapper<IdxBgPic> {
	
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
	 * @param count
	 * @return List<IdxBgPic>
	 * @author caizhukui
	 * @date 2017年3月14日
	 */
	List<IdxBgPic> getByRandom(int count);
	
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
