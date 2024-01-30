package com.dao;

import com.jdbcex.dao.TodoDAO;
import com.jdbcex.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2024, 01, 30))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        // Long 타입은 뒤에 L 붙혀야함
        Long tno = 6L;
        // tno 값에 해당하는 정보를 vo 공간에 저장
        TodoVO vo = todoDAO.selectOne(tno);
        // vo 공간 출력
        System.out.println(vo);
    }

    // 수정 테스트
    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021, 12, 31))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }
}
