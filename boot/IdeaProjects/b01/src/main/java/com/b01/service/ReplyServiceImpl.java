package com.b01.service;

import com.b01.domain.Reply;
import com.b01.dto.PageRequestDTO;
import com.b01.dto.PageResponseDTO;
import com.b01.dto.ReplyDTO;
import com.b01.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.b01.domain.QReply.reply;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService{
    private final ReplyRepository replyRepository;
    private final ModelMapper modelMapper;

    // 댓글 등록 메서드
    @Override
    public Long register(ReplyDTO replyDTO) {
        // DTO를 Entity로 변환
        Reply reply = modelMapper.map(replyDTO, Reply.class);
        // Repository를 통해 Entity를 저장하고, 저장된 엔티티의 rno를 반환
        Long rno = replyRepository.save(reply).getRno();
        return rno;
    }

    // 댓글 조회 메서드
    @Override
    public ReplyDTO read(Long rno) {
        // Repository를 통해 rno에 해당하는 댓글을 조회
        Optional<Reply> replyOptional = replyRepository.findById(rno);
        // 조회된 결과가 있으면 해당 댓글을 DTO로 변환하여 반환
        Reply reply = replyOptional.orElseThrow(); // 예외 처리 필요
        return modelMapper.map(reply, ReplyDTO.class);
    }

    // 댓글 수정 메서드
    @Override
    public void modify(ReplyDTO replyDTO) {
        // 수정할 댓글을 ID로 조회
        Optional<Reply> replyOptional = replyRepository.findById(replyDTO.getRno());
        Reply reply = replyOptional.orElseThrow(); // 예외 처리 필요
        // 댓글의 내용을 수정
        reply.changeText(replyDTO.getReplyText()); // 댓글의 내용만 수정 가능
        // 수정된 댓글을 저장
        replyRepository.save(reply);
    }

    // 댓글 삭제 메서드
    @Override
    public void remove(Long rno) {
        replyRepository.deleteById(rno);
    } // ID로 댓글 삭제

    // 게시글에 속한 댓글 목록 조회 메서드
    @Override
    public PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO) {
        // 페이지 요청 정보를 기반으로 페이지네이션 정보 생성
        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() <= 0 ?
                0 : pageRequestDTO.getPage() - 1, pageRequestDTO.getSize(),
                Sort.by("rno").ascending());

        // 해당 게시글의 댓글 목록 조회
        // 반환은 Reply
        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        // 조회된 댓글을 DTO로 변환하여 리스트에 저장
        // DTO로 변환한 후 List로 저장
        List<ReplyDTO> dtoList = result.getContent().stream()
                .map(reply -> modelMapper.map(reply, ReplyDTO.class))
                .collect(Collectors.toList());

        // 페이지 응답 DTO 생성 및 반환
        return PageResponseDTO.<ReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }
}
