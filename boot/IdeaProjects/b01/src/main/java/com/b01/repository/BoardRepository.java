package com.b01.repository;

import com.b01.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// 규칙을 넣을 거라 interface
// JpaRepository<Type, ID>
public interface BoardRepository extends JpaRepository<Board, Long> {
    // Board 엔티티는 데이터베이스의 테이블에 대응되며 JpaRepository를 통해
    // 해당 테이블의 레코드를 생성, 조회, 수정, 삭제하는데 사용된다.
    // Long은 Board 엔티티의 식별자(primary key)이고 이 식별자를 통해
    // 레코드를 고유하게 식별한다. (레코드 = 한 행 = DTO(feat. Spring))
}
