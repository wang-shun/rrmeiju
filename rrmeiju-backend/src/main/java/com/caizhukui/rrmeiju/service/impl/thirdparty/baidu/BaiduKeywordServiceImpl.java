package com.caizhukui.rrmeiju.service.impl.thirdparty.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baidu.drapi.autosdk.core.ResHeader;
import com.baidu.drapi.autosdk.core.ResHeaderUtil;
import com.baidu.drapi.autosdk.exception.ApiException;
import com.baidu.drapi.autosdk.sms.service.GetWordRequest;
import com.baidu.drapi.autosdk.sms.service.GetWordResponse;
import com.baidu.drapi.autosdk.sms.service.KeywordService;
import com.baidu.drapi.autosdk.sms.service.KeywordType;
import com.caizhukui.rrmeiju.service.impl.thirdparty.KeywordGetTempEnum;
import com.caizhukui.rrmeiju.service.impl.thirdparty.KeywordIdTypeEnum;
import com.caizhukui.rrmeiju.service.thirdparty.baidu.BaiduKeywordService;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年7月6日
 */
@Service
public class BaiduKeywordServiceImpl extends BaiduServiceImpl implements BaiduKeywordService {
    
    private static final Logger logger = LoggerFactory.getLogger(BaiduKeywordServiceImpl.class);
    
    private static final String[] FIELDS = {"keyword", "keywordId"};
    
    /**  */
    private KeywordService keywordService;

    public BaiduKeywordServiceImpl() throws ApiException {
        super();
        keywordService = factory.getService(KeywordService.class); 
    }

    @Override
    public List<KeywordType> getWord(List<KeywordType> keywordTypes) throws ApiException {
        GetWordRequest request = new GetWordRequest();
        List<Long> ids = new ArrayList<>(keywordTypes.size());
        for (KeywordType keywordType : keywordTypes) {
            ids.add(keywordType.getKeywordId());
        }
        request.setWordFields(Arrays.asList(FIELDS));
        request.setIds(ids);
        request.setIdType(KeywordIdTypeEnum.KEYWORD.getValue());
        request.setGetTemp(KeywordGetTempEnum.SELF.getValue());
        GetWordResponse response = keywordService.getWord(request);
        ResHeader header = ResHeaderUtil.getResHeader(keywordService, true);
        List<KeywordType> data = response.getData();
        logger.debug("getWord - header = {}, data = {}", header, data);
        if (isSuccess(header)) {
            
        }
        return data;
    }

    @Override
    public List<KeywordType> addWord(List<KeywordType> keywordTypes) throws ApiException {
        // TODO Auto-generated method stub
        return null;
    }

}
