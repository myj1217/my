package com.springex.controller;

import com.springex.dto.PageRequestDTO;
import com.springex.dto.TodoDTO;
import com.springex.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo") // todo를 통해서 들어와라
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

//    @RequestMapping("/list")
//    public void list(Model model) {
//        log.info("todo list ......");
//        model.addAttribute("dtoList", todoService.getList());
//    }
    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info(pageRequestDTO);
        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register ~~~~~~");
    }
    // Post는 무언가 받는 것이 있어야 한다.
    @PostMapping("/register")
    // Valid로 미리 알려줘야 한다. , 순서대로 처리되기 때문에 순서가 중요하다.
    public String registerPost(@Valid TodoDTO todoDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("POST todo register ~~~~~~");

        // 에러를 발견했으면 ~
        if (bindingResult.hasErrors()) {
            log.info("has errors!!!!!!");
            // addFlashAttribute : 기억 x 결과표출 x (일시적)
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list"; // PRG 패턴
    }
    // 조회
    // dispatch가 하던 것을 model이 다 해준다.
    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam(name = "tno") Long tno, PageRequestDTO requestDTO, Model model) {
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO); // todoDTO로 잘 받아졌는지 로그로 확인

        model.addAttribute("dto", todoDTO);
    }
    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, PageRequestDTO pageRequestDTO) {
        if (bindingResult.hasErrors()) {
            log.info("has errors ~~~~~~");
            // flash : 에러를 잠깐 보여준다.
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            // 해당번호 다시 수정해라.
            return "redirect:/todo/modify";
        }
        log.info(todoDTO);
        todoService.modify(todoDTO);
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        return "redirect:/todo/list";
    }

    // 삭제
    @PostMapping("/remove")
    // redirect : 삭제되면 리스트로 가라
    public String remove(@RequestParam(name = "tno") Long tno,
                         PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {
        log.info("--------remove--------");
        log.info("tno: " + tno);

        todoService.remove(tno);

        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        return "redirect:/todo/list";
    }
}
