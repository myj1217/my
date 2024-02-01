package com.jdbcex.controller;

import com.jdbcex.dto.MemberDTO;
import com.jdbcex.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.UUID;

@WebServlet ("/login")
@Log4j2
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login get ......");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login post ......");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");
        String auto = req.getParameter("auto");

        // auto는 login.jsp에 있는 checkbox의 이름이다.
        // jstl에서의 checkbox는 on과 null로 이루어진다. (js에서는 true/false)
        boolean rememberMe = auto != null && auto.equals("on"); // on은 어디서?

        try {
            // mid와 mpw의 값을 memberDTO에 저장
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            // rememberMe가 true 라면 tbl_member 테이블에 사용자의 정보에
            // uuid를 수정하도록 MemberDAO에 추가적인 기능을 작성한다.
            if (rememberMe) {
                String uuid = UUID.randomUUID().toString();
                // 싱글톤에 접근해서 업데이트
                MemberService.INSTANCE.updateUuid(mid, uuid); // DB 업데이트
                // 받아온 UUID로 업데이트해라.
                memberDTO.setUuid(uuid); // 객체 업데이트
                // 스프링에서는 DB와 객체 업데이트를 각각 해주어야한다.
                // 부트에서는 하나로 통합

                Cookie rememberCookie = new Cookie("remember-me", uuid);
                rememberCookie.setMaxAge(60); // 유효기간, 1시간
                rememberCookie.setPath("/");

                resp.addCookie(rememberCookie);
            }
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }
    }
}
