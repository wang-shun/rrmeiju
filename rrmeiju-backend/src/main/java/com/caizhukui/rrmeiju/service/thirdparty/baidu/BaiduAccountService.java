package com.caizhukui.rrmeiju.service.thirdparty.baidu;

import java.util.List;

import com.baidu.drapi.autosdk.exception.ApiException;
import com.baidu.drapi.autosdk.sms.service.AccountInfo;

/**
 * 账户服务接口
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
public interface BaiduAccountService {
    
    /**
     * 根据用户名获取账户信息<br>
     * 如果是来自MCC Token的请求，则返回target对应的账户信息
     * 
     * @param accountFields 账户属性
     * @return AccountInfo
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月6日
     */
    AccountInfo getAccoutInfo(List<String> accountFields) throws ApiException;
    
    /**
     * 根据用户名更新账户信息<br>
     * 如果是来自MCC Token的请求，则更新target对应的账户信息
     * 
     * @param accountInfo
     * @return AccountInfo
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月6日
     */
    AccountInfo updateAccountInfo(AccountInfo accountInfo) throws ApiException;

}
