package com.shiyu.web.sotoken;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import com.shiyu.application.vo.MenuVO;
import com.shiyu.application.vo.RoleVO;
import com.shiyu.domain.service.RoleMenuService;
import com.shiyu.domain.service.UserRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限加载接口实现类
 * 保证此类被 SpringBoot 扫描，完成 Sa-Token 的自定义权限验证扩展
 */
@Component
public class StpInterfaceImpl implements StpInterface {
    private UserRoleService userRoleService;
    @Resource
    private RoleMenuService roleMenuService;

    /**
     * 返回一个账号所拥有的权限码(uri)集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> result = Lists.newArrayList();

        List<RoleVO> roleVOList = userRoleService.roleListByUser((Long) loginId);
        if (CollectionUtil.isNotEmpty(roleVOList)){
            List<Long> roleIdList = roleVOList.stream().map(RoleVO::getId).collect(Collectors.toList());
            List<MenuVO> menuVOS = roleMenuService.menuListByRoleIdList(roleIdList);
            if (CollectionUtil.isNotEmpty(menuVOS)){
                result = menuVOS.stream().map(MenuVO::getUri)
                        .collect(Collectors.toList());
            }
        }
        return result;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<RoleVO> roleVOList = userRoleService.roleListByUser((Long) loginId);
        if (CollectionUtil.isNotEmpty(roleVOList)){
            return roleVOList.stream().map(RoleVO::getCode)
                    .collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

}

