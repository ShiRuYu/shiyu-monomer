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
     * 重定向
     */
    SEE_OTHER(303, "重定向"),
    /**
     * 请求错误
     */
    BAD_REQUEST(400, "请求错误"),
    /**
     * 未授权
     */
    UNAUTHORIZED(401, "未授权"),
    /**
     * 访问受限，授权过期
     */
    FORBIDDEN(403, "访问受限，授权过期"),
    /**
     * 资源，服务未找到
     */
    NOT_FOUND(404, "资源，服务未找！"),
    /**
     * 不允许的http方法
     */
    BAD_METHOD(405, "不允许的http方法"),
    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    BAD_PARAM(406, "参数列表错误（缺少，格式不匹配）"),
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