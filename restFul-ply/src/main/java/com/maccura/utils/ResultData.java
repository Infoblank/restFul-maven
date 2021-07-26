package com.maccura.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 7097
 */
@Getter
@Setter
@ToString
public class ResultData<T> {
    private int status;
    private String message;
    private T data;
    private long timestamp;
    private String path;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data) {
        ResultData<T> tResultData = new ResultData<>();
        tResultData.setStatus(ReturnCode.RC100.getCode());
        tResultData.setMessage(ReturnCode.RC100.getMessage());
        tResultData.setData(data);
        tResultData.setPath(ResultData.getResultDataPath());
        return tResultData;
    }

    public static <T> ResultData<T> fail(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        resultData.setPath(ResultData.getResultDataPath());
        return resultData;
    }

    private static String getResultDataPath() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        return "https://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();
    }
}
