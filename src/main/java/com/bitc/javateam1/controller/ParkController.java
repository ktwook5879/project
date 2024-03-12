package com.bitc.javateam1.controller;

import com.bitc.javateam1.dto.ParkDTO;
import com.bitc.javateam1.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
public class ParkController {

    @Autowired
    private ParkService parkService;


    @RequestMapping("hello")
    public String viewTest()throws Exception{
        return "main";
    }



    @RequestMapping("/minsome")
    public String viewTest1()throws Exception{
        return "park/parkMain";
    }

}
