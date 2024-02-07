package com.springex.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {
    @Builder.Default
    @Min(value = 1)
    // 해당 필드가 무조건 양수여야 한다.
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    private String link;

    // 검색 종류
    private String[] types;
    // 제목, 작성자 검색에 사용하는 문자열
    private String keyword;
    // 완료 여부에 사용되는 boolean
    private boolean finished;
    // 시작 날짜
    private LocalDate from;
    // 끝 날짜
    private LocalDate to;

    // 마이바티스는 기본적으로 get을 인식함
    public int getSkip() {
        return (page - 1) * 10;
    }

    // String 문자열 고정
    // 문자열 연결 연산을 수행할 때 String 클래스 대신 StringBuilder를 사용하는 것이 성능면에서 좋다.
    // StringBuilder는 가변적인 문자열을 효율적으로 처리하는데 도움이 된다.
//    public String getLink() {
//        if(link == null) {
//            StringBuilder builder = new StringBuilder();
//            builder.append("page=" + this.page);
//            builder.append("&size=" + this.size);
//            link = builder.toString();
//        }
//        return link;
//    }
    public String getLink() {
        // 텍스트 이어쓰기에 적합한 클래스 - 가변적으로 처리
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);

        if (finished) {
            // 빌더에 접근하여 추가
            // boolean을 처리했던 값을 인식 가능한 on으로 바꿈
            builder.append("&finished=on");
        }

        if (types != null && types.length > 0) {
            for (int i = 0; i < types.length; i++) {
                builder.append("&types=" + types[i]);
            }
        }

        if (keyword != null) {
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if (from != null) {
            builder.append("&from=" + from.toString());
        }

        if (to != null) {
            builder.append("&to=" + to.toString());
        }

        // 이 모든 내용을 String으로 변환한다.
        return builder.toString();
    }

    public boolean checkType(String type) {
        if (types == null || types.length == 0) {
            return false;
        }
        // Arrays.stream : 병렬로 나열해서 받는다.
        // anyMatch : 배열 요소 중에서 하나라도 type과 일치하는지 확인하는 메서드
        // equals 메서드가 types 배열의 요소 중 하나와 type을 비교하여 일치하는지 확인
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
