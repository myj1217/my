package com.jdbcex.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.log4j.Log4j2;

@WebListener
@Log4j2
// implements가 나온다 = 인터페이스
public class AppListener implements ServletContextListener {
    // 시작할 때
    @Override
    public void contextInitialized (ServletContextEvent sce) {
        log.info("------init------");
        log.info("------init------");
        log.info("------init------");

        // ServletContextEvent(sce)를 이용하면 현재 애플리케이션이 실행되는 공간인 ServletContext에 접근한다.
        ServletContext servletContext = sce.getServletContext();
        // ServeletContext에는 setAttribute를 이용해서 원하는 이름으로 객체를 보관한다.
        servletContext.setAttribute("appName", "W2");
    }
    // 종료할 때
    @Override
    public void contextDestroyed (ServletContextEvent sce) {
        log.info("------destroy------");
        log.info("------destroy------");
        log.info("------destroy------");
    }
}
