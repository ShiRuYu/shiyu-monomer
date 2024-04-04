package com.shiyu.domain.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.shiyu.domain.service.RoleService;
import com.shiyu.domain.service.UserRoleService;
import com.shiyu.infrastructure.mapper.UserRoleMapper;
import com.shiyu.infrastructure.model.UserRole;
import com.shiyu.application.vo.RoleVO;
import jakarta.annotation.Resource;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.baomidou.mybatisplus.extension.toolkit.Db.lambdaQuery;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:29
 * @version:1.0
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private RoleService roleService;

    @Override
    public void add(Long userId, List<Long> roleIdList) {
        List<UserRole> userRoleList = lambdaQuery(UserRole.class)
                .eq(UserRole::getUserId, userId)
                .list();

        List<UserRole> insertList = roleIdList.stream()
                .filter(roleId -> userRoleList.stream().noneMatch(ur -> ur.getRoleId().equals(roleId)))
                .map(roleId -> {
                    UserRole userRole = new UserRole();
                    userRole.setUserId(userId);
                    userRole.setRoleId(roleId);
                    return userRole;
                }).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(insertList)){
            userRoleMapper.insertBatch(insertList);
        }
    }

    @Override
    public List<RoleVO> roleListByUser(Long userId) {
        List<UserRole> userRoleList = lambdaQuery(UserRole.class)
                .eq(UserRole::getUserId, userId)
                .list();

        List<RoleVO> roleVOList = Lists.newArrayList();
        if (CollectionUtil.isNotEmpty(userRoleList)){
            List<Long> roleIdList = userRoleList.stream().map(UserRole::getRoleId)
                    .collect(Collectors.toList());
            roleVOList = roleService.selectByIdList(roleIdList);
        }
        return roleVOList;
    }
}
