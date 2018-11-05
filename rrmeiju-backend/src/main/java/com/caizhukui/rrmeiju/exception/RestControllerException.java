package com.caizhukui.rrmeiju.exception;

import com.caizhukui.rrmeiju.dto.response.RestError;

import lombok.Getter;

/**
 * REST异常类
 * 
 * @author caizhukui
 * @date 2018年5月18日
 */
@Getter
public class RestControllerException extends RuntimeException {
    
    private static final long serialVersionUID = 3346770867269761317L;
    
    /** 封装好的REST异常信息 */
    private RestError restError;

    public RestControllerException(RestError restError) {
        this.restError = restError;
    }

}
