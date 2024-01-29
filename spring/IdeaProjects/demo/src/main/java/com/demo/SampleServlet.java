package com.demo;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.print.attribute.standard.Severity;
import java.io.IOException;

@WebServlet(name = "sampleServlet", urlPatterns = "/sample")
public class SampleServlet  extends HttpServlet {
    @Override
    //doGet 방식은 항상 매개 변수를 저 두개받아오는 규칙이 있음, Exception 처리또한 까먹지 말고해라
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //현재 클래스의 정보를 출력함
        System.out.println("doGet: "+ this);
    }
    @Override
    public void destroy(){
        // 생명주기 관리에서, 서버가 꺼진다
        System.out.println("destroy..........");
    }
    @Override
    public void init(ServletConfig config) throws ServletException{
        // 톰캣의 생성과정에서 객체 생성하고 init 이란 메서드를 가장 먼저 실행함
        // 고로 가장 먼저 보임
        System.out.println("init(ServletConfig)...........");
    }
}