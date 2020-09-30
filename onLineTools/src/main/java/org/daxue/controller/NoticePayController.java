package org.daxue.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/notice")
public class NoticePayController {

    @RequestMapping("/pay")
    public void aliNoticePay(HttpServletRequest request) {
        log.info("NoticePayController aliNoticePay: {}", request);
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(request));
        log.info("NoticePayController aliNoticePay2: {}", jsonObject);
    }

}
