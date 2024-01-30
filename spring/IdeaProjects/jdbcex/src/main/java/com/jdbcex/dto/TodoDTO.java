package com.jdbcex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// TodoVO랑 비슷하다
// 뭐가 다른가? 어노테이션이 다르다

@Builder // 빌드 할 수 있게끔 만들어주는 친구
@Data // 아래 내용을 데이터로 처리하겠다. - get/set/toString/equals/hasCode
@NoArgsConstructor // 매개변수가 없는 기본 생성자를 생성하겠다.
@AllArgsConstructor // 모든 필드를 인자로 받는 생성자를 생성하겠다. (모든 필드를 초기화)
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}

