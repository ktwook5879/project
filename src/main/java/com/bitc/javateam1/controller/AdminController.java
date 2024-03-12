package com.bitc.javateam1.controller;

import com.bitc.javateam1.Utils.JSFunction;
import com.bitc.javateam1.dto.BoardDTO;
import com.bitc.javateam1.dto.MemberDTO;
import com.bitc.javateam1.service.AdminService;
import com.bitc.javateam1.service.BoardService;
import com.bitc.javateam1.service.MemberService;
import com.bitc.javateam1.service.ReviewService;
import com.github.pagehelper.PageInfo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private BoardService boardService;
    @Autowired
    private MemberService memberService;

    //회원 목록
    @GetMapping("admin")
    public ModelAndView userList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("board/adminboard/userList");

        PageInfo<MemberDTO> PageList = new PageInfo<>(adminService.userList(pageNum), 5);
        mv.addObject("PageList", PageList);

        return mv;
    }

    //회원 상세
    @GetMapping("admin/{idx}")
    public ModelAndView userDetail(@PathVariable("idx") int idx) throws Exception {
        ModelAndView mv = new ModelAndView("board/adminboard/userManage");

        MemberDTO user = adminService.userDetail(idx);
        mv.addObject("user", user);

        return mv;
    }

    //회원 탈퇴
    @RequestMapping("admin/deleteUser.do")
    public String deleteUser(@RequestParam("id") String id) throws Exception {


        return "redirect:/admin";
    }

    @PostMapping("admin/userPost")
    public ModelAndView postList(@RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum, @RequestParam("cmId")String cmId) throws Exception {
        ModelAndView mv = new ModelAndView("board/adminboard/userPost");

        PageInfo<BoardDTO> PageList = new PageInfo<>(adminService.postList(pageNum, cmId), 5);
        mv.addObject("PageList", PageList);


        return mv;
    }

    //관리자 페이지 회원탈퇴
    @RequestMapping("admin/delete")
    public void memberKill(@RequestParam("nickname") String nick,HttpServletResponse res) throws Exception {

        reviewService.DeleteNick(nick);
        boardService.MemberDelImg(nick);
        boardService.MemberDelComm(nick);
        memberService.memberDel(nick);

        JSFunction.alertLocation("회원탈퇴가 완료되었습니다.","/admin", res);
    }
}
