package com.bitc.javateam1.interceptor;

import com.bitc.javateam1.Utils.JSFunction;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheck implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        System.out.println("\n=========== interceptor 동작 ===========\n");


        String userId = (String) session.getAttribute("id");
        System.out.println("USER ID: " + userId);
        if (userId == null || userId.equals("")) {
            System.out.println("********** interceptor *********");
            System.out.println("비로그인 상태");
            System.out.println("User ID :" +(String)session.getAttribute("id"));

            response.sendRedirect("/login/login.do");
            //인터셉터를 통과하지 못하였으므로 false를 리턴, 지정한 컨트롤러에 접근이 불가
            return false;

        }else{
            //로그인 상태
            System.out.println("********** interceptor *********");
            System.out.println("로그인 상태");
            System.out.println("User ID :" +(String)session.getAttribute("id"));
            //현재 세션의 사용시간을 초기화
            session.setMaxInactiveInterval(60*60);
            //언터셉터를 통과했으므로 true를 리턴, 지정한 컨트롤러에 접근가능
        }


        return true;
    }
}


