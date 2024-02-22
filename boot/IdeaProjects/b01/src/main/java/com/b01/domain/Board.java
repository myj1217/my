package com.b01.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.Set;

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

    // 양방향인 상태에서 연관관계의 주인이 board
    @OneToMany(mappedBy = "board", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default // 초기화하지 않고 값을 그대로 가져다 쓴다.
    @BatchSize(size=20) // BoardImage를 조회할 때 한번에 조건범위만큼 처리한다.
    private Set<BoardImage> imageSet = new HashSet<>();
    // 파일명이 중복되는 것을 허용하지 않겠다.

    public void addImage(String uuid, String fileName) {
        BoardImage boardImage = BoardImage.builder()
                .uuid(uuid)
                .fileName(fileName)
                .board(this) // this는 board를 의미한다.
                .ord(imageSet.size()) // 개수에 맞는 사이즈
                .build();
        imageSet.add(boardImage);
    }
    // 첨부파일을 모두 삭제, BoardImage 객체의 Board 참조를 null로 변경.
    public void clearImages() {
        imageSet.forEach(boardImage -> boardImage.changeBoard(null));
        // board의 imageSet 비운다.
        // board 객체가 소유하고 있는 imageSet에 있는 모든 boardImage 객체들과 연결을 끊을 수 있다.
        // 그러면서 boardImage 객체들도 자신이 참조하고 있는 board 객체와의 연결을 끊을 수 있다.
        this.imageSet.clear();
        // 양방향 참조를 유지하면서 한쪽의 연결만 끊으면 데이터의 일관성이 깨질 수 있으므로
        // 양쪽 모두에서 연결을 끊는 작업을 수행하는 것이 중요하다.
    }
}
