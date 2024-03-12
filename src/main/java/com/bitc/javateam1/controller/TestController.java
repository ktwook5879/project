package com.bitc.javateam1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/test")
    public String testView()throws Exception{
        return "/test/test";
    }
}
