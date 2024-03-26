package com.shiyu.infrastructure.model.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class User extends BasePO implements Serializable {
    private static final long serialVersionUID = -6268366220280617872L;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 头像
     */
    private String avatarUrl;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 地址
     */
    private String addr;
    /**
     * int	性别 0：保密 1：男 2：女
     */
    private Integer gender;
    /**
     * 密码
     */
    private String password;
    /**
     * 扩展信息
     */
    private String extInfo;
    /**
     * 0:活跃
     */
    private Integer status;
    /**
     * 0：删除 1：正常
     */
    private Integer delStatus;
}
