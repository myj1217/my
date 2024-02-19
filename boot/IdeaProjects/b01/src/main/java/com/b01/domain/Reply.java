package com.b01.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Reply", indexes = {@Index(name = "idx_reply_board_bno", columnList = "board_bno")})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
public class Reply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    // 다대일
    // 변동이 많은 것이 Many
    @ManyToOne(fetch = FetchType.LAZY) // Many: Reply, One : Board
    private Board board;
    private String replyText;
    private String replyer;

    public void changeText(String text) {
        this.replyText = text;
    }
}
