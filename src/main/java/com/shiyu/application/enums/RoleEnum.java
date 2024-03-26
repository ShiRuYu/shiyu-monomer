package com.shiyu.application.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-21 13:36
 * @version:1.0
 */
@Getter
@AllArgsConstructor
public enum RoleEnum {
    SUPER_ADMIN("superAdmin"),
    ADMIN("admin"),
    USER("user"),
    VISITOR("visitor");
    private final String code;
}
