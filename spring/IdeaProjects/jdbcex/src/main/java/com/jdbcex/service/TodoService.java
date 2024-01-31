package com.jdbcex.service;

import com.jdbcex.dao.TodoDAO;
import com.jdbcex.domain.TodoVO;
import com.jdbcex.dto.TodoDTO;
import com.jdbcex.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList......");
        log.info(voList);
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
                // vo가 들어가서 TodoDTO로 변환하겠다.
                // 변환된 것들을 list로 수집하겠다.
                // 이러한 과정을 통해 객체로 저장된다.
                // modelMapper를 이용하여 서로서로 변환하는 작업

        return dtoList;
    }

    public TodoDTO get(Long tno) throws Exception {
        log.info("tno: " + tno);
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    public void remove(Long tno) throws Exception {
        log.info("tno: " + tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO) throws Exception {
        log.info("todoDTO: " + todoDTO);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        dao.updateOne(todoVO);
    }
}
