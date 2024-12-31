package com.jiehfut.bspringbootinitializr;

import com.jiehfut.bspringbootinitializr.bean.Conf;
import com.jiehfut.bspringbootinitializr.bean.Conf1;
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


        Conf conf = ioc.getBean(Conf.class);
        System.out.println(conf); // Conf(id=10, name=张三, age=20)

        Conf1 conf1 = ioc.getBean(Conf1.class);
        System.out.println(conf1); // Conf1(id=20, name=李四, age=30)

    }

}
