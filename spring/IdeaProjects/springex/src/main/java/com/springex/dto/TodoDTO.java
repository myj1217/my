package com.springex.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;
    @NotEmpty // 비어있지 않아야 한다.
    private String title;
    @Future // 날짜와 시간이 현재 날짜 이후인지 확인
    private LocalDate dueDate;
    private boolean finished;
    @NotEmpty
    private String writer; // 새로 추가
}
