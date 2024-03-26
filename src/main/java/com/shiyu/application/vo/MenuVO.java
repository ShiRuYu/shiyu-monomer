package com.shiyu.application.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:39
 * @version:1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MenuVO extends BaseVO implements Serializable {
    private static final long serialVersionUID = 4651956112882246123L;

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
     * 图标
     */
    private List<MenuVO> childMenu;
}
