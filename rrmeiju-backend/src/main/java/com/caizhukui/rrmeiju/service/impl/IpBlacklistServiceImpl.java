package com.caizhukui.rrmeiju.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.mapper.IpBlacklistMapper;
import com.caizhukui.rrmeiju.model.IpBlacklist;
import com.caizhukui.rrmeiju.service.IpBlacklistService;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年6月14日
 */
@Service
public class IpBlacklistServiceImpl implements IpBlacklistService {
	
	@Autowired
	private IpBlacklistMapper ipBlacklistMapper;

	@Override
	public List<IpBlacklist> getAll() {
		List<IpBlacklist> ips = ipBlacklistMapper.getAll();
		return ips;
	}

	@Override
	public void add(IpBlacklist ipBlacklist) {
		if (StringUtils.isEmpty(ipBlacklist.getIpId())) {
			ipBlacklist.setIpId(UuidUtils.getUuid());
		}
		ipBlacklistMapper.add(ipBlacklist);
	}

}
