package com.jdbcex.controller;

import com.jdbcex.dto.TodoDTO;
import com.jdbcex.service.TodoService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", value = "/todo/list") // WebServlet 알리기
@Log4j2 // 더 이상 sout 안쓰고 log
public class TodoListController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        log.info("todo list......");

        // HttpServletRequest에는 getServletContext() 메서드를 이용해서 ServletContext를 이용할 수 있다.
        ServletContext servletContext = req.getServletContext();
        log.info("appName: " + servletContext.getAttribute("appName"));

        try {
            List<TodoDTO> dtoList = todoService.listAll(); // 리스트를 전부 가져온다.
            // setAttribute: 전달하기 전에 데이터를 저장한다.
            req.setAttribute("dtoList", dtoList);
            // forward : 너가 부른 활동만 진행해
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
    }
}
