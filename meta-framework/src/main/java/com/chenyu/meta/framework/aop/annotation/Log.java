package com.chenyu.meta.framework.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 自定义注解
 * 1. 定义一个方法级别的@Log 注解，用于标注需要监控的方法
 * 2. @Document 注解标明
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    String value() default "";
}
