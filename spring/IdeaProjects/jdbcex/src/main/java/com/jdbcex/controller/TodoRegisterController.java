package com.jdbcex.controller;

import com.jdbcex.dto.TodoDTO;
import com.jdbcex.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// 저 이름에 저 주소로
@WebServlet (name = "todoRegisterController", value = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    // 날짜를 표현하기 위해서
    // final은 변경 불가능 = 뒤에 이름을 보통 대문자로 표기
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        log.info("/todo/register GET......");

        HttpSession session = req.getSession();

        // 기존에 JSESSIONID가 없는 새로운 사용자
        if (session.isNew()) {
            log.info("JSESSIONID 쿠키가 새로 만들어진 사용자");
            resp.sendRedirect("/login");
            return; // return이 혼자 있으면 함수를 여기서 끝내라
            // return 뒤에 뭐 있으면 그 친구를 반환한다.
        }

        // JSESSIONID는 있지만 해당 세션 컨텍스트에 loginInfo라는 이름으로 저장된
        // 객체가 없는 경우
        if (session.getAttribute("loginInfo") == null) {
            log.info("로그인한 정보가 없는 사용자.");
            resp.sendRedirect("/login");
            return;
        }

        // 정상적인 경우라면 입력 화면으로
        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doPost(req, resp);
        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
                .build();
        // TodoDTO를 생성할건데
        // 파싱해서 duedate 값을 가져와서 포맷해라

        log.info("/todo/register POST......");
        log.info(todoDTO);
        try {
            todoService.register(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 다 잘 됐으면 sendRedirect를 이용해서 /todo/list로 보내라.
        // sendRedirect란 브라우저 화면을 이동시켜주는 것
        resp.sendRedirect("/todo/list");
    }
}
