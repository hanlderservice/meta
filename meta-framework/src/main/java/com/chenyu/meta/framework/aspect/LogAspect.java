package com.chenyu.meta.framework.aspect;

import com.chenyu.meta.framework.aop.BaseLogAop;
import com.chenyu.meta.framework.domain.OperationLogInfo;
import com.chenyu.meta.framework.domain.RequestInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 日志拦截器
 */
@Aspect
@Component
public class LogAspect extends BaseLogAop {

    /*配置接入点*/
    @Pointcut("@annotation(com.chenyu.meta.framework.aop.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    @Override
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return super.handle(joinPoint);
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
    @Override
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        super.handleAfterThrowing(exception);
    }

    @Override
    protected void setRequestId(RequestInfo requestInfo) {
        super.handleRequestId(requestInfo);
    }

    @Override
    protected void getRequestInfo(RequestInfo requestInfo) {
        // 处理请求参数日志
        super.handleRequestInfo(requestInfo);
    }

    @Override
    protected void getResponseResult(Object result) {
        // 处理响应结果日志
        super.handleResponseResult(result);
    }

    @Override
    protected void finish(RequestInfo requestInfo, OperationLogInfo operationLogInfo, Object result, Exception exception) {
        // 异步保存操作日志
        super.saveSysOperationLog(requestInfo, operationLogInfo, result, exception);
        // 异步保存登录日志
        super.saveSysLoginLog(requestInfo, operationLogInfo, result, exception);

    }

}
