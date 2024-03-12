package com.shiyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shiyu.model.po.RoleMenu;

import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 15:36
 * @version:1.0
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    int insertBatch(List<RoleMenu> roleMenuList);

}

