package com.maccura.global.exception;

import com.maccura.utils.ResultData;
import com.maccura.utils.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

/**
 * @author 7097
 */
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        log.info("全局异常处理---{}", Arrays.toString(e.getStackTrace()));
        return ResultData.fail(ReturnCode.RC500.getCode(),
                "错误位置：" + e.getStackTrace()[0].toString() + "-错误类型：" + e.getMessage());
    }

    /**
     * 参数验证出错
     * @param e 异常消息
     * @return ResultData
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exceptionsValidException(MethodArgumentNotValidException e){
        log.info("参数验证异常-->{}",e.getMessage());
        return ResultData.fail(ReturnCode.RC400.getCode(),
                "错误位置：" + e.getStackTrace()[0].toString() + "-错误类型：" + e.getMessage());
    }
}
