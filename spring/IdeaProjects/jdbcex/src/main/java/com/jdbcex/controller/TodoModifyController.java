package com.jdbcex.controller;

import com.jdbcex.dto.TodoDTO;
import com.jdbcex.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet (name = "todoModifyController", value = "/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // tno 값을 받아와서 long 타입으로 파싱
            Long tno = Long.parseLong(req.getParameter("tno"));
            // tno 값에 해당하는 것의 VO를 DTO로 반환
            TodoDTO todoDTO = todoService.get(tno);

            // 데이터 담기
            // dto라는 형태로 담아서
            req.setAttribute("dto", todoDTO);
            // 저장한다.
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("modify get ... error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String finishedStr = req.getParameter("finished");

        TodoDTO todoDTO = TodoDTO.builder()
                .tno(Long.parseLong(req.getParameter("tno")))
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"), DATEFORMATTER))
                // null 이 아니고 즉, 체크가 되어있고
                .finished(finishedStr != null && finishedStr.equals("on"))
                .build();

        log.info("/todo/modify POST ...");
        log.info(todoDTO);
        try {
            todoService.modify(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list");
    }
}
