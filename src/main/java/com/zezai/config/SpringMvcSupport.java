package com.zezai.config;

                        /*该类可以简化开发,全部写在SpringMvc的类里,不过耦合性会提升*/
import com.zezai.controller.interception.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration  //设置它为配置类,但是需要在核心配置类的包扫描里写上config路径
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    @Autowired
    private Interceptor interceptor;
    //因为我们在Tomcat容器启动类里设置好了所有访问都交给MVC处理,故静态资源也会被MVC拦截导致无法在浏览器显示,解决方法就是添加一个配置类
    //静态资源放行--->当访问到/pages/???目录时,走pages目录下的内容
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }
}
