package com.b01.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity // 영속 컨텍스트에서 관리하는 엔티티
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 실행시 board를 이중 출력하게 되므로 배제시켜야 한다. - 안그러면 무한루프
@ToString(exclude = "board")
public class BoardImage implements Comparable<BoardImage>{
    // Comparable : 정렬 인터페이스
    @Id // uuid를 id로 할 것이다.
    private String uuid;

    private String fileName;
    private int ord;

    // 무조건 앞(지금은 Many)이 class 이름(지금은 BoardImage)이다.
    // Many: BoardImage, One: Board
    @ManyToOne
    private Board board;

    // 여러 명을 상대해야 하므로 정렬이 필요하다.
    @Override
    public int compareTo(BoardImage other) {
        // this.ord: 현재 객체, other.ord: 비교대상 객체
        // 결과가 양수인 경우 현재 객체가 대상 객체보다 순서상 뒤에 위치해야 한다.
        // 결과가 음수인 경우 현재 객체가 대상 객체보다 순서상 앞에 위치해야 한다.
        // 0인 경우 두 객체의 순서가 같다.
        return this.ord - other.ord;
        // 3 - 4 = -1 이면은
        // 3 - 2 = 1
        // 3 - 3 = 0
    }
    public void changeBoard(Board board) {
        this.board = board;
    }
}
