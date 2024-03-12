package com.shiyu.model.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 菜单角色关联(RoleMenu)表实体类
 *
 * @author shiyu
 * @since 2024-01-13 15:27:59
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class RoleMenu extends BasePO implements Serializable {

    private static final long serialVersionUID = 479366146899215994L;

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;
    
    /**
     * 0：删除  1：正常  
     */
    private Integer delStatus;
}

