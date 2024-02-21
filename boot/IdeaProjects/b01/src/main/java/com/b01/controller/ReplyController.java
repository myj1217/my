package com.b01.controller;

import com.b01.dto.PageRequestDTO;
import com.b01.dto.PageResponseDTO;
import com.b01.dto.ReplyDTO;
import com.b01.service.ReplyService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    // 댓글을 등록하는 POST 메서드
    @Operation(summary = "Replies POST", description = "POST 방식으로 댓글 등록")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    // @Valid 어노테이션을 통해 객체의 유효성을 검증하고, 그 결과를 BindingResult에 저장
    public Map<String, Long> register(@Valid @RequestBody ReplyDTO replyDTO,
                                      BindingResult bindingResult) throws BindException {
        log.info(replyDTO);

        // 만약 바인딩 결과에 오류가 있다면 예외를 던짐
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }

        Map<String, Long> resultMap = new HashMap<>();

        // 댓글 서비스를 통해 댓글을 등록하고, 등록된 댓글의 번호를 가져옴
        Long rno = replyService.register(replyDTO);

        // resultMap에 댓글 번호를 저장
        resultMap.put("rno", rno);

        return resultMap;
    }

    // 특정 게시물의 댓글 목록을 가져오는 GET 메서드
    @Operation(summary = "Replies of Board", description = "GET 방식으로 특정 게시물의 댓글 목록")
    @GetMapping(value = "/list/{bno}") // {bno}를 쓸 수 있는 이유 - @PathVariable 때문
    public PageResponseDTO getList(@PathVariable("bno") Long bno, PageRequestDTO pageRequestDTO) {
        // 댓글 서비스를 통해 특정 게시물의 댓글 목록을 가져옴
        PageResponseDTO<ReplyDTO> responseDTO = replyService.getListOfBoard(bno, pageRequestDTO);

        // 가져온 댓글 목록을 반환
        return responseDTO;
    }

    // 특정 댓글을 조회하는 GET 메서드
    @Operation(summary = "Read Reply", description = "GET 방식으로 특정 댓글 조회")
    @GetMapping(value = "/{rno}")
    public ReplyDTO getReplyDTO(@PathVariable("rno") Long rno) {
        // 댓글 서비스를 통해 특정 댓글을 조회
        ReplyDTO replyDTO = replyService.read(rno);

        // 조회된 댓글을 반환
        return replyDTO;
    }

    // 특정 댓글을 삭제하는 DELETE 메서드
    @Operation(summary = "Delete Reply", description = "DELETE 방식으로 특정 댓글 삭제")
    @DeleteMapping(value = "/{rno}")
    public Map<String, Long> remove(@PathVariable("rno") Long rno) {
        // 댓글 서비스를 통해 특정 댓글을 삭제
        replyService.remove(rno);
        // 삭제된 댓글의 번호를 담을 resultMap 객체 생성
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("rno", rno);

        return resultMap;
    }

    // 특정 댓글을 수정하는 PUT 메서드
    @Operation(summary = "Modify Reply", description = "PUT 방식으로 특정 댓글 수정")
    @PutMapping(value = "/{rno}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> modify(@PathVariable("rno") Long rno,
                                    @RequestBody ReplyDTO replyDTO) {
        // 수정할 댓글의 번호를 ReplyDTO에 설정
        replyDTO.setRno(rno); // 번호를 일치시킴

        replyService.modify(replyDTO);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno); // 추가하는 형식으로 수정

        return resultMap;
    }
}
