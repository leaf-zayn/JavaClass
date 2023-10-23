package com.zayn.ggkt.exception;

import com.zayn.ggkt.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice//aop
public class GlobalExceptionHandler {
    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail(null).message("执行了全局异常处理");
    }

    //自定义异常处理
    @ExceptionHandler(GgktException.class)
    @ResponseBody
    public Result error(GgktException e) {
        System.out.println("特定.....");
        e.printStackTrace();
        return Result.fail(null).code(e.getCode()).message(e.getMsg());
    }
}
