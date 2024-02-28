package com.mallapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mallapi.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}