package com.b01.controller;

import com.b01.dto.BoardDTO;
import com.b01.dto.BoardListReplyCountDTO;
import com.b01.dto.PageRequestDTO;
import com.b01.dto.PageResponseDTO;
import com.b01.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@Log4j2
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        // 우리가 실제로 처리해야 하는 것 : BoardDTO
        // model의 역할 : jsp나 tymleaf에 전달하는 역할
        // PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        PageResponseDTO<BoardListReplyCountDTO> responseDTO = boardService.listWithReplyCount(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);
    }

    @GetMapping("/register")
    public void registerGET() {

    }

    @PostMapping("/register")
    public String registerPost(@Valid BoardDTO boardDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("board POST register ---------");
        // 에러 처리
        if (bindingResult.hasErrors()) {
            log.info("has error ~~~~~~~~~");
            // 에러 잠깐 표시 (Flash)
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/board/register";
        }
        log.info(boardDTO);
        Long bno = boardService.register(boardDTO);
        // 잠깐 저장해서 보여줌
        // bno가 식별키 역할을 함
        redirectAttributes.addFlashAttribute("result", bno);
        return "redirect:/board/list";
    }

    // 두가지 이상 처리할 때는 변수 괄호 {} 있어야 함
    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam(name ="bno") Long bno, PageRequestDTO pageRequestDTO, Model model) {
        BoardDTO boardDTO = boardService.readOne(bno);
        log.info(boardDTO);
        model.addAttribute("dto", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO, @Valid BoardDTO boardDTO,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        log.info("board modify post ______" + boardDTO);
        if (bindingResult.hasErrors()) {
            log.info("has error ~~~~~~~~~");
            String link = pageRequestDTO.getLink();
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("bno", boardDTO.getBno());
            // 그 주소가 유지되게끔
            return "redirect:/board/modify?"+link;
        }
        boardService.modify(boardDTO);
        redirectAttributes.addFlashAttribute("result", "modified");
        redirectAttributes.addAttribute("bno", boardDTO.getBno());
        return "redirect:/board/read";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam(name ="bno") Long bno, RedirectAttributes redirectAttributes) {
        log.info("remove post _________" + bno);
        boardService.remove(bno);
        redirectAttributes.addFlashAttribute("result", "removed");
        return "redirect:/board/list";
    }
}
