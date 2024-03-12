package com.shiyu.web.aspect;


import cn.hutool.core.date.StopWatch;
import cn.hutool.json.JSONUtil;
import com.shiyu.utils.LoggerUtil;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.ClassUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-24 20:49
 * @version:1.0
 */
@Aspect
@Component
public class WebLogAspect {


    @Around("execution(* com..controller..*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        //如果参数有HttpRequest,ServletResponse，直接移除，不打印这些
        List<Object> paramList = Stream.of(joinPoint.getArgs())
                .filter(args -> !(args instanceof ServletRequest))
                .filter(args -> !(args instanceof ServletResponse))
                .toList();
        StringBuilder strBuilder = new StringBuilder();
        paramList.forEach(param -> {
            if (Objects.isNull(param)){
                return;
            }
            if (ClassUtils.isPrimitiveWrapper(param.getClass())){
                strBuilder.append(param).append(";");
            }else {
                strBuilder.append(JSONUtil.toJsonStr(param)).append(";");
            }
        });
        LoggerUtil.WEB_LOGGER.info("method：{0}，uri：{1} param:{2}",method,uri,strBuilder.toString());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        long cost = stopWatch.getTotalTimeMillis();
        String printResultStr = JSONUtil.toJsonStr(result);
        LoggerUtil.WEB_LOGGER.info("uri：{0} result：{1} cost:{2}ms",uri, printResultStr, cost);
        return result;
    }

}
