package com.jdbcex.filter;

import com.jdbcex.dto.MemberDTO;
import com.jdbcex.service.MemberService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter (urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        log.info("Login check filter ......");

        // ServletRequest 가 HttpServletRequest 보다 크기 때문에 다운캐스팅
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        //
        HttpSession session = req.getSession();

        // 로그인한 정보가 없는 사용자가 접근하면
        if(session.getAttribute("loginInfo") == null) {
            // 다음 필터나 목적지로 갈 수 있도록 실행
            // /todo/list, /WEB-INF/todo/list.jsp
            chain.doFilter(request, response);
            //  doFilter   servlet     jsp

            return;
        }

        // session에 loginInfo 값이 없다면
        // 쿠키를 체크
        Cookie cookie = findCookie(req.getCookies(), "remember-me");

        // 세션에도 없고 쿠키도 없다면 그냥 로그인으로
        if (cookie == null) {
            resp.sendRedirect("/login");
            return;
        }

        // 쿠키가 존재하는 상황이라면
        log.info("cookie는 존재하는 상황");
        // uuid값
        String uuid = cookie.getValue();

        try {
            // 데이터베이스 확인
            MemberDTO memberDTO = MemberService.INSTANCE.getByUUID(uuid);

            log.info("쿠키의 값으로 조회한 사용자 정보: " + memberDTO);
            if (memberDTO == null) {
                throw new Exception("Cookie value is not valid");
            }
            // 회원정보를 세션에 추가
            session.setAttribute("loginInfo", memberDTO);
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/login");
        }


    }

    private Cookie findCookie(Cookie[] cookies, String name) {
        // cookies 배열이 null이거나 비어져 있으면, 아무 작업도 하지 않고 null
        if (cookies == null || cookies.length == 0) {
            return null;
        }

        // Optional: 값의 존재 여부를 확인할 때 사용하는 자바 클래스
        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(ck -> ck.getName().equals(name))
                .findFirst(); // 첫번째로 일치하는 쿠키를 찾아라.

        // result가 존재하는지 확인. (존재하면 true, 존재하지 않으면 null)
        return result.isPresent() ? result.get() : null;
    }
}
