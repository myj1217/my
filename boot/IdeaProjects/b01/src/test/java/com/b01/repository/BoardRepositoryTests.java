package com.b01.repository;

import com.b01.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    // BoardRepository = JpaRepository를 상속받았던 친구
    private BoardRepository boardRepository;

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
}
