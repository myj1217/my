package com.b01.repository.search;

import com.b01.domain.Board;
import com.b01.dto.BoardListReplyCountDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<Board> search1(Pageable pageable);
    Page<Board> searAll(String[] types, String keyword, Pageable pageable);
    Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable);
}
