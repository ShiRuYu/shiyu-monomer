package com.shiyu.web.config;

import cn.hutool.core.collection.CollectionUtil;
import com.shiyu.utils.Result;
import com.shiyu.utils.ResultEnum;
import com.shiyu.utils.exception.BusinessException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: 异常处理
 */
@RestControllerAdvice("com")
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    public Result exception(BindException e, BindingResult bindingResult) {
        log.error(e.getMessage(), e);
        return Result.fail(ResultEnum.BAD_PARAM.getCode(), getBindingResult(e, bindingResult));
    }

    private String getBindingResult(BindException e, BindingResult bindingResult) {
        if (CollectionUtil.isNotEmpty(bindingResult.getFieldErrors())) {
            StringBuilder stringBuilder = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                stringBuilder.append(fieldError.getField())
                        .append(":")
                        .append(fieldError.getDefaultMessage())
                        .append("; ");
            }
            return stringBuilder.toString();
        }
        return e.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    public Result exception(RuntimeException e) {
        log.error(e.getMessage(), e);
        return Result.fail(ResultEnum.ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result exception(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
        return Result.fail(ResultEnum.BAD_PARAM.getCode(), e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result exception(BusinessException e) {
        log.error(e.getMessage(), e);
        return Result.fail(ResultEnum.ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail(ResultEnum.ERROR);
    }
}
