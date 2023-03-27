package com.zezai.controller.interception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component   //springmvc自动加载
public class Interceptor implements HandlerInterceptor {  //拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("pre.....");     //拦截操作前运行
        return true;             //true-----原始操作执行(放行)      false------执行完preHandle后终止原始操作(不允许放行)
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post.....");   //拦截操作后运行
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after.....");    //在postHandle结束后执行,主要用于清除资源
    }
}
