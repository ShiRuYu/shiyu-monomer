package com.shiyu.utils;

import org.aspectj.weaver.tools.PointcutPrimitive;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 切面拦截器工具类
 */
public class AspectInterceptorUtil {

    private AspectInterceptorUtil() {
    }

    /**
     * 获取被注解标记的类切面表达式
     *
     * @param annotations
     * @return
     */
    public static String getTypeExpression(List<Class<? extends Annotation>> annotations) {
        return getAnnotationExpression(PointcutPrimitive.AT_WITHIN.getName(), annotations);
    }

    /**
     * 获取被注解标记的方法切面表达式
     *
     * @param annotations
     * @return
     */
    public static String getMethodExpression(List<Class<? extends Annotation>> annotations) {
        return getAnnotationExpression(PointcutPrimitive.AT_ANNOTATION.getName(), annotations);
    }

    /**
     * 获取接口注解
     *
     * @return
     */
    public static List<Class<? extends Annotation>> getApiAnnotations() {
        List<Class<? extends Annotation>> apiAnnotations = new ArrayList<>(8);
        apiAnnotations.add(RequestMapping.class);
        apiAnnotations.add(GetMapping.class);
        apiAnnotations.add(PostMapping.class);
        apiAnnotations.add(DeleteMapping.class);
        apiAnnotations.add(PutMapping.class);
        apiAnnotations.add(PatchMapping.class);
        return apiAnnotations;
    }

    /**
     * 获取接口切面表达式
     *
     * @param basePackages
     * @return
     */
    public static String getApiExpression(String[] basePackages) {
        return buildExpression(basePackages, getMethodExpression(getApiAnnotations()));
    }

    /**
     * 根据包名构建切面表达式
     *
     * @param basePackages
     * @return
     */
    public static String buildExpression(String[] basePackages) {
        StringBuilder executions = new StringBuilder();
        for (int i = 0; i < basePackages.length; i++) {
            executions.append(PointcutPrimitive.EXECUTION.getName()).append("( * " + basePackages[i] + "..*.*(..))");
            if (i != basePackages.length - 1) {
                executions.append(" || ");
            }
        }

        return executions.toString();
    }

    /**
     * 构建切面表达式
     *
     * @param basePackages
     * @return
     */
    public static String buildExpression(String[] basePackages, String expression) {
        return "(" + buildExpression(basePackages) + ") && (" + expression + ")";
    }

    /**
     * 获取被注解标记的方法切面表达式
     *
     * @param annotations
     * @return
     */
    private static String getAnnotationExpression(String annotationPointcut, List<Class<? extends Annotation>> annotations) {
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < annotations.size(); i++) {
            expression.append(annotationPointcut);
            expression.append("(" + annotations.get(i).getTypeName() + ")");
            if (i != annotations.size() - 1) {
                expression.append(" || ");
            }
        }
        return expression.toString();
    }

}