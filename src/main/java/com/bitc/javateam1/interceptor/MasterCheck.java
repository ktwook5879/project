package com.bitc.javateam1.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class MasterCheck implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();



        if( session == null || session.getAttribute("id").equals("admin")){

            System.out.println("********** interceptor *********");
            System.out.println("아임 마스터");
            System.out.println("User ID :" +(String)session.getAttribute("id"));
            //현재 세션의 사용시간을 초기화
            session.setMaxInactiveInterval(60*60);
            return true;
        }else {
            System.out.println("********** interceptor *********");
            System.out.println("마스터가 아닙니다.");
            System.out.println("User ID :" +(String)session.getAttribute("id"));

            response.sendRedirect("/main/minsome");

            return false;

        }

    }
}
