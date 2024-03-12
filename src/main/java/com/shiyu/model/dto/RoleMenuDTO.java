package com.shiyu.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-20 13:47
 * @version:1.0
 */
@Data
public class RoleMenuDTO implements Serializable {

    private static final long serialVersionUID = 7267345971088252354L;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;
}
