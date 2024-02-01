package com.jdbcex.controller;

import com.jdbcex.dto.TodoDTO;
import com.jdbcex.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebServlet (name = "todoReadController", value = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        try {
            // tno를 long 타입으로 변환
            Long tno = Long.parseLong(req.getParameter("tno"));
            // tno의 VO를 DTO로 변환한 것을 받아서
            TodoDTO todoDTO = todoService.get(tno);

            // 데이터 담기
            req.setAttribute("dto", todoDTO);

            // 쿠키
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
            // 처음엔 getCookie에 JSESSION 밖에 없음
            String todoListStr = viewTodoCookie.getValue();
            boolean exist = false;

            // 조회값이 todoListStr에 있다라는 것
            // tno 이어쓰기 - 는 인덱스번호
            // todoListStr이 비어있지 않고 2- 이런식으로 값이 있다면 = exist를 true로 변경
            if (todoListStr != null && todoListStr.indexOf(tno + "-") >= 0 ) {
                exist = true;
            }

            log.info("exist: " + exist);

            // exist가 false면 쿠키에 추가 (true는 중복이므로 추가 안함)
            if (!exist) {
                todoListStr += tno + "-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60);
                viewTodoCookie.setPath("/");
                resp.addCookie(viewTodoCookie);
            }

            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }

    // 쿠키가 배열 = 쿠키가 여러개 들어올 수 있다.
    private Cookie findCookie (Cookie[] cookies, String cookieName) {
        Cookie targetCookie = null;
        if (cookies != null && cookies.length > 0) {
            for (Cookie ck:cookies) {
                // ck에서 받아온 이름이 cookieName이랑 같다면
                if (ck.getName().equals(cookieName)) {
                    targetCookie = ck;
                    break;
                }
            }
        }
        // 실질적으로 쿠키를 만드는 곳
        // 쿠키가 없다면 ~
        if (targetCookie == null) {
            targetCookie = new Cookie(cookieName, ""); // 쿠키를 새로 만듦 (cookieName을 이름으로 지정)
            targetCookie.setPath("/"); // 새로 생성한 쿠키의 접근 경로 (Path를 Root로 설정)
            targetCookie.setMaxAge(60*60*24); // 쿠키의 유효시간을 설정 (24시간)
        }
        return targetCookie;
    }
}
