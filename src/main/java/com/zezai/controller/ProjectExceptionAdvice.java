package com.zezai.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice   //专门处理Rest风格开发的注解    (一般是ControllerAdvice)
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)    //表示该方法处理什么类型的异常
    public Result doException(Exception exception){
        String msg="异常可抓到你咯";
        return new Result(666,null,msg);   //对异常的处理方式
    }
}
