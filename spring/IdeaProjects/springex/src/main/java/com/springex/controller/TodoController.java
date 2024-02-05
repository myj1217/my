package com.springex.controller;

import com.springex.dto.TodoDTO;
import com.springex.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo") // todo를 통해서 들어와라
@Log4j2
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @RequestMapping("/list")
    public void list() {
        log.info("todo list ......");
    }
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public void register() {
//        log.info("todo register ~~~~~~");
//    }
    // @RequestMapping(value="/register", method=Request.
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register ~~~~~~");
    }
    // Post는 무언가 받는 것이 있어야 한다.
//    @PostMapping("/register")
//    public String registerPost(TodoDTO todoDTO, RedirectAttributes redirectAttributes) {
//        log.info("POST todo register ~~~~~~");
//        log.info(todoDTO);
//
//        return "redirect:/todo/list"; // PRG 패턴
//    }
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
}
