package com.jiehfut.bspringbootinitializr.config;


import com.alibaba.druid.FastsqlException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;


@Import(ArrayList.class) // 或者以这种方式进行第三方的组件注入
@Configuration // 声明这是一个配置类
@ComponentScan("com.jiehfut.bspringbootinitializr") // 配置项目的包扫描路径
public class ApplicationConfig {

    // 第三方的组件进行注入
    @Bean
    public FastsqlException fastsqlException() {
        FastsqlException fastsqlException = new FastsqlException();
        return fastsqlException;
    }






}
