package com.mallapi.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mallapi.domain.Todo;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test1(){

        log.info("----------------------------");   
        log.info(todoRepository);
    }

  @Test
  public void testInsert() {

    for (int i = 1; i <= 100; i++) {

      Todo todo = Todo.builder()
      .title("Title..." + i)
      .dueDate(LocalDate.of(2024,12,31))
      .writer("user00")
      .build();

      todoRepository.save(todo);
    }
  }

  @Test
  public void testModify() {

    Long tno = 100L;

    java.util.Optional<Todo> result = todoRepository.findById(tno); //java.util 패키지의 Optional

    Todo todo = result.orElseThrow();
    todo.changeTitle("Modified 100...");
    todo.changeComplete(true);
    todo.changeDueDate(LocalDate.of(2024,10,10));

    todoRepository.save(todo);

  }
    
}