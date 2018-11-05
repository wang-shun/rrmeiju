package com.caizhukui.rrmeiju.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.User;

/**
 * 用户Mapper接口
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
public interface UserMapper extends BaseMapper<User> {
	
	/**
	 * 查询所有管理员
	 * 
	 * @return List<User>
	 * @author caizhukui
	 * @date 2017年4月12日
	 */
	List<User> getAllAdmin();
	
	/**
	 * 根据用户UUID查询用户数量
	 * 
	 * @param uuid 用户UUID
	 * @return int
	 * @author caizhukui
	 * @date 2016年10月28日
	 */
	int getCountByUuid(String uuid);
	
	/**
	 * 根据用户名查询用户数量
	 * 
	 * @param userName 用户名
	 * @return int
	 * @author caizhukui
	 * @date 2016年10月27日
	 */
	int getCountByUserName(String userName);
	
	/**
	 * 根据手机号查询用户数量
	 * 
	 * @param mobileNumber 手机号
	 * @return int
	 * @author caizhukui
	 * @date 2016年10月27日
	 */
	int getCountByMobileNumber(String mobileNumber);

	/**
	 * 根据手机号查询用户
	 * 
	 * @param mobileNumber 手机号
	 * @return User
	 * @author caizhukui
	 * @date 2016年10月27日
	 */
	User getByMobileNumber(String mobileNumber);
	
	/**
	 * 根据邮箱查询用户
	 * 
	 * @param email 邮箱
	 * @return User 用户信息
	 * @author caizhukui
	 * @date 2017年6月10日
	 */
	User getByEmail(String email);
	
	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName 用户名
	 * @return User
	 * @author caizhukui
	 * @date 2016年10月27日
	 */
	User getByUserName(String userName);
	
	/**
	 * 根据QQ的OpenID查询用户
	 * 
	 * @param qqOpenId QQ的OpenID
	 * @return User 用户信息
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	User getByQqOpenId(String qqOpenId);
	
	/**
	 * 根据微信的OpenID查询用户
	 * 
	 * @param weixinOpenId 微信的OpenID
	 * @return User 用户信息
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	User getByWeixinOpenId(String weixinOpenId);
	
	/**
	 * 根据新浪微博的uid查询用户
	 * 
	 * @param weiboUid 新浪微博的uid
	 * @return User 用户信息
	 * @author caizhukui
	 * @date 2017年6月16日
	 */
	User getByWeiboUid(String weiboUid);
	
	/**
	 * 根据百度的uid查询客户
	 * 
	 * @param baiduUid 百度的uid
	 * @return User 用户信息
	 * @author caizhukui
	 * @date 2017年7月6日
	 */
	User getByBaiduUid(String baiduUid);
	
	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param userName 用户名
	 * @param password 密码
	 * @return User
	 * @author caizhukui
	 * @date 2016年10月28日
	 */
	User getByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
	
	/**
	 * 查询属于某一字幕组的所有User
	 * 
	 * @param fansubUuid 字幕组UUID
	 * @return List<User> 用户列表
	 * @author caizhukui
	 * @date 2017年1月26日
	 */
	List<User> getByFansubUuid(String fansubUuid);
	
	/**
	 * 新增用户角色关联
	 * 
	 * @param userUuid 用户UUID
	 * @param roleUuid 角色UUID
	 * @author caizhukui
	 * @date 2017年1月19日
	 */
	void addUserRole(String userUuid, String roleUuid);
	
	/**
     * 根据ID查询用户
     * 
     * @param id 用户ID
     * @return User 用户信息
     * @author caizhukui
     * @date 2018年3月16日
     */
    @Override
    @Select(GET_BY_ID)
    @ResultMap(BASE_MAP)
    User getById(@Param("tableName") String tableName, @Param("id") Long id);
    
    /**
     * 根据UUID查询用户
     * 
     * @param uuid 用户UUID
     * @return User 用户信息
     * @author caizhukui
     * @date 2017年1月19日
     */
    @Override
    @Select(GET_BY_UUID)
    @ResultMap(BASE_MAP)
    User getByUuid(@Param("tableName") String tableName, @Param("uuid") String uuid);
	
}
