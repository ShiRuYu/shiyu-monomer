package com.shiyu.infrastructure.model.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户角色关联(UserRole)表实体类
 *
 * @author shiyu
 * @since 2024-01-13 16:28:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class UserRole extends BasePO implements Serializable {

    private static final long serialVersionUID = 838221028765019863L;

    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 角色ID
     */
    private Long roleId;
    
    /**
     * 0：删除  1：正常  
     */
    private Integer delStatus;
}

