package com.deb.diaoyu.demo.model.result;

import lombok.Data;
import lombok.ToString;

/**
 * 返回的json result
 */
@Data
@ToString
public class Result {
    /**
     * 状态码
     */
    private int code;
    /**
     * 描述
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultCode code){
        this.code = code.getCode();
        this.msg = code.getMessage();
    }

    public Result(ResultCode code, Object data){
        this(code);
        this.data = data;
    }
}
