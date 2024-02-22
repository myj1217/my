package com.b01.repository.search;

import com.b01.domain.Board;
import com.b01.domain.QBoard;
import com.b01.domain.QReply;
import com.b01.dto.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

// Spring Data JPA의 리포지토리를 지원하기 위한 기본 클래스
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {
    // QuerydslRepositorySupport를 사용하면 Querydsl을 이용해서 JPA 엔티티에 대한 동적 쿼리를 작성할 수 있다.
    // QuerydslRepositorySupport 클래스를 사용하려면 어떤 엔티티에 대한 쿼리를 실행할 것인지 명시해야 한다.

    // super(명시할 클래스);
    // Board 엔티티에 대한 동적 쿼리를 작성하고 실행할 수 있게 된다.
    public BoardSearchImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> search1(Pageable pageable) {

        QBoard board = QBoard.board; // Q도메인 객체
        // @Query로 작성했던 JPQL을 코드를 통해서 생성할 수 있게 해준다.
        // where이나 group by 혹은 join 처리 등이 가능하다.
        JPQLQuery<Board> query = from(board); // from 엔티티 객체 이름

        // 불리언빌더를 사용하겠다.
        BooleanBuilder booleanBuilder = new BooleanBuilder();

        // title에 11이 포함되거나
        booleanBuilder.or(board.title.contains("11"));
        // content에 11이 포함되거나
        booleanBuilder.or(board.content.contains("11"));

        query.where(booleanBuilder);
        query.where(board.bno.gt(0L)); // gt = 큰 , 작은은 lt

        // query.where(board.title.contains("1")); // where 조건

        // paging : Querydsl 실행 시에 Pageable을 처리하는 방법
        this.getQuerydsl().applyPagination(pageable, query);

        // JPQLQuery에서 실행하기 위해선 fetch()라는 메서드를 사용한다.
        List<Board> list = query.fetch();

        long count = query.fetchCount();

        return null;
    }
    @Override
    public Page<Board> searAll(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        JPQLQuery<Board> query = from(board);

        if((types != null && types.length > 0) && keyword != null) { // 검색 조건과 키워드가 있다면
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for (String type: types) {
                switch (type) { // 셋 중에 하나만 만족해도 true
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }
            } // end for
            query.where(booleanBuilder);
        } // end if

        // bno > 0
        query.where(board.bno.gt(0L));

        // paging
        this.getQuerydsl().applyPagination(pageable, query);

        // 쿼리를 실행해서 list 타입을 변환
        List<Board> list = query.fetch();

        long count = query.fetchCount();

        // list : 실제 목록 데이터, pageable : 페이지 관련 정보를 가진 객체, count : 전체 개수
        return new PageImpl<>(list, pageable, count);
    }

    @Override
    public Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        QReply reply = QReply.reply;
        JPQLQuery<Board> query = from(board);
        // 게시글이 있다고 해서 꼭 댓글이 있는 것은 아니기 때문에,
        // 왼쪽 테이블의 모든 레코드와 오른쪽 테이블의 일치하는 레코드가 반환, 일치하지 않는 경우 NULL 반환.
        query.leftJoin(reply).on(reply.board.eq(board)); // 일일히 순차적으로 반환
        // board와 연결된 reply 레코드를 검색.
        // reply 테이블의 board 칼럼과 board 테이블의 id 칼럼이 서로 같은지 비교
        query.groupBy(board);

        if((types != null && types.length > 0) && keyword != null) {
            // 여러 개의 조건을 하나의 조건으로 결합.
            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type: types) {
                switch (type) {
                    case "t":
                        // board 에 있는 title 칼럼에
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }
            }
            // query에 조건식을
            query.where(booleanBuilder);

            // bno > 0
            query.where(board.bno.gt(0L));
        }

        JPQLQuery<BoardListReplyCountDTO> dtoQuery =
                // Projections.bean을 이용해서 원하는 필드를 선택하고,
                query.select(Projections.bean(BoardListReplyCountDTO.class,
                        board.bno,
                        board.title,
                        board.writer,
                        board.regDate,
                        reply.count().as("replyCount"))); // 게시글의 댓글 수를 선택
                        // 리플의 개수를 반환하겠다.

        this.getQuerydsl().applyPagination(pageable,dtoQuery);
        List<BoardListReplyCountDTO> dtoList = dtoQuery.fetch();

        long count = dtoQuery.fetchCount();

        return new PageImpl<>(dtoList, pageable, count);
    }
    @Override
    public Page<BoardListAllDTO> searchWithAll(String[] types, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        QReply reply = QReply.reply;

        JPQLQuery<Board> boardJPQLQuery = from(board);
        // board와 reply를 왼쪽으로 join할 것이다. reply와 일치하는 레코드가 없으면 null값을 갖게 된다.
        boardJPQLQuery.leftJoin(reply).on(reply.board.eq(board)); // left join

        // 페이징 처리하기 전에 검색조건과 키워드를 사용하는 부분의 코드
        if ((types != null && types.length > 0) && keyword != null) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            for (String type:types) {
                switch (type) {
                    case "t":
                        booleanBuilder.or(board.title.contains(keyword));
                        break;
                    case "c":
                        booleanBuilder.or(board.content.contains(keyword));
                        break;
                    case "w":
                        booleanBuilder.or(board.writer.contains(keyword));
                        break;
                }
            } // end for
            boardJPQLQuery.where(booleanBuilder);
        }

        boardJPQLQuery.groupBy(board);

        getQuerydsl().applyPagination(pageable, boardJPQLQuery); // paging

        // Tuple를 생성하고 select()를 사용하여 Board와 댓글의 고유한 개수를 선택하여 쿼리로 반환.
        JPQLQuery<Tuple> tupleJPQLQuery = boardJPQLQuery.select(board, reply.countDistinct());
        // fetch()를 실행하여 결과를 List<Tuple>로 검색하여 결과 가져오기.
        List<Tuple> tupleList = tupleJPQLQuery.fetch();

        // 게시판 정보와 댓글 수를 포함. 변환해서 갖고옴.
        List<BoardListAllDTO> dtoList = tupleList.stream().map(tuple -> {
            Board board1 = (Board) tuple.get(board);
            long replyCount = tuple.get(1, Long.class);

            BoardListAllDTO dto = BoardListAllDTO.builder()
                    .bno(board1.getBno())
                    .title(board1.getTitle())
                    .writer(board1.getWriter())
                    .regDate(board1.getRegDate())
                    .replyCount(replyCount)
                    .build();

            // BoardImage를 BoardImageDTO 처리할 부분
            List<BoardImageDTO> imageDTOS = board1.getImageSet().stream().sorted()
                    .map(boardImage -> BoardImageDTO.builder()
                            .uuid(boardImage.getUuid())
                            .fileName(boardImage.getFileName())
                            .ord(boardImage.getOrd())
                            .build()
                    ).collect(Collectors.toList());
            dto.setBoardImages(imageDTOS); // 처리된 BoardImageDTO들을 추가

            return dto;
        }).collect(Collectors.toList());

        // 총 게시글 수를 조회. 쿼리 조건에 일치하는 Board 레코드의 전체 개수를 가져와
        // 클라이언트에게 전체 레코드 수에 대한 정보를 제공.
        long totalCount = boardJPQLQuery.fetchCount();

        // 객체 리스트, 페이지 정보, 전체 개수
        return new PageImpl<>(dtoList, pageable, totalCount);
    }
}
