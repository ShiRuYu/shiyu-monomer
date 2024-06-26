package com.shiyu.web.sotoken;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptors implements WebMvcConfigurer {
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，校验规则为 StpUtil.checkLogin() 登录校验。
        registry.addInterceptor(new SaInterceptor(handle -> {
                    // 指定一条 match 规则
                    SaRouter.match("/**")    // 拦截的 path 列表，可以写多个 */
                            .notMatch("/**")        // 排除掉的 path 列表，可以写多个
                            .check(r -> StpUtil.checkLogin());        // 要执行的校验动作，可以写完整的 lambda 表达式

                    // 根据路由划分模块，不同模块不同鉴权
                    //SaRouter.match("/role/**", r -> StpUtil.checkRole(RoleEnum.ADMIN.getCode()));
                    //SaRouter.match("/menu/**", r -> StpUtil.checkRole(RoleEnum.ADMIN.getCode()));
                }))
                .addPathPatterns("/**")
                .excludePathPatterns("/user/doLogin","/user/outLogin");
    }
}
