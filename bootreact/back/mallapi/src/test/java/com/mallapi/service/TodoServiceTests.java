package com.mallapi.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mallapi.dto.PageRequestDTO;
import com.mallapi.dto.PageResponseDTO;
import com.mallapi.dto.TodoDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoServiceTests {
  
  @Autowired
  private TodoService todoService;

  @Test
  public void testRegister() {

    TodoDTO todoDTO = TodoDTO.builder()
    .title("service test")
    .writer("tester")
    .dueDate(LocalDate.of(2023,10,10))
    .build();

    Long tno = todoService.register(todoDTO);

    log.info("TNO: " + tno);
    
  }

  @Test
  public void testGet() {

    Long tno = 101L;

    TodoDTO todoDTO = todoService.get(tno);

    log.info(todoDTO);

  }

   @Test
  public void testList() {
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
    .page(2)
    .size(10)
    .build();
    PageResponseDTO<TodoDTO> response = todoService.list(pageRequestDTO);
    log.info(response);
  }
}