package com.demo.todo;

import com.demo.todo.dto.TodoDTO;
import com.demo.todo.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        System.out.println("/todo/list");

        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        // setAttribute: 'key':'value'의 형식으로 데이터를 보관
        req.setAttribute("list", dtoList);

        req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req,resp);
    }


}
