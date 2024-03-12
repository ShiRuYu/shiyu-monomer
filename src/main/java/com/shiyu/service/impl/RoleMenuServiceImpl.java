package com.shiyu.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.shiyu.mapper.RoleMenuMapper;
import com.shiyu.model.enums.RoleEnum;
import com.shiyu.model.po.Menu;
import com.shiyu.model.po.Role;
import com.shiyu.model.po.RoleMenu;
import com.shiyu.model.vo.MenuVO;
import com.shiyu.service.MenuService;
import com.shiyu.service.RoleMenuService;
import com.shiyu.service.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.baomidou.mybatisplus.extension.toolkit.Db.lambdaQuery;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:21
 * @version:1.0
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private MenuService menuService;
    @Resource
    private RoleService roleService;

    @Override
    public void add(Long roleId, List<Long> menuIdList) {

        List<RoleMenu> roleMenuList = lambdaQuery(RoleMenu.class)
                .eq(RoleMenu::getRoleId, roleId)
                .list();

        List<RoleMenu> insertList = menuIdList.stream()
                .filter(menuId -> roleMenuList.stream().noneMatch(ur -> ur.getMenuId().equals(menuId)))
                .map(menuId -> {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setRoleId(roleId);
                    roleMenu.setMenuId(menuId);
                    return roleMenu;
                }).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(insertList)) {
            roleMenuMapper.insertBatch(insertList);
        }
    }

    @Override
    public List<MenuVO> menuListByRole(Long roleId) {
        List<RoleMenu> roleMenuList = lambdaQuery(RoleMenu.class)
                .select(RoleMenu::getMenuId)
                .eq(RoleMenu::getRoleId, roleId)
                .list();
        List<Long> menuIdList = roleMenuList.stream()
                .map(RoleMenu::getMenuId).collect(Collectors.toList());
        return menuService.selectByIdList(menuIdList);
    }

    @Override
    public void superAdminMenu() {
        //超管角色
        Role superAdmin = lambdaQuery(Role.class)
                .eq(Role::getCode, RoleEnum.SUPER_ADMIN.getCode())
                .one();
        //超管已绑定菜单
        List<RoleMenu> roleMenuList = lambdaQuery(RoleMenu.class)
                .eq(RoleMenu::getRoleId, superAdmin.getId())
                .list();
        //超管已绑定菜单ID
        List<Long> addedMeunIdList = roleMenuList.stream().map(RoleMenu::getMenuId)
                .collect(Collectors.toList());
        //超管未绑定菜单
        List<Menu> menuList = lambdaQuery(Menu.class)
                .notIn(CollectionUtil.isNotEmpty(addedMeunIdList), Menu::getId, addedMeunIdList)
                .list();
        //超管未绑定菜单ID
        List<Long> addMenuIdList = menuList.stream().map(Menu::getId)
                .collect(Collectors.toList());

        List<RoleMenu> insertList = addMenuIdList.stream()
                .map(menuId -> {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setRoleId(superAdmin.getId());
                    roleMenu.setMenuId(menuId);
                    return roleMenu;
                }).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(insertList)) {
            roleMenuMapper.insertBatch(insertList);
        }
    }

    @Override
    public List<MenuVO> menuListByRoleIdList(List<Long> roleIdList) {
        List<RoleMenu> roleMenuList = lambdaQuery(RoleMenu.class)
                .select(RoleMenu::getMenuId)
                .in(RoleMenu::getRoleId, roleIdList)
                .list();
        List<Long> menuIdList = roleMenuList.stream()
                .map(RoleMenu::getMenuId).collect(Collectors.toList());
        return menuService.selectByIdList(menuIdList);
    }
}
