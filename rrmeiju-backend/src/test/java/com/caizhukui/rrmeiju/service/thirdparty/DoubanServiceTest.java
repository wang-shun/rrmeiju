package com.caizhukui.rrmeiju.service.thirdparty;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.caizhukui.common.exception.RestException;
import com.caizhukui.rrmeiju.dto.douban.DoubanSubjectDTO;
import com.caizhukui.rrmeiju.dto.douban.response.DoubanGetMovieDTO;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.service.BaseServiceTest;
import com.caizhukui.rrmeiju.service.thirdparty.DoubanService;

import junit.framework.TestCase;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月25日
 */
public class DoubanServiceTest extends BaseServiceTest {
    
    @Autowired
    private DoubanService doubanService;
    
    /**
     * 
     * 
     * @throws RestControllerException
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGetMovie() throws RestException {
        final String doubanId = "26726257";
        DoubanGetMovieDTO doubanGetMovieDTO = doubanService.getMovie(doubanId);
        systemOut(doubanGetMovieDTO);
        TestCase.assertNotNull(doubanGetMovieDTO);
    }
    
    /**
     * 
     * 
     * @throws RestControllerException
     * @author caizhukui
     * @date 2018年4月25日
     */
    @Test
    public void testGet() throws RestException {
        final String keyword = "越狱";
        List<DoubanSubjectDTO> doubanSubjectDTOs = doubanService.searchMovie(keyword);
        systemOut(doubanSubjectDTOs);
        TestCase.assertTrue(doubanSubjectDTOs.size() > 0);
    }

}
