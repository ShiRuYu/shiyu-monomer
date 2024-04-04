package com.shiyu.web.controller;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-13 15:46
 * @version:1.0
 */

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyu.domain.dto.RoleDTO;
import com.shiyu.application.vo.RoleVO;
import com.shiyu.domain.service.RoleMenuService;
import com.shiyu.domain.service.RoleService;
import com.shiyu.utils.model.Result;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
@Validated
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private RoleMenuService roleMenuService;


    @PostMapping("add")
    public Result add(@Valid RoleDTO roleDTO) {
        roleService.add(roleDTO);
        return Result.success("角色添加成功");
    }

    @PostMapping("del")
    public Result del(@NotNull Long id) {
        roleService.del(id);
        return Result.success("角色删除成功");
    }

    @GetMapping("list")
    public Result<Page<RoleVO> > list(String name, Integer pageSize, Integer pageNum) {
        return Result.success(roleService.list(name,pageSize,pageNum));
    }

    @PostMapping("menu/add")
    public Result menuAdd(@RequestParam("roleId") Long roleId,
                          @RequestParam("menuIdList") List<Long> menuIdList) {
        roleMenuService.add(roleId,menuIdList);
        return Result.success("角色绑定完成");
    }
    @GetMapping("menu/list")
    public Result roleMenu(Long roleId) {
        return Result.success(roleMenuService.menuListByRole(roleId));
    }
    @PostMapping("menu/superAdmin")
    public Result superAdminMenu() {
        roleMenuService.superAdminMenu();
        return Result.success("超管权限刷新成功");
    }
}
