package com.baizhi.asprects;

import com.baizhi.Interceptors.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter {

    @Resource//注入拦截器对象
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(myInterceptor)配置装载拦截器对象
        //        .addPathPatterns("/*.jsp");配置拦截的范围，要配置多个包的拦截器则可以写成数组，例：.addPathPatterns(":/User/**，/studnets/**")
        // .excludePathPatterns("/User/selectUser");//配置不拦截的包或者方法，同样可以写成数组
    }

}
