package com.b01.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime regDate; // 리플단시간

    @JsonIgnore// 댓글 수정 시간의 경우 화면에 출력할일이 없으므로 json으로 변환할때 제외.
    private LocalDateTime modDate; // 리플수정한시간
}