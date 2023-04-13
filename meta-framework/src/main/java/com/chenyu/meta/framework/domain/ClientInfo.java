package com.chenyu.meta.framework.domain;

import java.io.Serializable;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 用户客户端信息
 */
public class ClientInfo implements Serializable {

    /**
     * IP
     */
    private String ip;
    /**
     * IP对应的地址
     */
    private String addree;
    /**
     * 浏览器名称
     */
    private String browserName;
    /**
     * 浏览器版本
     */
    private String browserVersion;
    /**
     * 浏览器引擎名称
     */
    private String engineName;
    /**
     * 浏览器引擎版本
     */
    private String engineVersion;
    /**
     * 系统名称
     */
    private String osName;
    /**
     * 平台名称
     */
    private String platformName;
    /**
     * 是否是手机
     */
    private boolean mobile;
    /**
     * 移动端设备名称
     */
    private String deviceName;
    /**
     * 移动端设备型号
     */
    private String deviceModel;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddree() {
        return addree;
    }

    public void setAddree(String addree) {
        this.addree = addree;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "ip='" + ip + '\'' +
                ", addree='" + addree + '\'' +
                ", browserName='" + browserName + '\'' +
                ", browserVersion='" + browserVersion + '\'' +
                ", engineName='" + engineName + '\'' +
                ", engineVersion='" + engineVersion + '\'' +
                ", osName='" + osName + '\'' +
                ", platformName='" + platformName + '\'' +
                ", mobile=" + mobile +
                ", deviceName='" + deviceName + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                '}';
    }

}
