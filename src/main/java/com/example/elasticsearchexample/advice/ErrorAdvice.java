package com.example.elasticsearchexample.advice;

import com.example.elasticsearchexample.service.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuzhuang on 2018/7/28.
 */
@ControllerAdvice("com.example.elasticsearchexample.controller")
public class ErrorAdvice {
    private Logger log = LoggerFactory.getLogger(ErrorAdvice.class);

    @ExceptionHandler
    @ResponseBody
    public String exceptionHandler(Exception e) {
        log.info("ErrorAdvice Exception", e);
        if (e instanceof BizException) {
            return e.getMessage();
        }
        return "error";
    }
}
