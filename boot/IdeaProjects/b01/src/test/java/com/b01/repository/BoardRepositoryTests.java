package com.b01.repository;

import com.b01.domain.Board;
import com.b01.dto.BoardListReplyCountDTO;
import com.b01.repository.search.BoardSearch;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    // BoardRepository = JpaRepository를 상속받았던 친구
    private BoardRepository boardRepository;

    @Autowired
    private BoardSearch boardSearch;

    @Test
    public void testInsert() {
        // 1부터 100까지의 정수들을 생성하는 스트림
        IntStream.rangeClosed(1, 100).forEach((i -> {
            Board board = Board.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .writer("user" + (i % 10))
                    .build();

            // boardRepository를 사용하기 위해 가지고 왔다. - 의존성 주입
            // Spring에서는 일일히 가져와야 했다. - 그래서 Spring이 도태됨.
            Board result = boardRepository.save(board);
            // result에 접근해서 Bno 값을 보고싶은거야.
            log.info("BNO: " + result.getBno());
        }));
    }

    @Test
    public void testSelect() {
        Long bno = 100L;
        Optional<Board> result = boardRepository.findById(bno);
        // orElseThrow : null 값을 받아올 때 에러로 표기하지 않고 값을 받아올 수 있다.
        Board board = result.orElseThrow();
        log.info(board);
    }

    @Test
    public void testUpdate() {
        Long bno = 100L;
        Optional<Board> result = boardRepository.findById(bno); // 첫번째 메서드 (findById)
        Board board = result.orElseThrow(); // exception 처리
        board.change("update___title 100", "update content 100");
        boardRepository.save(board); // 두번째 메서드 (save)
    }

    @Test
    public void testDelete() {
        Long bno = 1L;
        boardRepository.deleteById(bno);
    }

    @Test
    public void testPaging() {
        // 1 page order by bno desc
        // PageRequest.of(페이지 번호, 사이즈, Sort.Direction, 속성 ...)
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.findAll(pageable);

        // 총 개수 우린 99개
        log.info("total count: "+result.getTotalElements());
        // 페이지는 10 까지
        log.info("total pages: "+result.getTotalPages());
        // 시작 페이지 0
        log.info("page number: "+result.getNumber());
        // 페이지 사이즈는 10
        log.info("page size: "+result.getSize());
        // Board 를 List 화해서 todoList 에 담음
        List<Board> todoList = result.getContent();
        // 그걸 하나씩 로그로 보갰다
        todoList.forEach(board -> log.info(board));
    }

//    @Test
//    public void testSearch1() {
//        // 2page order by bno desc
//        Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());
//        // boardSearch.search1(pageable);
//
//        boardRepository.search1(pageable);
//    }
//
//    @Test
//    public void testSearchAll() {
//        String[] types = {"t", "c", "w"};
//
//        String keyword = "1";
//
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
//
//        Page<Board> result = boardRepository.searAll(types, keyword, pageable);
//    }

    @Test
    public void testSearchAll2() {
        String[] types = {"t", "c", "w"};

        String keyword = "1";

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.searAll(types, keyword, pageable);

        // total pages
        log.info(result.getTotalPages());

        // page size
        log.info(result.getSize());

        // pageNumber
        log.info(result.getNumber());

        // page next
        log.info(result.hasPrevious() + ": " + result.hasNext());

        result.getContent().forEach(board -> log.info(board));
    }

    @Test
    public void testSearchReplyCount(){
        String[] types = {"t", "c", "w"};

        String keyword = "1"; // 원하는 키워드 넣어도 됨.

        Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());

        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types, keyword, pageable);

        // total pages
        log.info(result.getTotalPages());

        // page size
        log.info(result.getSize());

        // pageNumber
        log.info(result.getNumber());

        // prev next
        log.info(result.hasPrevious() + ": " + result.hasNext());

        result.getContent().forEach(board -> log.info(board));
    }
}
