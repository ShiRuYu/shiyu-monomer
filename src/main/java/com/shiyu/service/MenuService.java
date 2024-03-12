package com.shiyu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyu.model.dto.MenuDTO;
import com.shiyu.model.vo.MenuVO;

import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:19
 * @version:1.0
 */

public interface MenuService {
    /**
     * @author shiyu
     * @description // 添加菜单
     * @create 2024/1/13 16:33
     * @param menuDTO
     * @return
     **/
    void addMenu(MenuDTO menuDTO);
    /**
     * @author shiyu
     * @description // 删除菜单
     * @create 2024/1/13 16:34
     * @param id
     * @return
     **/
    void delMenu(Long id);
    /**
     * @param
     * @return
     * @author shiyu
     * @description // 菜单列表
     * @create 2024/1/13 16:52
     **/
    Page<MenuVO> list(String name, Integer pageSize, Integer pageNum);

    /**
     * 树形列表
     * @return
     */
    List<MenuVO> listTree();

    List<MenuVO> selectByIdList(List<Long> menuIdList);
}
