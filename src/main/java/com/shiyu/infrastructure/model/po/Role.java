package com.shiyu.infrastructure.model.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 角色(Role)表实体类
 *
 * @author shiyu
 * @since 2024-01-13 15:27:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Role extends BasePO implements Serializable {

    private static final long serialVersionUID = -58561680146804391L;

    /**
     * 角色名
     */
    private String name;
    
    /**
     * code
     */
    private String code;
    
    /**
     * 0：正常  
     */
    private Integer status;
    
    /**
     * 0：删除  1：正常  
     */
    private Integer delStatus;
}

