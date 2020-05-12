package com.deb.diaoyu.demo.exception;

import com.deb.diaoyu.demo.model.result.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GlobalException extends RuntimeException{
    int status;

    public GlobalException(int status) {
        this.status = status;
    }

    public GlobalException(int status, String message) {
        super(message);
        this.status = status;
    }

    public GlobalException(ResultCode code){
        super(code.getMessage());
        this.status = code.getCode();
    }

    public GlobalException(String message, Throwable cause, int status) {
        super(message, cause);
        this.status = status;
    }

    public GlobalException(Throwable cause, int status) {
        super(cause);
        this.status = status;
    }
}
