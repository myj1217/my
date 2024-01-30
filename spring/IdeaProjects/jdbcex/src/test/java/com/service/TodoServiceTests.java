package com.service;

import com.jdbcex.dto.TodoDTO;
import com.jdbcex.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {
    private TodoService todoService;

    // 테스트 코드 실행 전에 객체부터 생성해라.
    // 그대로 사용하는 것이 아닌 인스턴트를 생성해서 사용한다.
    @BeforeEach
    public void read() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        // VO로 변환이 되어야만 실행이 된다.
        TodoDTO todoDTO = TodoDTO.builder()
                .title("JDBC Test Title")
                .dueDate(LocalDate.now())
                .build();

        log.info("------------------------------------");
        log.info(todoDTO);

        todoService.register(todoDTO);
    }
}
