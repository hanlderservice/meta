package com.chenyu.meta.framework.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 忽略操作日志记录注解 在controller上标注该方法后，将不会记录日志
 * 可以标注在类和方法上，如果标记在类上，则会忽略controller
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLogIgnore {

}
