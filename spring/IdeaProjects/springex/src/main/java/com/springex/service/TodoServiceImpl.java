package com.springex.service;

import com.springex.domain.TodoVO;
import com.springex.dto.TodoDTO;
import com.springex.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
// final로 처리한 친구들을 bean으로 만들어주는 어노테이션
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    // Service에서 직접 설정하지 않고 Override를 통해 수정
    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        // todoDTO를 TodoVO로 변환
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        // todoVO로 잘 변환되었는지 출력
        log.info(todoVO);
        todoMapper.insert(todoVO);
    }
    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }
}
