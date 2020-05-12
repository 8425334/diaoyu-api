package com.deb.diaoyu.demo.model.result;

import lombok.Data;

/**
 * json result enum
 */
public enum ResultCode {

    /**
     * 全局相关
     */
    SUCCESS(1000, "success"),
    FAIL(1001, "fail"),
    TOKEN_TIME_OUT(1002, "token过期"),
    TOKEN_NOT_FOUNT(1003, "您还未登录"),
    ARGUMENT_INVALID(1004, "参数错误"),
    CAPTCHA_INVALID(1005, "验证码有误");
    /**
     * 管理员相关
     */
    int code;
    String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
