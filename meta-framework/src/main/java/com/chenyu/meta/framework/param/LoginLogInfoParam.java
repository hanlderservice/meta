package com.chenyu.meta.framework.param;

import com.chenyu.meta.common.param.BasePageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
@ApiModel("登录日志参数")
public class LoginLogInfoParam extends BasePageParam {

    @ApiModelProperty(value = "账号")
    private String username;
    @ApiModelProperty(value = "源IP")
    private String ip;
    @ApiModelProperty(value = "请求参数")
    private String param;
    @ApiModelProperty(value = "是否成功")
    private String success;
    @ApiModelProperty(value = "事件编码")
    private String code;
    @ApiModelProperty(value = "开始时间")
    private String startTime;
    @ApiModelProperty(value = "结束时间")
    private String endTime;

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

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
