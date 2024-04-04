package com.shiyu.utils.model;


import lombok.Getter;

/**
 * Http状态返回枚举
 **/
@Getter
public enum ResultEnum {
    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),
    /**
     * 校验失败
     */
    VALIDATE_FAIL(101, "校验失败"),
    /**
     * 数据不存在
     */
    DATA_MISSING(102, "数据不存在"),
    /**
     * 数据已存在
     */
    DATA_EXISTED(103, "数据已存在"),
    /**
     * 重定向
     */
    SEE_OTHER(303, "重定向"),
    /**
     * 请求错误
     */
    BAD_REQUEST(400, "请求错误"),
    /**
     * 无权限访问
     */
    UNAUTHORIZED(401, "无权限访问"),
    /**
     * 访问受限，授权过期
     */
    FORBIDDEN(403, "访问受限，授权过期"),
    /**
     * 资源，服务未找到
     */
    NOT_FOUND(404, "资源，服务未找！"),
    /**
     * 请求类型不支持
     */
    BAD_METHOD(405, "请求类型不支持"),
    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    BAD_PARAM(406, "参数列表错误（缺少，格式不匹配）"),
    /**
     * 请求超时
     */
    REQUEST_TIMEOUT(408, "请求超时"),
    /**
     * 重复提交
     */
    REPEAT_SUBMIT(409, "重复提交"),
    /**
     * 不支持的数据，媒体类型
     */
    UNSUPPORTED_TYPE(415, "不支持的数据，媒体类型"),
    /**
     * 系统内部错误
     */
    ERROR(500, "系统错误"),
    /**
     * 接口未实现
     */
    NOT_IMPLEMENTED(501, "接口未实现"),
    /**
     * 系统警告消息
     */
    WARN(601,"系统警告消息");

    private final Integer code;
    private final String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}