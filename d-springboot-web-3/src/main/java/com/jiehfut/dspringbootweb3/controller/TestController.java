package com.jiehfut.dspringbootweb3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/test-page")
    public String testPage(@RequestParam("name") String username,
                           Model model){

        // 生成模板的逻辑视图地址
        // 物理视图：前缀 + 逻辑 + 后缀
        //         classpath:/templates/page-test/html

        // 把需要共享到页面上的数据共享到 model 中，就可以通过视图渲染到页面上
        model.addAttribute("username", username);
        return "page-test";

    }
}
