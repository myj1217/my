package com.jdbcex.service;

import com.jdbcex.dao.TodoDAO;
import com.jdbcex.domain.TodoVO;
import com.jdbcex.dto.TodoDTO;
import com.jdbcex.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    // TodoDTO를 받아서 TodoVO로 변환
    public void register(TodoDTO todoDTO) throws Exception {
        // 우리가 아는 그 map을 modelMapper가 대신 해주겠다.
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        // System.out.println("todoVO: " + todoVO);
        log.info(todoVO);

        dao.insert(todoVO); // 변환된 작업을 dao에 추가하겠다.
    }
}
