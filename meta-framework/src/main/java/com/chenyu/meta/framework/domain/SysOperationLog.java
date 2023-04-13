package com.chenyu.meta.framework.domain;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 系统操作日志
 */
public class SysOperationLog {


    private Long id;

    /**
     * 请求ID
     */
    private String requestId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 日志名称
     */
    private String name;
    /**
     * IP
     */
    private String ip;
    /**
     * 区域
     */
    private String area;
    /**
     * 运营商
     */
    private String operator;
    /**
     * 全路径
     */
    private String path;
    /**
     * 模块名称
     */
    private String module;
    /**
     * 类名
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 请求方式，GET/POST
     */
    private String requestMethod;
    /**
     * 内容类型
     */
    private String contentType;
    /**
     * 是否是JSON请求映射参数
     */
    private Boolean requestBody;
    /**
     * 请参数
     */
    private String param;
    /**
     * token
     */
    private String token;
    /**
     * "0:其它,1:新增,2:修改,3:删除,4:详情查询,5:所有列表,6:分页列表,7:其它查询,8:上传文件")
     */
    private Integer type;
    /**
     * 0:失败,1:成功
     */
    private Boolean success;
    /**
     * 响应结果状态码
     */
    private Integer code;
    /**
     * 响应结果消息
     */
    private String message;
    /**
     * 异常类名称
     */
    private String exceptionName;
    /**
     * 异常信息
     */
    private String exceptionMessage;
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
     * 是否是手机,0:否,1:是
     */
    private Boolean mobile;
    /**
     * 移动端设备名称
     */
    private String deviceName;
    /**
     * 移动端设备型号
     */
    private String deviceModel;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
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

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
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


