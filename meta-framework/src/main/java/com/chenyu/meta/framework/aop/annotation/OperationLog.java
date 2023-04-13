package com.chenyu.meta.framework.aop.annotation;

import com.chenyu.meta.framework.enums.OperationLogType;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    /**
     * 日志名称
     *
     * @return
     */
    String name() default "";

    /**
     * 日志名称
     *
     * @return
     */
    @AliasFor("name")
    String value() default "";

    /**
     * 日志类型
     *
     * @return
     */
    OperationLogType type() default OperationLogType.OTHER;

    /**
     * 日志备注
     *
     * @return
     */
    String remark() default "";


}
