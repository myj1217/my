package com.springex.service;

import com.springex.dto.PageRequestDTO;
import com.springex.dto.PageResponseDTO;
import com.springex.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void register(TodoDTO todoDTO);
    //List<TodoDTO> getAll();

    // PageRequestDTO를 이용해서 응답받겠다.
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
    TodoDTO getOne(Long tno);
    void remove(Long tno);
    void modify(TodoDTO todoDTO);
}
