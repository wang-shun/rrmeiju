package com.caizhukui.rrmeiju.service.impl;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.UserOauthMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.UserOauth;
import com.caizhukui.rrmeiju.service.UserOauthService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月30日
 */
@Service
public class UserOauthServiceImpl extends BaseServiceImpl<UserOauth> implements UserOauthService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserOauthServiceImpl.class);

	@Autowired
	private UserOauthMapper userOauthMapper;
	
	@Override
	public UserOauth getByUserUuidAndSource(String userId, int source) {
		UserOauth userOauth = userOauthMapper.getByUserUuidAndSource(userId, source);
		if (userOauth == null) {
			userOauth = new UserOauth();
		}
		return userOauth;
	}

	@Override
	public UserOauth add(UserOauth userOauth) {
//	    userOauth.setUuidIfEmpty();
//		int expiresIn = userOauth.getExpiresIn();
//		if (expiresIn > 0 && userOauth.getExpireTime() == null) {
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(userOauth.getGrantTime());
//			calendar.add(Calendar.SECOND, expiresIn);
//			userOauth.setExpireTime(calendar.getTime());
//		}
//		userOauthMapper.add(userOauth);
//		return userOauthMapper.getByUuid(getTable(), userOauth.getUuid());
	    return null;
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.USER_OAUTH;
    }

    @Override
    protected BaseMapper<UserOauth> getMapper() {
        return userOauthMapper;
    }

}
