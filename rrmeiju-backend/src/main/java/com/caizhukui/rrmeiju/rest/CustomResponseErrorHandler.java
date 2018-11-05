package com.caizhukui.rrmeiju.rest;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import com.caizhukui.common.exception.RestException;

/**
 * RestTemplate在返回的HttpStatus不是2xx的情况下抛出RestClientException，
 * 导致取不到ResponseBody，要覆写ResponseErrorHandler接口
 * 
 * @author caizhukui
 * @date 2016年11月1日
 */
@Component
public class CustomResponseErrorHandler implements ResponseErrorHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomResponseErrorHandler.class);

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		HttpStatus httpStatus = response.getStatusCode();
		if (HttpStatus.OK.equals(httpStatus)) {
			return false;
		}
		return true;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		String body = IOUtils.toString(response.getBody(), "UTF-8");
		logger.info("handleError - body = {}", body);
		// RestErrorDTO restErrorDTO = convert(body, RestErrorDTO.class);
		throw new RestException();
	}

}
