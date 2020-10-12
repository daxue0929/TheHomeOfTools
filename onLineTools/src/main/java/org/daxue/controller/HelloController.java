package org.daxue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/open")
public class HelloController {

    @RequestMapping("/page")
    @ResponseBody
    public String page() {
        return "一个简单的接口";
    }


    @RequestMapping("/hello")
    public String hello(HttpServletRequest request,
                        @RequestParam(
                                value = "name",
                                required = false,
                                defaultValue = "springboot-thymeleaf") String name) {

        request.setAttribute("name", name);
        return "hello";
    }

}
