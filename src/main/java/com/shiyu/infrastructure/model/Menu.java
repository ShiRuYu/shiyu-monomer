package com.shiyu.infrastructure.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * 菜单(Menu)表实体类
 *
 * @author shiyu
 * @since 2024-01-13 15:25:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Menu extends BasePO implements Serializable {

    @Serial
    private static final long serialVersionUID = -50706392183930184L;
    
    /**
     * 上级id，根节点：0
     */
    private Long parentId;
    
    /**
     * 菜单名
     */
    private String name;
    
    /**
     * 类型(1:目录,2:菜单,3:按钮,4:状态)
     */
    private Integer type;
    
    /**
     * 路径
     */
    private String uri;
    
    /**
     * code
     */
    private String code;
    
    /**
     * 图标
     */
    private String icon;
    
    /**
     * 0：正常  
     */
    private Integer status;
    
    /**
     * 0：删除  1：正常  
     */
    private Integer delStatus;
}

