package com.shiyu.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyu.domain.service.RoleService;
import com.shiyu.infrastructure.mapper.RoleMapper;
import com.shiyu.application.convert.RoleConvertMapper;
import com.shiyu.domain.dto.RoleDTO;
import com.shiyu.infrastructure.model.po.Role;
import com.shiyu.application.vo.RoleVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.baomidou.mybatisplus.extension.toolkit.Db.*;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:11
 * @version:1.0
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleConvertMapper roleConvertMapper;

    @Override
    public void add(RoleDTO roleDTO) {
        saveOrUpdate(roleConvertMapper.DTOtoPo(roleDTO));
    }

    @Override
    public void del(Long id) {
        removeById(id, Role.class);
    }

    @Override
    public Page<RoleVO> list(String name, Integer pageSize, Integer pageNum) {
        pageNum = pageNum == 0 ? 1 : pageNum;
        pageSize = pageSize == 0 ? 10 : pageSize;
        Page page = new Page<>(pageSize, pageNum);
        page = lambdaQuery(Role.class)
                .like(ObjectUtil.isNotNull(name), Role::getName, name)
                .page(page);
        List<RoleVO> roleVOList = roleConvertMapper.toVOList(page.getRecords());
        page.setRecords(roleVOList);
        return page;
    }

    @Override
    public List<RoleVO> selectByIdList(List<Long> roleIdList) {
        List<Role> roleList = lambdaQuery(Role.class)
                .in(Role::getId, roleIdList)
                .list();
        return roleConvertMapper.toVOList(roleList);
    }
}
