package com.jiehfut.dspringbootweb2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

// @EnableWebMvc // 使用该注解会禁止默认配置信息
@Configuration
public class StaticResourcesConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 保留了以前默认的配置
        // WebMvcConfigurer.super.addResourceHandlers(registry);

        // 自己添加规则（原有的规则还在）
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/first/")
                .addResourceLocations("classpath:/second/")
                .addResourceLocations("classpath:/third/")
                .setCacheControl(CacheControl.maxAge(12, TimeUnit.SECONDS));

    }

    /**
     * 也可以不实现 WebMvcConfigurer 接口
     *
     * @Configuration
     * public class StaticResourcesConfig {
     *     @Bean
     *     public WebMvcConfigurer webMvcConfigurer() {
     *         return new WebMvcConfigurer() {
     *             @Override
     *             public void addResourceHandlers(ResourceHandlerRegistry registry) {
     *                 registry.addResourceHandler("/static/**")
     *                         .addResourceLocations("classpath:/first/")
     *                         .addResourceLocations("classpath:/second/")
     *                         .addResourceLocations("classpath:/third/")
     *                         .setCacheControl(CacheControl.maxAge(12, TimeUnit.SECONDS));
     *             }
     *         };
     *     }
     * }
     */



}
