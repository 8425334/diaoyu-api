package com.deb.diaoyu.demo.model.result;

public class ResultUtil {
    public static Result success(){
        return new Result(ResultCode.SUCCESS);
    }

    public static Result success(Object data){
        return new Result(ResultCode.SUCCESS, data);
    }

}
