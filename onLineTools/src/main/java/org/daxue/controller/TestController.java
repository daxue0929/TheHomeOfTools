package org.daxue.controller;

import com.alipay.api.AlipayApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.daxue.service.common.AliPayService;
import org.daxue.service.common.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author daxue0929
 * @date 2020/09/16
 **/
@Controller
@Slf4j
@RequestMapping("/test")
public class TestController {

    MailSendService mailSendService;
    AliPayService aliPayService;

    @Autowired
    public TestController(MailSendService mailSendService, AliPayService aliPayService){
        this.mailSendService = mailSendService;
        this.aliPayService = aliPayService;

    }


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
    public Map test02() {
        HashMap<String, Object> result = null;
        try {
            String test = "hello world ni ////are right! " +
                    "/n/n\n" +
                    "look at me.";
            result = new HashMap<>();

            File file = new File("/Users/daxue0929/Downloads/timg.jpeg");
            byte[] bytes = FileUtils.readFileToByteArray(file);


            result.put("s____tr", Base64Utils.encodeToString(bytes));
            result.put("strSafe", Base64Utils.encodeToUrlSafeString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("/testForwardMAV")
    public ModelAndView testForwardMAV() {
        ModelAndView mv = new ModelAndView();
        //使用重定向，此时springmvc.xml配置文件中的视图解析器将会失效
        mv.setViewName("redirect:/test/testForwardResult");
        return mv;
    }


    @RequestMapping("/testForwardResult")
    @ResponseBody
    public String testForwardResult() {
        return "new page";
    }


    @RequestMapping("/test03")
    @ResponseBody
    public void test03() {
        File file = new File("/das");
        boolean b = file.canRead();
        file = null;
        boolean b1 = file.canRead();

    }

    @RequestMapping("/ali")
    public void test04() {
        try {
            aliPayService.aliPayRequest();
        } catch (AlipayApiException e) {
            log.error("TestController test04 error: {}", e.getMessage());
        }
    }



}
