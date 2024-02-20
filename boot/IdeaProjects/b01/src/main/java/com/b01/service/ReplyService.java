package com.b01.service;

import com.b01.dto.PageRequestDTO;
import com.b01.dto.PageResponseDTO;
import com.b01.dto.ReplyDTO;

public interface ReplyService {
    Long register(ReplyDTO replyDTO);
    ReplyDTO read(Long rno);
    void modify(ReplyDTO replyDTO);
    void remove(Long rno);
    // 실제 반환되어야 하는 타입은 Reply가 아니라 ReplyDTO 타입이다.
    PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO);
}
