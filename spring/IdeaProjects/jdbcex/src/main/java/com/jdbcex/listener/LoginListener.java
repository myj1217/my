package com.jdbcex.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import lombok.extern.log4j.Log4j2;

@WebListener
@Log4j2
// HttpSessionAttributeListener: HttpSession 관련 작업을 감시하는 리스너
public class LoginListener implements HttpSessionAttributeListener {
    // 속성이 추가됐는지 확인하는 메서드
    @Override
    public void attributeAdded (HttpSessionBindingEvent event) {
        // 세션 속성이 변경될 때 호출되는 메서드
        String name = event.getName();
        Object obj = event.getValue();
        if (name.equals("loginInfo")) {
            log.info("A user logined...");
            log.info(obj); // MemberDTO
        }
    }
}
