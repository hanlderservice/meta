package com.chenyu.meta.framework.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class SysLoginLog {


    private Long id;

    private String requestId;

    @ApiModelProperty("用户名称")
    private String username;

    @ApiModelProperty("IP")
    private String ip;

    @ApiModelProperty("区域")
    private String area;

    @ApiModelProperty("运营商")
    private String operator;
    @ApiModelProperty("请求参数")
    private String param;

    @ApiModelProperty("tokenMd5值")
    private String token;

    @ApiModelProperty("1:登录，2：登出")
    private Integer type;

    @ApiModelProperty("是否成功 true:成功/false:失败")
    private Boolean success;

    @ApiModelProperty("响应码")
    private Integer code;
    @ApiModelProperty("响应消息")
    private String message;

    @ApiModelProperty("失败消息记录")
    private String exceptionMessage;

    @ApiModelProperty("浏览器名称")
    private String userAgent;

    @ApiModelProperty("浏览器名称")
    private String browserName;

    @ApiModelProperty("浏览器版本")
    private String browserVersion;

    @ApiModelProperty("浏览器引擎名称")
    private String engineName;

    @ApiModelProperty("浏览器引擎版本")
    private String engineVersion;

    @ApiModelProperty("系统名称")
    private String osName;

    @ApiModelProperty("平台名称")
    private String platformName;

    @ApiModelProperty("是否是手机,0:否,1:是")
    private Boolean mobile;

    @ApiModelProperty("移动端设备名称")
    private String deviceName;

    @ApiModelProperty("移动端设备型号")
    private String deviceModel;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("修改时间")
    private String updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
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

    public Boolean getMobile() {
        return mobile;
    }

    public void setMobile(Boolean mobile) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
