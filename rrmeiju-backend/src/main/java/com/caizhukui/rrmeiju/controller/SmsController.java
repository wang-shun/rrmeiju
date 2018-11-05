package com.caizhukui.rrmeiju.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caizhukui.common.util.IpUtils;
import com.caizhukui.common.util.MobileUtils;
import com.caizhukui.common.util.UuidUtils;
import com.caizhukui.rrmeiju.dto.response.BooleanDTO;
import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.exception.RestControllerException;
import com.caizhukui.rrmeiju.model.SmsSendRecord;
import com.caizhukui.rrmeiju.redis.RedisService;

/**
 * 短信服务
 * 
 * @author caizhukui
 * @date 2016年10月27日
 */
@RestController
@RequestMapping(value = "/v1", produces = APPLICATION_JSON_UTF8_VALUE)
public class SmsController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(SmsController.class);
	
	@Resource
	private RedisService redisService;
	
	/**
	 * 发送短信验证码
	 * 
	 * @param mobileNumber 手机号
	 * @param signName 阿里大于后台已通过审核的签名名称
	 * @param templateCode 阿里大于后台已通过审核的短信模板ID
	 * @author caizhukui
	 * @date 2016年10月27日
	 */
	@RequestMapping(value = "/sms/captcha", method = GET)
	public void sendSms(@RequestParam String mobileNumber, 
			@RequestParam String signName,
			@RequestParam String templateCode, HttpServletRequest request) {
		logger.info("sendSms - mobileNumber = {}, signName = {}, templateCode = {}", mobileNumber, signName, templateCode);
		// 校验手机号格式
		if (!MobileUtils.isValidMobile(mobileNumber)) {
			throw new RestControllerException(RestError.PARAMETER_ERROR.setMessage("请输入正确的手机号"));
		}
		// 校验手机号是否已被注册
		boolean isExist = serviceFacade.getUserService().isMobileNumberExist(mobileNumber);
		if (isExist) {
			throw new RestControllerException(RestError.CONFLICT.setMessage("该手机号已被使用，请使用其它手机号注册"));
		}
		// 校验手机号发送是否超限（每个IP一天最多发送5条，一天给一个手机号最多发送5条）
		String remoteIp = IpUtils.getRemoteIp(request);
		boolean isRestricted = serviceFacade.getSmsSendRecordService().isRestricted(mobileNumber, remoteIp);
		if (isRestricted) {
			throw new RestControllerException(RestError.PARAMETER_ERROR.setMessage("短信发送次数超限"));
		}
		String urlDecodedSignName = signName;
		try {
			urlDecodedSignName = URLDecoder.decode(signName, "UTF-8");
		} catch (UnsupportedEncodingException ignore) {}
		logger.info("sendSms - urlDecodedSignName = {}", urlDecodedSignName);
		// 取当前时间戳的后6位作为验证码
		String captcha = String.valueOf(System.currentTimeMillis()).substring(7);
		logger.info("sendSms - 发送到手机号 {} 的验证码是 {}", mobileNumber, captcha);
		// 保存验证码到Redis，有效期5分钟
		redisService.set(mobileNumber, captcha, 5, TimeUnit.MINUTES);
		Map<String, String> params = new HashMap<String, String>();
		params.put("captcha", captcha);
		commonServiceFacade.getSmsService().sendSms(mobileNumber, urlDecodedSignName, templateCode, params);
		// 保存短信发送记录
		SmsSendRecord record = new SmsSendRecord();
		record.setUuid(UuidUtils.getUuid());
		record.setMobileNumber(mobileNumber);
		record.setRemoteIp(remoteIp);
		record.setType(1);
		serviceFacade.getSmsSendRecordService().add(record);
	}
	
	/**
	 * 校验短信验证码
	 * 
	 * @param mobileNumber 手机号
	 * @param captcha 验证码
	 * @return BooleanDTO 校验结果
	 * @author caizhukui
	 * @date 2016年10月27日
	 */
	@RequestMapping(value = "/captcha", method = GET)
	public BooleanDTO validateCaptcha(@RequestParam String mobileNumber, @RequestParam String captcha) {
		logger.info("validateCaptcha - mobileNumber = {}, captcha = {}", mobileNumber, captcha);
		BooleanDTO booleanDTO = new BooleanDTO();
		String savedCaptcha = (String) redisService.get(mobileNumber);
		if (captcha != null && captcha.equals(savedCaptcha)) {
			booleanDTO.setResult(true);
		}
		return booleanDTO;
	}

    @Override
    protected String getName() {
        return "短信";
    }

}
