package com.demo.todo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        System.out.println("input change......");
        // dispatcher가 처리해서 주소로 전달
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        // 무엇을 전달해? 앞에 있는거
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        System.out.println("list change......");
        // POST 방식의 새로고침을 막기 위해 PRG패턴 적용 - sendRedirect()
        // list 페이지로 보내버림
        resp.sendRedirect("/todo/list");
    }
}
