package com.shiyu.application.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:41
 * @version:1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = -8029163962416588819L;

    /**
     * 角色名
     */
    private String name;

    /**
     * code
     */
    private String code;

}
