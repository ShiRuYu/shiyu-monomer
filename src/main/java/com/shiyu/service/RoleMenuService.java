package com.shiyu.service;

import com.shiyu.model.vo.MenuVO;

import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:19
 * @version:1.0
 */

public interface RoleMenuService {
    void add(Long roleId, List<Long> menuIdList);

    List<MenuVO> menuListByRole(Long roleId);

    void superAdminMenu();

    List<MenuVO> menuListByRoleIdList(List<Long> roleIdList);
}
