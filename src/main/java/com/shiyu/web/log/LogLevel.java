package com.shiyu.web.log;


/**
 * 日志级别
 */
public class LogLevel {

    /**
     * debug级别
     */
    public static final String DEBUG = "debug";

    /**
     * info级别
     */
    public static final String INFO = "info";

    /**
     * warn级别
     */
    public static final String WARN = "warn";

    private LogLevel() {
    }

    /**
     * 获取两个日志级别的最终结果
     *
     * @param annotationLevel 注解上面的日志级别
     * @param globalLevel     全局配置的日志级别
     * @return
     */
    public static final String getFinalLevel(String annotationLevel, String globalLevel) {
        if (annotationLevel != null && !"".equals(annotationLevel)) {
            return annotationLevel;
        }

        if (WARN.equals(annotationLevel) || WARN.equals(globalLevel)) {
            return WARN;
        }
        if (INFO.equals(annotationLevel) || INFO.equals(globalLevel)) {
            return INFO;
        }

        return DEBUG;
    }

}