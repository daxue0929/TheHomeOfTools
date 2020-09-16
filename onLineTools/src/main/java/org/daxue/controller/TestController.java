package org.daxue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author daxue0929
 * @date 2020/09/16
 **/
@Controller
public class TestController {

    @RequestMapping("/")
    public String testPage() {
        return "views/index";
    }

}
