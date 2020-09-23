package org.daxue.controller;

import lombok.extern.slf4j.Slf4j;
import org.daxue.service.common.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author daxue0929
 * @date 2020/09/16
 **/
@Controller
@Slf4j
@RequestMapping("/test")
public class TestController {

    @Autowired
    MailSendService mailSendService;

//    @RequestMapping("/")
//    public String testPage() {
//        return "views/index";
//    }

    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    public void test01() {
        boolean isSend = mailSendService.send("daxue0929@qq.com", "邮件主题test01", "我才弑一本正经的邮件正文");
        log.info("一本正经的发送成功了: {}",  isSend);
    }

    @ResponseBody
    @RequestMapping(value = "/test02", method = RequestMethod.GET)
    public String test02() {
        return "test02";
    }

}
