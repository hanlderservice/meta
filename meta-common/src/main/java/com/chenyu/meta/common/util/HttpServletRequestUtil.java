package com.chenyu.meta.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 获取当前请求的HttpServletRequest对象
 */
public class HttpServletRequestUtil {

    public static HttpServletRequest getServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
