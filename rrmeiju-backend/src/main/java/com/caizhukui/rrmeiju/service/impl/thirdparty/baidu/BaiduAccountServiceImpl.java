package com.caizhukui.rrmeiju.service.impl.thirdparty.baidu;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baidu.drapi.autosdk.core.ResHeader;
import com.baidu.drapi.autosdk.core.ResHeaderUtil;
import com.baidu.drapi.autosdk.exception.ApiException;
import com.baidu.drapi.autosdk.sms.service.AccountInfo;
import com.baidu.drapi.autosdk.sms.service.AccountService;
import com.baidu.drapi.autosdk.sms.service.GetAccountInfoRequest;
import com.baidu.drapi.autosdk.sms.service.GetAccountInfoResponse;
import com.baidu.drapi.autosdk.sms.service.UpdateAccountInfoRequest;
import com.baidu.drapi.autosdk.sms.service.UpdateAccountInfoResponse;
import com.caizhukui.rrmeiju.service.thirdparty.baidu.BaiduAccountService;

/**
 * 账户服务实现类
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
@Service
public class BaiduAccountServiceImpl extends BaiduServiceImpl implements BaiduAccountService {
    
    private static final Logger logger = LoggerFactory.getLogger(BaiduAccountServiceImpl.class);
    
    /** 账户服务 */
    private AccountService accountService;

    public BaiduAccountServiceImpl() throws ApiException {
        super();
        accountService = factory.getService(AccountService.class);
    }

    @Override
    public AccountInfo getAccoutInfo(List<String> accountFields) throws ApiException {
        GetAccountInfoRequest request = new GetAccountInfoRequest();
        request.setAccountFields(accountFields);
        GetAccountInfoResponse response = accountService.getAccountInfo(request);
        ResHeader header = ResHeaderUtil.getResHeader(accountService, true);
        List<AccountInfo> data = response.getData();
        logger.debug("getAccoutInfo - header = {}, data = {}", header, data);
        AccountInfo accountInfo = null;
        if (isSuccess(header)) {
            accountInfo = data.get(0);
        }
        return accountInfo;
    }

    @Override
    public AccountInfo updateAccountInfo(AccountInfo accountInfo) throws ApiException {
        UpdateAccountInfoRequest request = new UpdateAccountInfoRequest();
        request.setAccountInfo(accountInfo);
        UpdateAccountInfoResponse response = accountService.updateAccountInfo(request);
        ResHeader header = ResHeaderUtil.getResHeader(accountService, true);
        List<AccountInfo> data = response.getData();
        logger.debug("updateAccountInfo - header = {}, data = {}", header, data);
        if (isSuccess(header)) {
            accountInfo = data.get(0);
        }
        return accountInfo;
    }

}
