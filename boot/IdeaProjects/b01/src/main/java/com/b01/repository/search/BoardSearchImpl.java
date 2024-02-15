package com.b01.repository.search;

import com.b01.domain.Board;
import com.b01.domain.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

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
}
