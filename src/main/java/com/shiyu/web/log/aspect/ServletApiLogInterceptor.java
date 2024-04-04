package com.shiyu.web.log.aspect;

import com.shiyu.utils.jacksonUtil.MessageMaskJacksonUtil;
import com.shiyu.utils.model.OrderedConstant;
import com.shiyu.web.log.annotation.ApiLog;
import com.shiyu.web.log.LogAspect;
import com.shiyu.web.log.LogLevel;
import com.shiyu.web.utils.WebServletUtil;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.InputStreamSource;
import org.springframework.validation.DataBinder;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 接口日志切面
 */
@Slf4j
@RequiredArgsConstructor
public class ServletApiLogInterceptor implements MethodInterceptor, Ordered {

    //慢接口时间（单位：毫秒，默认 3000 毫秒）
    private final Long slowApiMinCost = 3000L;
    //默认日志级别
    private final String level = LogLevel.DEBUG;
    /**
     * 慢日志
     */
    private static final String SLOW_LOG_PATTERN = "api.slow=>{}";
    /**
     * 普通日志
     */
    private static final String LOG_PATTERN = "api.log=>{}";
    /**
     * 错误日志
     */
    private static final String ERROR_LOG_PATTERN = "api.error=>{}";

    @Override
    public int getOrder() {
        return OrderedConstant.API_LOG;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (RequestContextHolder.getRequestAttributes() == null) {
            return invocation.proceed();
        }

        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = invocation.proceed();
            if (log.isWarnEnabled()) {
                long cost = System.currentTimeMillis() - startTime;
                if (cost >= slowApiMinCost) {
                    log.warn(MessageMaskJacksonUtil.truncate(SLOW_LOG_PATTERN, buildLogAspectDO(invocation.getArguments(), result, cost)));
                } else {
                    ApiLog apiLog = invocation.getMethod().getAnnotation(ApiLog.class);
                    String logLevel = LogLevel.getFinalLevel((apiLog == null ? null : apiLog.level()), level);
                    if (LogLevel.DEBUG.equals(logLevel) && log.isDebugEnabled()) {
                        log.debug(MessageMaskJacksonUtil.truncate(LOG_PATTERN, buildLogAspectDO(invocation.getArguments(), result, cost)));
                    } else if (LogLevel.INFO.equals(logLevel) && log.isInfoEnabled()) {
                        log.info(MessageMaskJacksonUtil.truncate(LOG_PATTERN, buildLogAspectDO(invocation.getArguments(), result, cost)));
                    } else if (LogLevel.WARN.equals(logLevel)) {
                        log.warn(MessageMaskJacksonUtil.truncate(LOG_PATTERN, buildLogAspectDO(invocation.getArguments(), result, cost)));
                    }
                }
            }
            return result;
        } catch (Exception e) {
            long cost = System.currentTimeMillis() - startTime;
            log.error(MessageMaskJacksonUtil.truncate(ERROR_LOG_PATTERN, buildLogAspectDO(invocation.getArguments(), result, cost)), e);
            throw e;
        }
    }

    private LogAspect buildLogAspectDO(Object[] args, Object result, long cost) {
        HttpServletRequest request = WebServletUtil.getHttpServletRequest();
        return LogAspect.builder()
                .url(request.getPathInfo())
                .method(request.getMethod())
                .head(getHeaders(request))
                .args(getRequestArgs(args))
                .cost(cost)
                .result(result)
                .build();
    }

    /**
     * 获取http header部分数据
     *
     * @param request
     * @return
     */
    private Map<String, String> getHeaders(HttpServletRequest request) {
        Enumeration<String> enumerations = request.getHeaderNames();
        if (enumerations == null) {
            return null;
        }

        Map<String, String> headers = new HashMap<>(8);
        while (enumerations.hasMoreElements()) {
            String name = enumerations.nextElement();
            headers.put(name, request.getHeader(name));
        }

        return headers;
    }


    /**
     * 获取有效的请求参数（过滤掉不能序列化的）
     *
     * @param args
     * @return
     */
    private static Object getRequestArgs(Object[] args) {
        if (ArrayUtils.isEmpty(args)) {
            return args;
        }

        return Stream.of(args).filter(arg -> !needFilter(arg)).toArray();
    }

    /**
     * 是否需要过滤
     *
     * @param object
     * @return
     */
    private static boolean needFilter(Object object) {
        return object instanceof ServletRequest || object instanceof ServletResponse || object instanceof DataBinder || object instanceof InputStreamSource;
    }

}