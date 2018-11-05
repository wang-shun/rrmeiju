package com.caizhukui.rrmeiju.service.thirdparty.baidu;

import java.util.List;

import com.baidu.drapi.autosdk.exception.ApiException;
import com.baidu.drapi.autosdk.sms.service.KeywordType;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
public interface BaiduKeywordService {
    
    /**
     * 根据指定的单元ID、关键词ID获取关键词信息
     * 
     * @param keywordTypes
     * @return List<KeywordType>
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月6日
     */
    List<KeywordType> getWord(List<KeywordType> keywordTypes) throws ApiException;
    
    /**
     * 新增关键词
     * 
     * @param keywordTypes
     * @return List<KeywordType>
     * @throws ApiException
     * @author caizhukui
     * @date 2018年7月6日
     */
    List<KeywordType> addWord(List<KeywordType> keywordTypes) throws ApiException;

}
