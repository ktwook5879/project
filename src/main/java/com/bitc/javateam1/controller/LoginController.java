package com.bitc.javateam1.controller;


import com.bitc.javateam1.Utils.JSFunction;
import com.bitc.javateam1.dto.MemberDTO;
import com.bitc.javateam1.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {
@Autowired
MemberService memberService;
	//    회원가입
	@RequestMapping("/register")
	public String join()  {
		return
				"/login/register";
	}

	@PostMapping("/registerProcess")
	public void joinProcess(MemberDTO memberDTO, HttpServletResponse res) throws Exception{
		int result = memberService.regiCheck(memberDTO);
		if(result<1) {

			memberService.Register(memberDTO);
			JSFunction.alertLocation("회원 가입에 성공하였습니다","/login/login.do",res);
		}else {
			JSFunction.alertBack("아이디 혹은 닉네임이 중복입니다.", res);
		}
	}
//로그인

	@RequestMapping("/login.do")
	public String login() throws Exception {
		return "login/login";
	}

	@RequestMapping(value = "/LoginProcess", method = RequestMethod.POST)
	public void loginProcess(@RequestParam("id") String id, @RequestParam("password") String password, HttpServletRequest req, HttpServletResponse res) throws Exception {

		int result = memberService.isUserInfo(id, password);

		if (result == 1) {
			MemberDTO user = memberService.getUserInfo(id);

			HttpSession session = req.getSession();
			session.setAttribute("id", user.getId());
			session.setAttribute("nickName", user.getNickName());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("grade", user.getGrade());

			session.setMaxInactiveInterval(60 * 60 * 1); //세션 유지 시간 설정

			if(session.getAttribute("grade").equals(1)){
				JSFunction.alertLocation("마스터님 반갑습니다", "/admin", res);
			}else{
				JSFunction.alertLocation(session.getAttribute("nickName")+"님 반갑습니다" ,"/main/minsome",res);
			}

		}
		else {
			JSFunction.alertBack("로그인에 실패했습니다.", res);
		}
	}


	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();

		session.removeAttribute("id");
		session.removeAttribute("nickName");
		session.removeAttribute("password");

		session.invalidate();

		return "redirect:/main/minsome";
	}

}
