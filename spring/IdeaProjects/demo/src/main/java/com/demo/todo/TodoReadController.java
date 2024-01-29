package com.demo.todo;

import com.demo.todo.dto.TodoDTO;
import com.demo.todo.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        System.out.println("/todo/read");

        // /todo/read?tno=123
        Long tno = Long.parseLong(req.getParameter("tno"));

        TodoDTO dto = TodoService.INSTANCE.get(tno);

        req.setAttribute("dto", dto);

        // forward: 응답내용 무시, 보이는 것만
        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req,resp);
    }
}
