package com.jdbcex.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@WebFilter(urlPatterns = {"/*"}) // 모든 주소에
@Log4j2
public class UTF8Filter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("UTF8 Filter ......");

        HttpServletRequest req = (HttpServletRequest) request;

        req.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }
}
