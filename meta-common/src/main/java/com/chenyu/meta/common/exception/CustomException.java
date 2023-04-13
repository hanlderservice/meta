package com.chenyu.meta.common.exception;

import com.chenyu.meta.common.util.ApiCode;

/**
 * Create by 10296 on 2023/3/9
 *
 * @Description:
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -2470461654663264392L;

    private Integer errorCode;
    private String message;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public CustomException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public CustomException(ApiCode apiCode) {
        super(apiCode.getMessage());
        this.errorCode = apiCode.getCode();
        this.message = apiCode.getMessage();
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
