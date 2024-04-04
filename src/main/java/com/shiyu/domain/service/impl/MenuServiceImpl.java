package com.shiyu.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyu.domain.dto.MenuDTO;
import com.shiyu.domain.service.MenuService;
import com.shiyu.infrastructure.mapper.MenuMapper;
import com.shiyu.application.convert.MenuConvertMapper;
import com.shiyu.infrastructure.model.Menu;
import com.shiyu.application.vo.MenuVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.baomidou.mybatisplus.extension.toolkit.Db.lambdaQuery;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:20
 * @version:1.0
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private MenuConvertMapper menuConvertMapper;

    @Override
    public void addMenu(MenuDTO menuDTO) {
        menuMapper.insert(menuConvertMapper.DTOtoPo(menuDTO));
    }

    @Override
    public void delMenu(Long id) {
        menuMapper.deleteById(id);
    }

    @Override
    public Page<MenuVO> list(String name, Integer pageSize, Integer pageNum) {
        pageNum = pageNum == 0 ? 1 : pageNum;
        pageSize = pageSize == 0 ? 10 : pageSize;
        Page page = new Page<>(pageSize, pageNum);
        page = lambdaQuery(Menu.class)
                .like(ObjectUtil.isNotNull(name), Menu::getName, name)
                .page(page);
        List<MenuVO> menuVOList = menuConvertMapper.toVoList(page.getRecords());
        page.setRecords(menuVOList);

        return page;
    }

    @Override
    public List<MenuVO> listTree() {
        List<Menu> listMenu = lambdaQuery(Menu.class).list();
        List<MenuVO> menuVOList = menuConvertMapper.toVoList(listMenu);
        return toTree(menuVOList);
    }

    @Override
    public List<MenuVO> selectByIdList(List<Long> menuIdList) {
        List<Menu> menuList = lambdaQuery(Menu.class)
                .in(Menu::getId, menuIdList)
                .list();
        List<MenuVO> voList = menuConvertMapper.toVoList(menuList);
        return toTree(voList);
    }


    private List<MenuVO> toTree(List<MenuVO> menuVOList) {
        return menuVOList.stream().filter(menu -> menu.getParentId().longValue() == 0L)
                .map(parent -> {
                    parent.setChildMenu(setChild(parent, menuVOList));
                    return parent;
                })
                .collect(Collectors.toList());
    }

    private List<MenuVO> setChild(MenuVO parent, List<MenuVO> listMenuVO) {
        return listMenuVO.stream().filter(menu -> menu.getParentId().longValue() == parent.getId().longValue())
                .map(menu -> {
                    menu.setChildMenu(setChild(menu, listMenuVO));
                    return menu;
                })
                .collect(Collectors.toList());
    }
}
