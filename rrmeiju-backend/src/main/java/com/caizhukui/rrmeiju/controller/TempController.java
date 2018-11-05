package com.caizhukui.rrmeiju.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 
 * @author caizhukui
 * @date 2017年1月6日
 */
@RestController
@RequestMapping(value = "/v1", produces = MediaType.TEXT_PLAIN_VALUE)
public class TempController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(TempController.class);
	
	@RequestMapping(value = "/temp", method = RequestMethod.GET)
	public String temp(@RequestParam String result, @RequestParam(required = false) String msg) {
		logger.info("result = {}, msg = {}", result, msg);
		return "accepted";
	}

    @Override
    protected String getName() {
        // TODO Auto-generated method stub
        return null;
    }

}
