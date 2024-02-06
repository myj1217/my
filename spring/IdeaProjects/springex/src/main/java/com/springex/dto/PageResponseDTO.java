package com.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
// 제네릭 기호를 이용하는 이유는 나중에 다른 종류의 객체를 이용해서
// PageResponseDTO를 구성할 수 있도록 하기 위함이다.
// (게시판, 회원 정보 등도 페이징 처리가 필요할 수 있기 때문에
// 공통적인 처리를 위해서 제네릭으로 구성한다.)
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;

    // 시작 페이지 번호
    private int start;
    // 끝 페이지 번호
    private int end;

    // 이전 페이지의 존재 여부
    private boolean prev;
    // 다음 페이지의 존재 여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        // 페이징 처리는 공식화되어 있음.

        this.end = (int)(Math.ceil(this.page / 10.0)) * 10; // 마지막 페이지
        this.start = this.end - 9; // 시작 페이지

        int last = (int)(Math.ceil((total/(double)size))); // 마지막 페이지를 비교하기 위한 처리

        // 마지막 페이지는 last보다 작은 경우 last, 클 경우 end
        this.end = end > last ? last : end;

        // 이전 페이지의 존재 여부 (1보다 크면 페이지가 있음)
        // 시작페이지가 1이 아니라면 true
        this.prev = this.start > 1;

        // next 페이지는 end와 페이지당 개수(size)를 곱한 값보다 전체개수가 더 많으면 next가 더 있다
        this.next = total > this.end * this.size;
    }
}
