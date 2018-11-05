package com.caizhukui.rrmeiju.controller.util;

import java.util.Collection;
import java.util.List;

import com.caizhukui.rrmeiju.dto.response.RestError;
import com.caizhukui.rrmeiju.exception.RestControllerException;

/**
 * 
 * 
 * @author caizhukui
 * @date 2018年5月23日
 */
public class Assert {
    
    /**
     * 
     * 
     * @param expression
     * @param restError
     * @param details
     * @author caizhukui
     * @date 2018年5月23日
     */
    public static void isTrue(boolean expression, RestError restError, List<String> details) {
        RuntimeException exception = new RestControllerException(restError.setDetails(details));
        com.caizhukui.common.util.Assert.isTrue(expression, exception);
    }
    
    /**
     * 
     * 
     * @param expression
     * @param restError
     * @param details
     * @author caizhukui
     * @date 2018年5月23日
     */
    public static void isFalse(boolean expression, RestError restError, List<String> details) {
        RuntimeException exception = new RestControllerException(restError.setDetails(details));
        com.caizhukui.common.util.Assert.isFalse(expression, exception);
    }
    
    /**
     * 
     * 
     * @param object
     * @param restError
     * @param detail
     * @throws RestControllerException
     * @author caizhukui
     * @date 2018年5月23日
     */
    public static void notNull(Object object, RestError restError, String detail) {
        RuntimeException exception = new RestControllerException(restError.setDetail(detail));
        com.caizhukui.common.util.Assert.notNull(object, exception);
    }
    
    /**
     * 
     * 
     * @param object
     * @param restError
     * @param details
     * @throws RestControllerException
     * @author caizhukui
     * @date 2018年5月23日
     */
    public static void notNull(Object object, RestError restError, List<String> details) {
        RuntimeException exception = new RestControllerException(restError.setDetails(details));
        com.caizhukui.common.util.Assert.notNull(object, exception);
    }
    
    /**
     * 
     * 
     * @param coll
     * @param restError
     * @param details
     * @author caizhukui
     * @date 2018年5月26日
     */
    public static void notEmpty(Collection<?> coll, RestError restError, String detail) {
        RuntimeException exception = new RestControllerException(restError.setDetail(detail));
        com.caizhukui.common.util.Assert.notEmpty(coll, exception);
    }
    
    /**
     * 
     * 
     * @param uuid
     * @param restError
     * @param detail
     * @author caizhukui
     * @date 2018年5月25日
     */
    public static void isUuid(String uuid, RestError restError, String detail) {
        RuntimeException exception = new RestControllerException(restError.setDetail(detail));
        com.caizhukui.common.util.Assert.isUuid(uuid, exception);
    }

}
