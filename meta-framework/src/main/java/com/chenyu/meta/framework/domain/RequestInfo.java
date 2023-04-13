package com.chenyu.meta.framework.domain;

import java.io.Serializable;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class RequestInfo implements Serializable {


    /**
     * 请求路径
     */
    private String path;
    /**
     * 请求ID
     */
    private String requestId;
    /**
     * 请求实际路径
     */
    private String realPath;
    /**
     * 请求IP地址
     */
    private String ip;
    /**
     * 请求IP对象
     */
    private IpAddress ipAddress;
    /**
     * 请求方式，GET/POST
     */
    private String requestMethod;
    /**
     * 请求内容类型
     */
    private String contentType;
    /**
     * 判断控制器方法参数中是否有RequestBody注解
     */
    private Boolean requestBody;
    /**
     * 请求参数对象
     */
    private Object param;
    /**
     * 请求时间字符串
     */
    private String time;
    /**
     * 请求token
     */
    private String token;
    /**
     * 请求token MD5值
     */
    private String tokenMd5;
    /**
     * 用户代理字符串
     */
    private String userAgent;
    /**
     * requiresRoles值
     */
    private String requiresRoles;
    /**
     * requiresPermissions值
     */
    private String requiresPermissions;
    /**
     * requiresAuthentication
     */
    private Boolean requiresAuthentication;
    /**
     * requiresUser
     */
    private Boolean requiresUser;
    /**
     * requiresGuest
     */
    private Boolean requiresGuest;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public IpAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(IpAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Boolean getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(Boolean requestBody) {
        this.requestBody = requestBody;
    }

    public Object getParam() {
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenMd5() {
        return tokenMd5;
    }

    public void setTokenMd5(String tokenMd5) {
        this.tokenMd5 = tokenMd5;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getRequiresRoles() {
        return requiresRoles;
    }

    public void setRequiresRoles(String requiresRoles) {
        this.requiresRoles = requiresRoles;
    }

    public String getRequiresPermissions() {
        return requiresPermissions;
    }

    public void setRequiresPermissions(String requiresPermissions) {
        this.requiresPermissions = requiresPermissions;
    }

    public Boolean getRequiresAuthentication() {
        return requiresAuthentication;
    }

    public void setRequiresAuthentication(Boolean requiresAuthentication) {
        this.requiresAuthentication = requiresAuthentication;
    }

    public Boolean getRequiresUser() {
        return requiresUser;
    }

    public void setRequiresUser(Boolean requiresUser) {
        this.requiresUser = requiresUser;
    }

    public Boolean getRequiresGuest() {
        return requiresGuest;
    }

    public void setRequiresGuest(Boolean requiresGuest) {
        this.requiresGuest = requiresGuest;
    }
}
