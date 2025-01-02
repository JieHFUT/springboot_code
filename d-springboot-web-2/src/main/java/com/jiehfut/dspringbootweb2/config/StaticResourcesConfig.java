package com.jiehfut.dspringbootweb2.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class StaticResourcesConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 保留了以前默认的配置
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // 自己添加规则
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/first/")
                .addResourceLocations("classpath:/second/")
                .addResourceLocations("classpath:/third/")
                .setCacheControl(CacheControl.maxAge(12, TimeUnit.SECONDS));
        

    }


}
