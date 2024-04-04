package com.shiyu.web.log;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 普通接口切面日志DO
 */
@Getter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"url", "method", "cost", "head", "queryParams", "args", "result"})
public class LogAspect implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求路径
     */
    private String url;
    /**
     * http请求方式
     */
    private String method;
    /**
     * 花费时间（毫秒）
     */
    private Long cost;
    /**
     * http头部数据
     */
    private Object head;
    /**
     * url参数
     */
    private String queryParams;
    /**
     * body部分请求体参数
     */
    private Object args;
    /**
     * 请求结果
     */
    private Object result;

}