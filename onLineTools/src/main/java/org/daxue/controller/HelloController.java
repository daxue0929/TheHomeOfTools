package org.daxue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/open")
public class HelloController {


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
