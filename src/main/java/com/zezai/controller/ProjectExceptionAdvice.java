package com.zezai.controller;

import com.zezai.exception.BusinessException;
import com.zezai.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice   //专门处理Rest风格开发的注解    (一般是ControllerAdvice)
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)    //表示该方法处理什么类型的异常
    public Result doException(Exception exception){
        return new Result(Code.SYSTEM_UNKNOWN_ERR,null,"系统繁忙,请稍后再试");   //对异常的处理方式
    }


    @ExceptionHandler(SystemException.class)          //拦截(自定义)系统异常
    public Result doSystemException(SystemException exception){
        //记录日志
        //发消息给运维
        //发邮件给开发人员
        return new Result(exception.getCode(),null,exception.getMessage());
    }


    @ExceptionHandler(BusinessException.class)          //拦截(自定义)系统异常
    public Result doBusinessException(BusinessException exception){
        return new Result(exception.getCode(),null,exception.getMessage());
    }
}
