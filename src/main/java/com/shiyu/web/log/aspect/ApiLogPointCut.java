package com.shiyu.web.log.aspect;

import com.shiyu.utils.AspectInterceptorUtil;
import com.shiyu.web.log.annotation.ApiLog;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

/**
 * 日志切面点
 */
public class ApiLogPointCut extends StaticMethodMatcherPointcut {

    private final AspectJExpressionPointcut packageExpressionPointcut;

    public ApiLogPointCut() {
        packageExpressionPointcut = new AspectJExpressionPointcut();
        packageExpressionPointcut.setExpression(AspectInterceptorUtil.buildExpression(new String[]{"切面路径"}));
    }

    @Override
    public boolean matches(Method method, Class<?> c) {
        return  // package是否匹配
                packageExpressionPointcut.matches(method, c) &&
                        // 类
                        (c != null && (c.isAnnotationPresent(RestController.class) || c.isAnnotationPresent(Controller.class))) &&
                        // 方法
                        (AnnotatedElementUtils.hasAnnotation(method, RequestMapping.class)
                                || AnnotatedElementUtils.hasAnnotation(method, GetMapping.class)
                                || AnnotatedElementUtils.hasAnnotation(method, PostMapping.class)
                                || AnnotatedElementUtils.hasAnnotation(method, DeleteMapping.class)
                                || AnnotatedElementUtils.hasAnnotation(method, PutMapping.class)
                                || AnnotatedElementUtils.hasAnnotation(method, PatchMapping.class)
                                || AnnotatedElementUtils.hasAnnotation(method, ApiLog.class));
    }

}