package com.maccura.global.exception;

import com.maccura.utils.ResultData;
import com.maccura.utils.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

/**
 * @author 7097
 */
@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        log.info("全局异常处理---{}", Arrays.toString(e.getStackTrace()));
        return  ResultData.fail(ReturnCode.RC500.getCode(), "错误位置：" + e.getStackTrace()[0].toString() + "-错误类型：" + e.getMessage());
    }
}
