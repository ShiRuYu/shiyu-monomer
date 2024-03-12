package com.shiyu.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-20 11:26
 * @version:1.0
 */
@Data
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = -3302102506868479277L;

    /**
     * 角色名
     */
    @NotNull(message = "不能为null")
    @NotBlank(message = "不能为空字符串")
    private String name;

    /**
     * code
     */
    @NotNull(message = "不能为null")
    @NotBlank(message = "不能为空字符串")
    private String code;
}
