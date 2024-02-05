package com.springex.mapper;

import com.springex.domain.TodoVO;

import java.util.List;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();
}
