package com.shiyu.utils;

/**
 * @description:
 * @author:shiyu
 * @create: 2024-01-20 13:15
 * @version:1.0
 */

import com.shiyu.utils.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collection;

public class AssertUtils {

    /**
     * 判断对象是非空，如果对象是空，就抛异常
     *
     * @param object       判断对象
     * @param errorMessage 异常提示信息
     */
    public static void notNull(@Nullable Object object, String errorMessage) {
        if (null != object) {
            throw new BusinessException(errorMessage);
        }
    }

    /**
     * 判读对象是不是空，如果是非空，就抛异常
     *
     * @param object       判断对象
     * @param errorMessage 异常提示信息
     */
    public static void isNull(@Nullable Object object, String errorMessage) {
        if (null != object) {
            throw new BusinessException(errorMessage);
        }
    }

    /**
     * 判断是否是真，如果对象是false，就抛出异常
     *
     * @param expression   判断对象
     * @param errorMessage 异常提示信息
     */
    public static void isTrue(boolean expression, String errorMessage) {
        if (!expression) {
            throw new BusinessException(errorMessage);
        }
    }

    /**
     * 判断是否是真，如果对象是false，就抛出异常。
     *
     * @param expression   判断对象
     * @param errorMessage 异常提示信息
     */
    public static void isTrue(Boolean expression, String errorMessage) {
        if (Boolean.FALSE.equals(expression)) {
            throw new BusinessException(errorMessage);
        }
    }

    /**
     * 判断集合是否有数据，如果没有数据，就抛出异常。
     *
     * @param collection   集合对象
     * @param errorMessage 错误提示信息
     */
    public static void notEmpty(@Nullable Collection<?> collection, String errorMessage) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(errorMessage);
        }
    }

    /**
     * 判断集合是否有数据，如果没有数据，就抛出异常。 这里利用的是Spring自带的工具
     *
     * @param array        数组对象
     * @param errorMessage 错误提示信息
     */
    public static void notEmpty(@Nullable Object[] array, String errorMessage) {
        if (ObjectUtils.isEmpty(array)) {
            throw new BusinessException(errorMessage);
        }
    }

    /**
     * 判断字符串是否有效是真实的且非空格，如果无法满足，就抛出异常。 这里利用的是org.apache.commons.lang3的二次封装。
     *
     * @param word         数组对象
     * @param errorMessage 错误提示信息
     */
    public static void isNotBlank(String word, String errorMessage) {
        /**
         *   StringUtils.isBlank(null)      = true
         *   StringUtils.isBlank("")        = true
         *   StringUtils.isBlank(" ")       = true
         *   StringUtils.isBlank("bob")     = false
         *   StringUtils.isBlank("  bob  ") = false
         */
        if (StringUtils.isBlank(word)) {
            throw new BusinessException(errorMessage);
        }
    }
}
