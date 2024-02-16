package com.b01.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    // 리플은 항상 게시글에 의존되어 있다.
    private Long rno; // 리플 번호
    @NotNull
    private Long bno; // 게시글 번호
    @NotEmpty
    private String replyText;
    @NotEmpty
    private String replyer;
    private LocalDateTime regDate, modDate; // 리플단시간, 리플수정한시간
}
