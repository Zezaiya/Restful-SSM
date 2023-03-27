package com.zezai.config;


import com.zezai.controller.interception.Interceptor;
import com.zezai.controller.interception.Interceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan({"com.zezai.controller"})
@EnableWebMvc
public class SpringMvcConfig  implements WebMvcConfigurer{
    @Autowired
    private Interceptor interceptor;
    @Autowired
    private Interceptor2 interceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/books","/books/*");  //可变参数
        registry.addInterceptor(interceptor2).addPathPatterns("/books","/books/*");  //可变参数
    }
    //因为我们在Tomcat容器启动类里设置好了所有访问都交给MVC处理,故静态资源也会被MVC拦截导致无法在浏览器显示,解决方法就是添加一个配置类
    //静态资源放行--->当访问到/pages/???目录时,走pages目录下的内容
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }

}
