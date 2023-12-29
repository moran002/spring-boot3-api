package com.moran.conf.exception;

import com.moran.conf.bean.RestResult;
import com.moran.conf.constant.CodeConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : 刘云
 * @date : 2021/7/14
 * 捕捉全局异常并统一处理
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public RestResult defaultErrorHandler(Exception e) {
        return RestResult.error(e.getMessage());
    }

    @ExceptionHandler(value = ServiceException.class)
    public RestResult serviceException(ServiceException e) {
        return RestResult.error(CodeConstant.SERVICE_ERROR, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public RestResult handleException(Exception e) {
        return RestResult.error(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public RestResult handleBindException(BindException e) {
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return RestResult.error(message);
    }

}