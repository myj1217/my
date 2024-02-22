package com.b01.repository;

import com.b01.domain.Board;
import com.b01.domain.BoardImage;
import com.b01.dto.BoardListAllDTO;
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
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert(){
        // 주어진 범위 내의 정수들을 생성하는 스트림
        IntStream.rangeClosed(1,100).forEach((i ->{
            Board board = Board.builder()
                    .title("title"+i)
                    .content("content"+i)
                    .writer("user"+(i % 10)).build();

            Board result = boardRepository.save(board);
            log.info("BNO: " + result.getBno());

        }));
    }

    @Test
    public void testSelect(){
        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno);

        //Optional이 비어있으면 orElseThrow();
        Board board = result.orElseThrow();

        log.info(board);
    }

    @Test
    public void testUpdate(){
        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();

        board.change("update____title 100", "update content 100");

        boardRepository.save(board);
    }

    @Test
    public void testDelete(){
        Long bno = 2L;

        boardRepository.deleteById(bno);
    }

    @Test
    public void testPaging(){
        // PageRequest.of(페이지 번호, 사이즈, Sort.Direction, 속성....)
        Pageable pageable =
                PageRequest.of(0,10, Sort.by("bno")
                        .descending());

        Page<Board> result = boardRepository.findAll(pageable);

        log.info("total count: "+result.getTotalElements());
        log.info("total pages: "+result.getTotalPages());
        log.info("page number: " +result.getNumber());
        log.info("page size: "+ result.getSize());

        List<Board> todoList = result.getContent();

        todoList.forEach(board -> log.info(board));
    }

    @Test
    public void testSearch1(){
        // 2 page order by bno desc
        Pageable pageable = PageRequest.of(1,10,Sort.by("bno")
                .descending());

        boardRepository.search1(pageable);
    }

    @Test
    public void testSearchAll(){
        String[] types = {"t", "c", "w"};

        String keyword= "1";

        Pageable pageable = PageRequest.of(0,10,
                Sort.by("bno").descending());

        Page<Board> result = boardRepository.searAll(types, keyword, pageable);
    }

    @Test
    public void testSearchAll2()   {
        String[] types={"t", "c","w"};

        String keyword ="1";

        Pageable pageable = PageRequest.of(0,10,
                Sort.by("bno").descending());

        Page<Board> result = boardRepository.searAll(types, keyword, pageable);

        // total pages
        log.info(result.getTotalPages());

        // page size
        log.info(result.getSize());

        // pageNumber
        log.info(result.getNumber());

        // page next
        log.info(result.hasPrevious() + ": "+result.hasNext());

        result.getContent().forEach(board -> log.info(board));
    }

    @Test
    public void testSearchReplyCount(){

        String[] types = {"t", "c", "w"};

        String keyword = "1";

        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());

        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types, keyword, pageable);

        // total pages
        log.info(result.getTotalPages());

        //page size
        log.info(result.getSize());

        //pageNumber
        log.info(result.getNumber());

        //prev next
        log.info(result.hasPrevious() +": " + result.hasNext());

        result.getContent().forEach(board -> log.info(board));
    }

    @Test
    public void testInsertWithImages(){
        Board board = Board.builder()
                .title("Image test")
                .content("첨부파일 테스트")
                .writer("tester")
                .build();
        for (int i=0; i <3; i++){
            board.addImage(UUID.randomUUID().toString(), "file"+i+".jpg");
        }//end for
        boardRepository.save(board);
    }

    // 조회 테스트
    @Test
    // @Transactional
    public void testReadWithImages() {
        // 반드시 존재하는 bno로 확인
        Optional<Board> result = boardRepository.findByIdWithImages(1L);

        Board board = result.orElseThrow();
        
        log.info(board);
        log.info("------------");
        for (BoardImage boardImage : board.getImageSet()) {
            log.info(boardImage);
        }
    }

    @Transactional
    @Commit // 수행한 작업이 실제로 데이터베이스에 반영.
    @Test
    public void testModifyImages() {
        // 1번 값을 찾는다.
        Optional<Board> result = boardRepository.findByIdWithImages(1L);
        // 에러 확인
        Board board = result.orElseThrow();
        // 기존의 첨부파일들은 삭제
        board.clearImages();
        // 새로운 첨부파일들
        for (int i = 0; i < 2; i++) {
            board.addImage(UUID.randomUUID().toString(), "업데이트" + i + ".jpg");
        }
        boardRepository.save(board);
    }

    @Test
    public void testInsertAll() {
        for (int i = 1; i <= 100; i++) {
            Board board = Board.builder()
                    .title("title"+i)
                    .content("Content"+i)
                    .writer("writer"+i)
                    .build();
            for (int j = 0; j < 3; j++) {
                if (i % 5 == 0) {continue;}
                board.addImage(UUID.randomUUID().toString(), i + "file" + j + ".jpg");
            }
            boardRepository.save(board);
        } // end for
    }

    @Transactional
    @Test
    public void testSearchImageReplyCount() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<BoardListAllDTO> result = boardRepository.searchWithAll(null, null, pageable);

        log.info("------------");
        log.info(result.getTotalElements()); // 게시글 총 개수

        result.getContent().forEach(boardListAllDTO -> log.info(boardListAllDTO));
    }
}