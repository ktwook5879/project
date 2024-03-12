package com.bitc.javateam1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController{


    @RequestMapping("view")
    public String view1 () throws Exception {
        return "view";
    }

    }