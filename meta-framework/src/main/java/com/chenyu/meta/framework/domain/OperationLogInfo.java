package com.chenyu.meta.framework.domain;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description: 操作日志信息
 */
public class OperationLogInfo {


    /**
     * 是否忽略
     */
    private boolean ignore;
    /**
     * 模块名称
     */
    private String module;
    /**
     * 日志名称
     */
    private String name;
    /**
     * 日志类型
     */
    private Integer type;
    /**
     * 日志备注
     */
    private String remark;
    /**
     * controller类名称
     */
    private String controllerClassName;
    /**
     * controller 目标发方法名称
     */
    private String controllerMethodName;

    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getControllerClassName() {
        return controllerClassName;
    }

    public void setControllerClassName(String controllerClassName) {
        this.controllerClassName = controllerClassName;
    }

    public String getControllerMethodName() {
        return controllerMethodName;
    }

    public void setControllerMethodName(String controllerMethodName) {
        this.controllerMethodName = controllerMethodName;
    }
}
