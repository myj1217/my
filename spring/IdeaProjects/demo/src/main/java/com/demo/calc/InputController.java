package com.demo.calc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "InputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("InputController......doGet......");
        // servlet에 전달된 요청(request)을 다른쪽으로 전달 혹은 배포하는 역할을 하는 객체
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        // forward: 현재 요청을 다른 서블릿이나 jsp 페이지로 전달
        dispatcher.forward(req,resp);
    }
}
