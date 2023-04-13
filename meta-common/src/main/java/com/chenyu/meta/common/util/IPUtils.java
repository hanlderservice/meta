package com.chenyu.meta.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: IP地址获取工具类
 */
public class IPUtils {




    public static final String UNKNOWN = "unknown";
    public static final String IPV6_LOCAL = "0:0:0:0:0:0:0:1";

    private IPUtils() {
        throw new AssertionError();
    }

    public static String getRequestIP() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return getRequestIP(request);

    }

    /**
     * 获取请求用户的IP地址
     *
     * @param request
     * @return
     */
    private static String getRequestIP(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (IPV6_LOCAL.equals(ip)) {
            ip = getLocalhostIp();
        }
        return ip;
    }

    public static String getLocalhostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        }
        return null;
    }



}
