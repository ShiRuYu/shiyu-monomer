package com.shiyu.interfaces.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyu.domain.dto.MenuDTO;
import com.shiyu.application.vo.MenuVO;
import com.shiyu.domain.service.MenuService;
import com.shiyu.utils.model.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 16:22
 * @version:1.0
 */

@RestController
@RequestMapping("menu")
@Validated
public class MenuController {
    @Resource
    private MenuService menuService;

    @PostMapping("add")
    public Result add(@Valid MenuDTO menuDTO) {
        menuService.addMenu(menuDTO);
        return Result.success("菜单添加成功");
    }

    @PostMapping("del")
    public Result del(@NotNull Long id) {
        menuService.delMenu(id);
        return Result.success("菜单删除成功");
    }

    @GetMapping("list")
    public Result<Page<MenuVO>> list(String name, Integer pageSize, Integer pageNum) {
        return Result.success(menuService.list(name,pageSize,pageNum));
    }
    @GetMapping("list/tree")
    public Result<List<MenuVO>> listTree() {
        return Result.success(menuService.listTree());
    }
}