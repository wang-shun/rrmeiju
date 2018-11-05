package com.caizhukui.rrmeiju.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.caizhukui.common.service.TranslationService;

import junit.framework.TestCase;

/**
 * 翻译服务测试类
 * 
 * @author caizhukui
 * @date 2018年4月25日
 */
public class TranslationServiceTest extends BaseServiceTest {
    
    @Autowired
    @Qualifier("baiduTranslationService")
    private TranslationService baiduTranslationService;
    
    @Autowired
    @Qualifier("youdaoTranslationService")
    private TranslationService youdaoTranslationService;
    
    /**
     * 测试百度翻译接口
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testBaiduTranslate() {
        String text = "My name is Alice, and I work in Google.";
        String translatedText = baiduTranslationService.translate(text);
        systemOut(translatedText);
        TestCase.assertNotNull(translatedText);
    }
    
    /**
     * 测试有道翻译接口
     * 
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testYoudaoTranslate() {
        String text = "My name is Alice, and I work in Google.";
        String translatedText = youdaoTranslationService.translate(text);
        systemOut(translatedText);
        TestCase.assertNotNull(translatedText);
    }

}
