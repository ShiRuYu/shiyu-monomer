package com.shiyu.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.shiyu.utils.exception.ValidatorException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import jakarta.validation.groups.Default;
import org.hibernate.validator.HibernateValidator;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 校验工具
 * Hibernate Validator有以下两种验证模式：
 * 1 、普通模式（默认是这个模式）
 * <p>
 * 　　普通模式(会校验完所有的属性，然后返回所有的验证失败信息)
 * <p>
 * 2、快速失败返回模式
 * <p>
 * 　　快速失败返回模式(只要有一个验证失败，则返回)
 * <p>
 * 默认是普通模式
 */
public class ValidatorUtils {

    /**
     * 校验工厂
     */
    private static final ValidatorFactory NORMAL_VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();

    /**
     * 开启快速结束模式 failFast (true)
     */
    private static final ValidatorFactory FAST_VALIDATOR_FACTORY = Validation.byProvider(HibernateValidator.class)
            .configure().failFast(false).buildValidatorFactory();

    /**
     * 校验方法参数
     *
     * @param object 对象
     * @param method 方法
     * @param args   Object[] 参数
     */
    public static void normalValidateParameters(Object object,
                                                Method method,
                                                Object... args) {
        try {
            if (ArrayUtil.isEmpty(args)) {
                return;
            }
            ExecutableValidator validator = NORMAL_VALIDATOR_FACTORY.getValidator().forExecutables();
            Set<ConstraintViolation<Object>> violations = validator.validateParameters(object, method, args);
            throwIfHaveResult(violations);
        } catch (Throwable e) {
            throw new ValidatorException("参数校验过程异常", e);
        }
    }

    /**
     * 校验对象参数
     *
     * @param args 参数
     */
    public static void normalValidate(Object... args) {
        if (ArrayUtil.isEmpty(args)) {
            return;
        }
        Validator validator = NORMAL_VALIDATOR_FACTORY.getValidator();
        for (Object arg : args) {
            throwIfHaveResult(validator.validate(arg));
        }
    }

    /**
     * 如果有异常结果抛出
     *
     * @param resultSet 异常结果
     */
    private static void throwIfHaveResult(Set<ConstraintViolation<Object>> resultSet) {
        if (CollectionUtil.isNotEmpty(resultSet)) {
            String message = resultSet.stream().map(
                    result -> result.getPropertyPath() + result.getMessage() + "(" + result.getInvalidValue()
                            + ")").collect(
                    Collectors.joining(";"));
            throw new ValidatorException(message);
        }
    }

    /**
     * 校验对象
     *
     * @param t bean
     * @return ValidResult
     */
    public static <T> void fastValidate(T t) {
        Set<ConstraintViolation<T>> resultSet = FAST_VALIDATOR_FACTORY.getValidator().validate(t, Default.class);
        if (CollectionUtil.isNotEmpty(resultSet)) {
            String message = resultSet.stream().map(
                    result -> result.getPropertyPath() + result.getMessage() + "(" + result.getInvalidValue()
                            + ")").collect(
                    Collectors.joining(";"));
            throw new ValidatorException(message);
        }
    }

}
