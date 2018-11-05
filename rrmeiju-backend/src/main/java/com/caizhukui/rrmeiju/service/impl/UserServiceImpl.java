package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.common.util.CollectionUtils;
import com.caizhukui.common.util.StringUtils;
import com.caizhukui.rrmeiju.consts.Constant;
import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.UserMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.User;
import com.caizhukui.rrmeiju.service.UserService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 用户服务实现类
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAllAdmin() {
		List<User> users = userMapper.getAllAdmin();
		return users;
	}
	
	@Override
	public User getByMobileNumber(String mobileNumber) {
		User user = userMapper.getByMobileNumber(mobileNumber);
		return user;
	}
	
	@Override
	public User getByEmail(String email) {
		User user = userMapper.getByEmail(email);
		return user;
	}

	@Override
	public User getByUserName(String userName) {
		User user = userMapper.getByUserName(userName);
		return user;
	}

	@Override
	public User getByQqOpenId(String qqOpenId) {
		User user = userMapper.getByQqOpenId(qqOpenId);
		return user;
	}

	@Override
	public User getByWeixinOpenId(String weixinOpenId) {
		User user = userMapper.getByWeixinOpenId(weixinOpenId);
		return user;
	}

	@Override
	public User getByWeiboUid(String weiboUid) {
		User user = userMapper.getByWeiboUid(weiboUid);
		return user;
	}
	
	@Override
	public User getByBaiduUid(String baiduUid) {
		User user = userMapper.getByBaiduUid(baiduUid);
		return user;
	}

	@Override
	public User getByUserNameAndPassword(String userName, String password) {
		User user = userMapper.getByUserNameAndPassword(userName, password);
		return user;
	}
	
	@Override
	public List<User> getByFansubUuid(String fansubUuid) {
		List<User> users = userMapper.getByFansubUuid(fansubUuid);
		return CollectionUtils.emptyListInsteadOfNull(users);
	}
	
	@Override
	protected User preProcess(User user) {
	    // 第三方账号第一次登录时会自动注册，这种情况下生成默认的用户名
        if (StringUtils.isEmpty(user.getUserName())) {
            String userName = null;
            if (user.getQqOpenId() != null) {
                userName = "qq" + serviceFacade.getSequenceService().getNextVal("qq_default_username");
            } else if (user.getWeixinOpenId() != null) {
                userName = "weixin" + serviceFacade.getSequenceService().getNextVal("weixin_default_username");
            } else if (user.getWeiboUid() != null) {
                userName = "weibo" + serviceFacade.getSequenceService().getNextVal("weibo_default_username");
            } else if (user.getBaiduUid() != null) {
                userName = "baidu" + serviceFacade.getSequenceService().getNextVal("baidu_default_username");
            }
            user.setUserName(userName);
        }
        if (StringUtils.isEmpty(user.getNickname())) {
            // 默认的昵称跟用户名相同
            user.setNickname(user.getUserName());
        }
        if (StringUtils.isEmpty(user.getAvatarUrl())) {
            // 设置默认的头像
            user.setAvatarUrl(Constant.DEFAULT_AVATAR_URL);
        }
	    return user;
	}

	@Override
	public User add(User user) {
		super.add(user);
		String userUuid = user.getUuid();
		// 同步新增用户角色关联，默认角色为USER
		serviceFacade.getRoleService().addUserRole(userUuid, Constant.DEFAULT_USER_ROLE_UUID);
		return user;
	}

	@Override
	public boolean isUserUuidExist(String userUuid) {
		boolean isExist = false;
		int count = userMapper.getCountByUuid(userUuid);
		if (count > 0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public boolean isUserNameExist(String userName) {
		boolean isExist = false;
		int count = userMapper.getCountByUserName(userName);
		if (count > 0) {
			isExist = true;
		}
		return isExist;
	}
	
	@Override
	public boolean isMobileNumberExist(String mobileNumber) {
		boolean isExist = false;
		int count = userMapper.getCountByMobileNumber(mobileNumber);
		if (count > 0) {
			isExist = true;
		}
		return isExist;
	}
	
	@Override
	public void addUserRole(String userUuid, String roleUuid) {
		userMapper.addUserRole(userUuid, roleUuid);
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.USER;
    }

    @Override
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }

}
