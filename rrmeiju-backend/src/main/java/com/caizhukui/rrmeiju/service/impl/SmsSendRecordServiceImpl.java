package com.caizhukui.rrmeiju.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caizhukui.rrmeiju.enums.TableEnum;
import com.caizhukui.rrmeiju.mapper.SmsSendRecordMapper;
import com.caizhukui.rrmeiju.mapper.base.BaseMapper;
import com.caizhukui.rrmeiju.model.SmsSendRecord;
import com.caizhukui.rrmeiju.service.SmsSendRecordService;
import com.caizhukui.rrmeiju.service.base.BaseServiceImpl;

/**
 * 短信发送记录服务实现类
 * 
 * @author caizhukui
 * @date 2017年6月7日
 */
@Service
public class SmsSendRecordServiceImpl extends BaseServiceImpl<SmsSendRecord> implements SmsSendRecordService {
	
	private static final Logger logger = LoggerFactory.getLogger(SmsSendRecordServiceImpl.class);
	
	@Autowired
	private SmsSendRecordMapper smsSendRecordMapper;

	@Override
	public Set<String> getAllIps() {
		Set<String> ips = smsSendRecordMapper.getAllIps();
		return ips;
	}

	@Override
	public boolean isRestricted(String mobileNumber, String remoteIp) {
		boolean isResticted = false;
		int countByMobileNumber = smsSendRecordMapper.getTodayCountByMobileNumber(mobileNumber);
		int countByRemoteIp = smsSendRecordMapper.getTodayCountByRemoteIp(remoteIp);
		if (countByMobileNumber >= 5 || countByRemoteIp >= 5) {
			isResticted = true;
		}
		return isResticted;
	}

    @Override
    protected TableEnum getTable() {
        return TableEnum.SMS_SEND_RECORD;
    }

    @Override
    protected BaseMapper<SmsSendRecord> getMapper() {
        return smsSendRecordMapper;
    }

}
