package com.shiyu.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-20 13:21
 * @version:1.0
 */

@Getter
@AllArgsConstructor
public enum DataDelStatusEnum {
    NORMAL(1,"正常"),DELETE(0,"删除");
    private final Integer code;
    private final String desc;
}
