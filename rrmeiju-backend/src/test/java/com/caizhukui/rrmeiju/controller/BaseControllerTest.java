package com.caizhukui.rrmeiju.controller;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.caizhukui.rrmeiju.base.BaseTest;
import com.caizhukui.rrmeiju.config.AppConfig;
import com.caizhukui.rrmeiju.config.WebConfig;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月17日
 */
@ContextConfiguration(classes = { AppConfig.class, WebConfig.class })
@WebAppConfiguration
public class BaseControllerTest extends BaseTest {

}
