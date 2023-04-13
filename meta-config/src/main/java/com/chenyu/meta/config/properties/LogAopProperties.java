package com.chenyu.meta.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "meta.aop")
public class LogAopProperties {

    /**
     * 请求路径Filter配置
     */
    @NestedConfigurationProperty
    private LogAopConfig log = new LogAopConfig();

    /**
     * 操作日志配置
     */
    @NestedConfigurationProperty
    private OperationLogConfig operationLog;

    /**
     * 登录日志配置
     */
    private LoginLogConfig loginLog;

    public static class AopConfig {

        /**
         * 是否启用
         */
        private boolean enable;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }
    }

    public static class LogAopConfig extends AopConfig {

        /**
         * 是否启用requestId
         */
        private boolean enableRequestId;

        /**
         * 日志输出类型：print-type
         */
        private LogPrintType logPrintType;

        /**
         * 请求ID生成类型
         */
        private RequestIdType requestIdType;

        /**
         * 请求日志在控制台是否格式化输出，local环境建议开启，服务器环境设置为false
         */
        private boolean requestLogFormat;

        /**
         * 响应日志在控制台是否格式化输出，local环境建议开启，服务器环境设置为false
         */
        private boolean responseLogFormat = true;

        /**
         * 排除路径
         */
        private Set<String> excludePaths;


        public boolean isEnableRequestId() {
            return enableRequestId;
        }

        public void setEnableRequestId(boolean enableRequestId) {
            this.enableRequestId = enableRequestId;
        }

        public LogPrintType getLogPrintType() {
            return logPrintType;
        }

        public void setLogPrintType(LogPrintType logPrintType) {
            this.logPrintType = logPrintType;
        }

        public RequestIdType getRequestIdType() {
            return requestIdType;
        }

        public void setRequestIdType(RequestIdType requestIdType) {
            this.requestIdType = requestIdType;
        }

        public boolean isRequestLogFormat() {
            return requestLogFormat;
        }

        public void setRequestLogFormat(boolean requestLogFormat) {
            this.requestLogFormat = requestLogFormat;
        }

        public boolean isResponseLogFormat() {
            return responseLogFormat;
        }

        public void setResponseLogFormat(boolean responseLogFormat) {
            this.responseLogFormat = responseLogFormat;
        }

        public Set<String> getExcludePaths() {
            return excludePaths;
        }

        public void setExcludePaths(Set<String> excludePaths) {
            this.excludePaths = excludePaths;
        }
    }

    /**
     * 操作日志配置
     */

    public static class OperationLogConfig {

        /**
         * 是否启用
         */
        private boolean enable = true;

        /**
         * 排除路径
         */
        private Set<String> excludePaths = new HashSet<>();

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public Set<String> getExcludePaths() {
            return excludePaths;
        }

        public void setExcludePaths(Set<String> excludePaths) {
            this.excludePaths = excludePaths;
        }
    }

    /**
     * 登录日志配置
     */
    public static class LoginLogConfig {

        /**
         * 是否启用
         */
        private boolean enable;

        /**
         * 登录路径
         */
        private String loginPath;

        /**
         * 登出路径
         */
        private String logoutPath;

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public String getLoginPath() {
            return loginPath;
        }

        public void setLoginPath(String loginPath) {
            this.loginPath = loginPath;
        }

        public String getLogoutPath() {
            return logoutPath;
        }

        public void setLogoutPath(String logoutPath) {
            this.logoutPath = logoutPath;
        }
    }

    /**
     * 日志打印类型
     *
     * @author geekidea
     * @date 2020/3/19
     **/
    public enum LogPrintType {

        /**
         * 不打印日志
         */
        NONE,
        /**
         * 请求和响应日志，按照执行顺序分开打印
         */
        ORDER,
        /**
         * 方法执行结束时，连续分开打印请求和响应日志
         */
        LINE,
        /**
         * 方法执行结束时，合并请求和响应日志，同时打印
         */
        MERGE;

    }

    /**
     * 请求ID生成类型
     *
     * @author geekidea
     * @date 2020/3/25
     **/
    public enum RequestIdType {
        /**
         * 生成UUID无中横线
         */
        UUID,
        /**
         * 生成数字
         */
        IDWORK
    }

    public LogAopConfig getLog() {
        return log;
    }

    public void setLog(LogAopConfig log) {
        this.log = log;
    }

    public OperationLogConfig getOperationLog() {
        return operationLog;
    }

    public void setOperationLog(OperationLogConfig operationLog) {
        this.operationLog = operationLog;
    }

    public LoginLogConfig getLoginLog() {
        return loginLog;
    }

    public void setLoginLog(LoginLogConfig loginLog) {
        this.loginLog = loginLog;
    }

}
