package com.bitc.javateam1.configuration;


import com.bitc.javateam1.interceptor.LoginCheck;
import com.bitc.javateam1.interceptor.MasterCheck;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class WebMVcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheck())
                //addPathPatterns():인터셉터를 동작시킬 주소 패턴 등록
                .addPathPatterns("/search/*")

                //excludePathPatterns() : 인터셉터에서 제외할 주소패턴 등록
                .excludePathPatterns("/main/minsome")
                .excludePathPatterns("/login/login.do")
                .excludePathPatterns("/login/logout.do");

        registry.addInterceptor(new MasterCheck()).addPathPatterns("/admin")
                .addPathPatterns("/admin/*");

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //2개이상의 실제 경로를 등록하고자 할 경우 하나의 리소스 경로에 2개이상의 외부 경로를 등록하고자 할 경우
        //registry.addResourceHandler("/images/**").addResourceLocations(경로)
        //2개이상의 리소스 경로를 사용하고자할 경우
        //registry.addResourceHandler("/movie/**").addResourceLocations(경로);
        registry.addResourceHandler("/images/**").addResourceLocations("file:///C:/fullstack501/images/");


    }
}
