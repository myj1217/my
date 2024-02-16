package com.b01.controller;

import com.b01.dto.ReplyDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
public class ReplyController {
    // summary : 제목 , description : 설명
    @Operation(summary = "Replies POST", description = "POST 방식으로 댓글 등록")
    // consumes : 어떤 방식으로 처리하냐? - JSON 타입으로 처리하겠다.
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    // Map : <key, value>로 하겠다.
    // @RequestBody : JSON 타입으로 변환해서 DTO로 받겠다.
    public Map<String, Long> register(@Valid @RequestBody ReplyDTO replyDTO,
                                      BindingResult bindingResult) throws BindException {
        log.info(replyDTO);

        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }

        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("rno", 111L);

        return resultMap;
    }
}
