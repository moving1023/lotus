package org.liyl.lotus.exception;

import org.liyl.lotus.util.RestResp;
import org.liyl.lotus.util.RestRespUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理
 * 创建日期：2017-03-14
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理web异常
     */
    @ExceptionHandler(value = WebException.class)
    public RestResp handle(WebException webException) {
        return RestRespUtil.error(webException.getCode(), webException.getMessage());
    }

    /**
     * 处理web异常
     */
    @ExceptionHandler(value = BindException.class)
    public RestResp handle(BindException e) {
        logger.error("有字段传入的值出错=====================>", e);
        return RestRespUtil.error(ResultEnum.CODE_ERROR_UNKNOWN.getCode(), "有字段传入的值出错[" + e.getMessage().substring(0, e.getMessage().indexOf(";")) + "]");
    }

    /**
     * 请求方法异常
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public RestResp handle(HttpRequestMethodNotSupportedException e) {
        logger.error("请求方法错误=====================>", e);
        return RestRespUtil.error(ResultEnum.CODE_ERROR_UNKNOWN);
    }

    /**
     * 请求参数异常
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public RestResp handle(MissingServletRequestParameterException e) {
        logger.error("请求参数错误=====================>", e);
        return RestRespUtil.error(ResultEnum.CODE_ERROR_UNKNOWN);
    }

    /**
     * 所有异常
     */
    @ExceptionHandler(value = Exception.class)
    public RestResp handle(Exception e) {
        logger.error("出现异常=====================>", e);
        return RestRespUtil.error(ResultEnum.CODE_ERROR_UNKNOWN.getCode(), ResultEnum.CODE_ERROR_UNKNOWN.getMsg());
    }
}
