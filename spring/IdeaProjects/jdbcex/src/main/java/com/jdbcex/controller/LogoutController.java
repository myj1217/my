package com.jdbcex.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebServlet("/logout")
@Log4j2
public class LogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("logout!!");

        // JSESSIONID 에 접근해서 환경을 만들고 인터페이스를 선언
        HttpSession session = req.getSession();

        session.removeAttribute("loginInfo"); // loginInfo 를 찾고나서 지움
        session.invalidate(); // 애들들을 무효화

        resp.sendRedirect("/"); // 루트로 이동해라
    }
}
