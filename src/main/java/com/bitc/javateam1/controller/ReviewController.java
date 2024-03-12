package com.bitc.javateam1.controller;


import com.bitc.javateam1.Utils.JSFunction;
import com.bitc.javateam1.dto.ReviewDTO;
import com.bitc.javateam1.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @ResponseBody
    @PostMapping ("/review")
    public boolean ReviewInsert(@RequestParam("cmIdx")int cmIdx, @RequestParam("content") String content, HttpServletRequest req)throws Exception{

        HttpSession session = req.getSession();
        System.out.println("댓글작동");
        ReviewDTO review = new ReviewDTO();

        review.setCommIdx(cmIdx);
        review.setContent(content);
        review.setReNick((String) session.getAttribute("nickName"));
        reviewService.InsertView(review);


        return true;
    }


    @ResponseBody
    @PostMapping("/reviewSelect")
    public Object SelectReview(@RequestParam("commIdx")int commIdx)throws Exception{
        List<ReviewDTO> reviewDTO1 = reviewService.SelectReview(commIdx);
        return reviewDTO1;
    }


    @GetMapping ("/review/delete")
    public void deleteReview(@RequestParam("rno")int rno, HttpServletRequest req, HttpServletResponse res)throws Exception{
        HttpSession session = req.getSession();
        ReviewDTO reviewDTO = reviewService.SelectReviewRno(rno);
        String nickName = (reviewDTO.getReNick());
        System.out.print(nickName);
        
        if(session.getAttribute("nickName")!=null){
            if (session.getAttribute("nickName").equals(nickName) || session.getAttribute("nickName").equals("master")) {

                reviewService.DeleteReview(rno);

                JSFunction.alertBack("댓글 삭제가 완료되었습니다.", res);

            }else {
                JSFunction.alertBack("댓글 입력한 사용자만 댓글 삭제가 가능합니다.",res);
                
            }
       
        }else {
            JSFunction.alertBack("로그인한 사람만 댓글 삭제가 가능합니다.",res);
        }
        
      
    }
}
