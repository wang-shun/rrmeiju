package com.caizhukui.rrmeiju.controller;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年4月19日
 */
public class LoginControllerTest extends ControllerBaseTest {
	
	@Ignore
	@Test
    public void testLogin() throws Exception {
		/*MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setServletPath("user/login");
        request.setMethod("POST");
        request.addParameter("username", "egoecust");
        request.addParameter("password", "123456");
        final ModelAndView mav = this.excuteAction(request, response);
        Assert.assertEquals("user/loginSuccess", mav.getViewName());
        User user = (User)request.getAttribute("user");
        Assert.assertNotNull(user);
        Assert.assertEquals("egoecust", user.getUsername());
        Assert.assertEquals("123456", user.getPassword());
        Assert.assertEquals("13818143165", user.getMobile());*/
    }

}
