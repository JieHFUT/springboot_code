package com.jiehfut.bspringbootinitializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // 主程序
                        // 默认只会扫描主程序所在的包及其子包
public class BSpringbootInitializrApplication {

    public static void main(String[] args) {

        // Java10 局部变量类型的自动推断
        var ioc = SpringApplication.run(BSpringbootInitializrApplication.class, args);

        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        // 遍历组件：dispatcherServlet beanNameViewResolver  characterEncodingFilter...
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        // 获取刚才注册的用户组件，默认是单实例的
        Object user = ioc.getBean("user");
        System.out.println(user);
        Object lisi = ioc.getBean("lisi");
        System.out.println(lisi);
    }

}
