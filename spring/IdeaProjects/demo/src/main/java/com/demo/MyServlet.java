package com.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// 브라우저의 경로와 해당 서블릿을 연결하는 설정을 위해서 사용한다.
@WebServlet(name="myServlet", urlPatterns = "/my")
// name: 고유식별용도, urlPatterns: root 다음 주소 (localhost 뒤에 붙는 주소)
public class MyServlet extends HttpServlet {
    @Override
    // doGet: 브라우저의 주소를 주소를 직접 변경해서 접근하는 경우에 호출되는 메서드
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // doGet: HttpServlet 출신, 괄호 안 형태가 이미 정해져있는 케이스
        // throws : 오류가 있으면 던져라 (우선순위 왼쪽부터)
        resp.setContentType("text/html");

        // PrintWriter: 입력한 내용을 출력하는
        // getWriter: PrintWriter의 객체를 얻고 이를 통해 클라이언트로 텍스트 데이터를 보내준다.
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>MyServlet</h1>");
        out.println("</body><html>");
    }
}
