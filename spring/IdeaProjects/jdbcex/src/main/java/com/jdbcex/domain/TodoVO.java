package com.jdbcex.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
// @Builder: 객체 생성 할 수 있음
@Builder
@ToString
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 생성하겠다.
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자를 생성하겠다. (모든 필드를 초기화)
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
