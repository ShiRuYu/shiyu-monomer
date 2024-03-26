package com.shiyu.domain.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyu.domain.dto.RoleDTO;
import com.shiyu.application.vo.RoleVO;

import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 15:45
 * @version:1.0
 */

public interface RoleService {
    void add(RoleDTO roleDTO);

    void del(Long id);

    Page<RoleVO> list(String name, Integer pageSize, Integer pageNum);

    List<RoleVO> selectByIdList(List<Long> roleIdList);
}
