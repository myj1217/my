package com.b01.repository;

import com.b01.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    // 특정 게시글에 해당하는 댓글을 페이징 처리하여 변환.
    @Query("select r from Reply r where r.board.bno = :bno")
    // Param -> RequestParam
    Page<Reply> listOfBoard(@Param("bno") Long bno, Pageable pageable);

    void deleteByBoard_Bno(Long bno);
}
