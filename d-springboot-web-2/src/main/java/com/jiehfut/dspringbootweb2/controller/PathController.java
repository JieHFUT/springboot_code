package com.jiehfut.dspringbootweb2.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
     *：表示任意数量的字符。
     ?：表示任意一个字符。
     **：表示任意数量的目录。
     {}：表示一个命名的模式占位符。
     []：表示字符集合，例如[a-z]表示小写字母。

     AntPathMatcher    ** 可以使用在中间
     PathPatternParser 效率高，代价小，但是需要注意的是 ** 不能使用在中间，只能使用在最后
*/

@RestController
public class PathController {

    // 1.一个类可以拥有一个日志类，拿到当前类的日志记录器，可以使用注解注入
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/a*/b?/{p1:[a-f]+}/**")
    public String hello(HttpServletRequest request,
                        @PathVariable("p1") String path) {

        logger.info("路径变量p1： {}", path);
        //获取请求路径 http://localhost:8080/awwu/bo/aabbcdefffb/aaa/bbb
        String uri = request.getRequestURI();
        // uri = /awwu/bo/aabbcdefffb/aaa/bbb
        return uri;
    }

}
