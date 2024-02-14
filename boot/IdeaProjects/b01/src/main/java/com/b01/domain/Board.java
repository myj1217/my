package com.b01.domain;

import jakarta.persistence.*;
import lombok.*;

// 도메인이라는 패키지에서 관리한다.

// 기본키를 가지는 자바 객체
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{
    @Id
    // 생성을 할건데 그 값이 , 전략이 제너레이션 타입을 아이덴티티로 해라
    // 이게 뭔소리냐? - 자동으로 생성해라.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 500, nullable = false) // 칼럼의 길이와 null 허용 여부
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
