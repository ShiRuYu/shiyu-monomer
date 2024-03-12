package com.shiyu.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseVO implements Serializable {
    private static final long serialVersionUID = 6370347720627112897L;
    /**
     * ID
     */
    private Long id;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
}
