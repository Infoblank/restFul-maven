package com.maccura.global;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maccura.utils.ResultData;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author 7097
 * 对全局返回对象做处理 Parameter info (within method call arguments)
 */
@RestControllerAdvice
public class GlobalResponse implements ResponseBodyAdvice<Object> {
    private final ObjectMapper objectMapper;

    @Autowired
    public GlobalResponse(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(@NotNull MethodParameter methodParameter, @NotNull Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 当o是String时是前端的页面地址，为ResultData为api返回的数据，其它情况统一封装
     *  在写出返回消息前做处理
     * @param o                  当前返回前端得数据
     * @param methodParameter    方法得参数
     * @param mediaType          元数据得类型  动漫
     * @param aClass             类对象
     * @param serverHttpRequest  http请求对象
     * @param serverHttpResponse http返回对象
     */
    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, @NotNull MethodParameter methodParameter,
                                  @NotNull MediaType mediaType, @NotNull Class<? extends HttpMessageConverter<?>> aClass,
                                  @NotNull ServerHttpRequest serverHttpRequest, @NotNull ServerHttpResponse serverHttpResponse) {
        if (o instanceof String) {
            return objectMapper.writeValueAsString(o);
        }
        if (o instanceof ResultData) {
            return o;
        }
        return ResultData.success(o);
    }
}
