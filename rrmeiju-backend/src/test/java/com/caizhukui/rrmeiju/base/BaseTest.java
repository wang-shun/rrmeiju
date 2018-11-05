package com.caizhukui.rrmeiju.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.caizhukui.core.consts.ProfileConstant;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月17日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(ProfileConstant.DEV)
public class BaseTest {
    
    /**  */
    private static final String HIGHLIGHT = "************************************************";
    
    /**
     * 
     * 
     * @param obj
     * @author caizhukui
     * @date 2018年4月25日
     */
    protected void systemOut(Object obj) {
        System.out.println(HIGHLIGHT + obj);
    }

}
