package com.shiyu.web.log.annotation;

import java.lang.annotation.*;
import com.shiyu.web.log.LogLevel;
/**
 * 接口日志打印注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {

    /**
     * 日志级别（默认debug级别；如果要覆盖全局配置，需要指定注解的日志级别）
     *
     * @return
     * @see LogLevel#getFinalLevel
     */
    String level() default "";

}
