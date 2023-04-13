package com.chenyu.meta.common.util;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by 10296 on 2023/3/3
 *
 * @Description:
 */
public class ApiResult<T> implements Serializable {


    /*响应码*/
    private int statusCode;
    /*是否成功*/
    private boolean success;
    /*响应消息*/
    private String message;
    /*响应数据*/
    private T data;
    /* 响应时间*/
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    public ApiResult() {
        time = new Date();
    }


    public static ApiResult<Boolean> result(boolean flag) {
        if (flag) {
            return ok();
        }
        return fail();
    }

    public static ApiResult<Boolean> result(ApiCode apiCode) {
        return result(apiCode, null);
    }

    public static <T> ApiResult<T> result(ApiCode apiCode, T data) {
        return result(apiCode, null, data);
    }

    public static <T> ApiResult<T> result(ApiCode apiCode, String message, T data) {
        boolean success = false;
        if (apiCode.getCode() == ApiCode.SUCCESS.getCode()) {
            success = true;
        }
        String apiMessage = apiCode.getMessage();
        if (StringUtils.isBlank(message)) {
            message = apiMessage;
        }
        ApiResult<T> result = new ApiResult<>();
        result.setStatusCode(apiCode.getCode());
        result.setMessage(message);
        result.setData(data);
        result.setSuccess(success);
        result.setTime(new Date());


        return result;
    }

    public static ApiResult<Boolean> ok() {
        return ok(null);
    }

    public static <T> ApiResult<T> ok(T data) {
        return result(ApiCode.SUCCESS, data);
    }

    public static <T> ApiResult<T> ok(T data, String message) {
        return result(ApiCode.SUCCESS, message, data);
    }

    public static ApiResult<Map<String, Object>> okMap(String key, Object value) {
        Map<String, Object> map = new HashMap<>(1);
        map.put(key, value);
        return ok(map);
    }

    public static ApiResult<Boolean> fail(ApiCode apiCode) {
        return result(apiCode, null);
    }

    public static ApiResult<String> fail(String message) {
        return result(ApiCode.FAIL, message, null);

    }

    public static <T> ApiResult<T> fail(ApiCode apiCode, T data) {
        if (ApiCode.SUCCESS == apiCode) {
            throw new RuntimeException("失败结果状态码不能为" + ApiCode.SUCCESS.getCode());
        }
        return result(apiCode, data);

    }

    public static ApiResult<String> fail(Integer errorCode, String message) {
        ApiResult<String> result = new ApiResult<>();
        result.setSuccess(false);
        result.setStatusCode(errorCode);
        result.setMessage(message);

        return result;
    }

    public static ApiResult<Map<String, Object>> fail(String key, Object value) {
        Map<String, Object> map = new HashMap<>(1);
        map.put(key, value);
        return result(ApiCode.FAIL, map);
    }

    public static ApiResult<Boolean> fail() {
        return fail(ApiCode.FAIL);
    }


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}
