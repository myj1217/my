package com.b01.repository;

import com.b01.domain.Board;
import com.b01.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    // 쿼리 메서드, findBy..., get...
    // title 필드의 값이 주어진 keyword를 포함하고 있는 데이터를 검색.
    // Containing: 특정 필드의 값을 포함하는 엔티티를 찾는 역할을 한다.
    Page<Board> findByTitleContainingOrderByBnoDesc(String keyword, Pageable pageable);

    // :keyword에 해당하는 파라미터를 가지고 있으면 concat이 문자열을 합치는 메서드이므로
    // keyword에 포함된 '우리학교' 키워드에 학교를 입력하면 우리학교 키워드가 검색되도록 해라.
    @Query("select b from Board b where b.title like concat('%', :keyword, '%')")
    Page<Board> findkeyword(String keyword, Pageable pageable);

    @Query(value = "select now()", nativeQuery = true)
    String getTime();

    // 들어온 bno 값을 select해서 반환하겠다.
    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select b from Board b where b.bno =:bno")
    Optional<Board> findByIdWithImages(@Param("bno") Long bno);
}
