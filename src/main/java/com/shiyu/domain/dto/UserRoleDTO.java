package com.shiyu.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-20 13:19
 * @version:1.0
 */
@Data
public class UserRoleDTO implements Serializable {

    private static final long serialVersionUID = -6274412259400095450L;
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;
}
