package com.shiyu.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 17:17
 * @version:1.0
 */
@Data
public class MenuDTO implements Serializable {

    private static final long serialVersionUID = -8282953290942235405L;


    /**
     * 上级id，根节点：0
     */
    @NotNull
    private Long parentId;

    /**
     * 菜单名
     */
    @NotNull
    @NotBlank
    private String name;

    /**
     * 类型(1:目录,2:菜单,3:按钮,4:状态)
     */
    @Range(min = 1,max = 4,message = "请正确选择状态")
    private Integer type;

    /**
     * 路径
     */
    @NotNull
    @NotBlank
    private String uri;

    /**
     * code
     */
    private String code;

    /**
     * 图标
     */
    private String icon;
}
