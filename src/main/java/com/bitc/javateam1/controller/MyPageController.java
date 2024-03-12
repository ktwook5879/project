package com.bitc.javateam1.controller;

import com.bitc.javateam1.Utils.JSFunction;
import com.bitc.javateam1.dto.MemberDTO;
import com.bitc.javateam1.service.BoardService;
import com.bitc.javateam1.service.MemberService;
import com.bitc.javateam1.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mypage")
public class MyPageController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    BoardService boardService;

    @Autowired
    MemberService memberService;

    // 현재 내 회원정보를 출력
    @RequestMapping("/mypage")
    public ModelAndView MypageMain(HttpServletRequest req) throws Exception{
        ModelAndView mv = new ModelAndView("mypage/mypage");

        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");

        MemberDTO dto = memberService.memberInformation(id);
        mv.addObject("member", dto);

        return mv;
    }
//

    // 회원정보 수정
    @RequestMapping(value = "/mypageEditProcess", method = RequestMethod.POST)
    public void mypageEditProcss(MemberDTO dto, HttpServletRequest req,HttpServletResponse res) throws Exception {

        memberService.dataEdit(dto);

        HttpSession session = req.getSession();

        session.removeAttribute("id");
        session.removeAttribute("nickName");
        session.removeAttribute("password");

        session.invalidate();

        JSFunction.alertLocation("회원 정보가 수정되었습니다. 다시 로그인해주세요", "/main/minsome", res);
    }

    //nickName 중복 확인
    @PostMapping("/ConfirmNickName")
    @ResponseBody
    public ResponseEntity<Boolean> confirmNickName(String nickName) {

        boolean result = true;

        if(nickName.trim().isEmpty()) {
            result = false;
        } else {
            result = memberService.selectNickName(nickName);
//            if (memberService.selectNickName(nickName)) {
//                result = false;
//            } else {
//                result = true;
//            }
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @RequestMapping("/about")
    public ModelAndView MypageAbout(HttpServletRequest req)throws Exception{
        ModelAndView mv = new ModelAndView("mypage/about");
        HttpSession session = req.getSession();
        String nickName = (String) session.getAttribute("nickName");

        MemberDTO member = memberService.myPageInform(nickName);
        mv.addObject("member", member);
        System.out.println(member);


        return mv;
    }

    @RequestMapping("/delete")
    public String MyPageDelete()throws Exception{
        return "mypage/delete";
    }

    @RequestMapping("/deleteProcess")
    public void memeberOut(HttpServletRequest request, HttpServletResponse res)throws Exception{
        HttpSession session = request.getSession();
        String nick = (String) session.getAttribute("nickName");

            reviewService.DeleteNick(nick);
            boardService.MemberDelImg(nick);
            boardService.MemberDelComm(nick);
            memberService.memberDel(nick);

        session.removeAttribute("id");
        session.removeAttribute("nickName");
        session.removeAttribute("password");

        session.invalidate();

        JSFunction.alertLocation("회원탈퇴가 완료되었습니다.","/main/minsome", res);
    }
}
