package com.shiyu.service;

import com.shiyu.model.vo.RoleVO;

import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:29
 * @version:1.0
 */

public interface UserRoleService {
    void add(Long userId, List<Long> roleIdList);

    List<RoleVO> roleListByUser(Long userId);
}
