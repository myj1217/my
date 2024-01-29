package com.demo.todo.service;

import com.demo.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;
    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG......" + todoDTO);
    }
    public List<TodoDTO> getList() {
        // mapToObj: 숫자 범위를 순회하면서 TodoDTO 객체를 생성하고 반환
        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            // 직접 접근하지 못하니까 setter로 접근
            dto.setTno((long)i);
            dto.setTitle("Todo..." + i);
            dto.setDueDate(LocalDate.now());

            return dto;
        }).collect(Collectors.toList()); // 객체로 뭉쳐서 리스트화해서 반환

        return todoDTOS;
    }

    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }

}
