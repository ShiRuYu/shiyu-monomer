package com.shiyu.web.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.shiyu.application.vo.UserVO;
import com.shiyu.domain.service.UserRoleService;
import com.shiyu.domain.service.UserService;
import com.shiyu.utils.model.Result;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("user")
@Validated
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private UserRoleService userRoleService;

    @GetMapping
    public Result<UserVO> view(@NotNull(message = "ID 必填") Long id) {
        UserVO shiYuUser = userService.selectById(id);
        StpUtil.login(shiYuUser.getId());
        return Result.success(shiYuUser);
    }

    // 测试登录  ---- http://localhost:8080/user/doLogin?name=zhang&pwd=123456
    @RequestMapping("doLogin")
    public SaResult doLogin(String name, String pwd) {
        UserVO userVO = userService.selectByPwd(name, pwd);
        if (!Objects.isNull(userVO)) {
            StpUtil.login(10001);
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }

    // 查询登录状态  ---- http://localhost:8080/user/isLogin
    @RequestMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ---- http://localhost:8080/user/tokenInfo
    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 注销  ---- http://localhost:8080/user/logout
    @RequestMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @PostMapping("role/add")
    public Result roleAdd(@RequestParam("userId") Long userId,
                          @RequestParam("roleIdList") List<Long> roleIdList) {
        userRoleService.add(userId,roleIdList);
        return Result.success("角色绑定完成");
    }

    @GetMapping("role/list")
    public Result userRole(Long userId) {
        return Result.success(userRoleService.roleListByUser(userId));
    }
}
