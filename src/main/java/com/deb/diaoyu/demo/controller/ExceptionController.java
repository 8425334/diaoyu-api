package com.deb.diaoyu.demo.controller;

import com.deb.diaoyu.demo.exception.GlobalException;
import com.deb.diaoyu.demo.model.result.Result;
import com.deb.diaoyu.demo.model.result.ResultCode;
import com.deb.diaoyu.demo.model.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleEx(MethodArgumentNotValidException ex){
        log.error("参数错误{}", ex.getMessage());
        return new Result(ResultCode.ARGUMENT_INVALID);
    }

    @ExceptionHandler(GlobalException.class)
    public Result handGlobalEx(GlobalException e){
        log.error("全局错误{}", e.getMessage());
        return new Result(e.getStatus(), e.getMessage());
    }
}
