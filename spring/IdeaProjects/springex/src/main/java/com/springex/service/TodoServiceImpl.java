package com.springex.service;

import com.springex.domain.TodoVO;
import com.springex.dto.PageRequestDTO;
import com.springex.dto.PageResponseDTO;
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
//    @Override
//    public List<TodoDTO> getAll() {
//        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
//                .map(vo -> modelMapper.map(vo, TodoDTO.class))
//                .collect(Collectors.toList());
//
//        return dtoList;
//    }
    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        List<TodoDTO> dtoList = voList.stream()
                // 순차적으로 접근해서 DTO로 변환
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        int total = todoMapper.getCount(pageRequestDTO);

        // 제네릭 타입을 사용하기 위해 withAll이라는 메서드를 선언하고 호출함
        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }
    @Override
    public TodoDTO getOne(Long tno) {
        // TodoVO를 받고
        TodoVO todoVO = todoMapper.selectOne(tno);
        // TodoDTO의 클래스를 변환한다.
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }
    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }
    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        todoMapper.update(todoVO);
    }
}
