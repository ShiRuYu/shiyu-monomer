package com.shiyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shiyu.model.po.UserRole;

import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:29
 * @version:1.0
 */

public interface UserRoleMapper extends BaseMapper<UserRole> {
    int insertBatch(List<UserRole> userRoleList);
}
