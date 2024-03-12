package com.bitc.javateam1.controller;

import com.bitc.javateam1.dto.ParkDTO;
import com.bitc.javateam1.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/search")
@Controller
public class SearchController {
    @Autowired
    ParkService parkService;


    @RequestMapping("/search")
public String SearchView()throws Exception{

        return "search/search";
}




    @GetMapping("/detail/{seq}")
    public ModelAndView parkDetailView(@PathVariable("seq") int seq)throws Exception{

        ModelAndView mv = new ModelAndView("park/parkDetail");

        ParkDTO parkList = parkService.selectParkList(seq);

        List<ParkDTO> parkImg = parkService.selectImage(seq);
        mv.addObject("parkList",parkList);
        mv.addObject("parkImg", parkImg);

        return mv;
    }

@GetMapping("/getSearchList")
    @ResponseBody
    public List<ParkDTO>getSearchList(@RequestParam("keyword")String keyword)throws Exception{
        ParkDTO parkDTO = new ParkDTO();
        parkDTO.setKeyword(keyword);

    List<ParkDTO> result = parkService.getSearchList(parkDTO);

    System.out.println(result);
 return result;
}
}
