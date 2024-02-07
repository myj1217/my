package com.springex.controller;

import com.springex.dto.PageRequestDTO;
import com.springex.dto.TodoDTO;
import com.springex.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor

public class TodoController {

    private final TodoService todoService;

    @RequestMapping("/list")
//    public void list(Model model) {
//        log.info("todo list...............");
//        model.addAttribute("dtoList", todoService.getList());
//    }
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
        log.info(pageRequestDTO);

        if (bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }


    //    @RequestMapping(value="/register", method = RequestMethod.GET)
    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register~~~~~");
    }

    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes ) {
        // @Valid TodoDTO로 먼저 검증하고 이후 남은 것에 대한 검증이 BindingResult이므로 순서 중요!

        log.info("POST todo register~~~~~");

        if(bindingResult.hasErrors()) {
            log.info("has errors!!!!!!!!");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        todoService.register(todoDTO);

        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam(name = "tno") Long tno, PageRequestDTO pageRequestDTO, Model model) {

        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, PageRequestDTO pageRequestDTO) {
        if (bindingResult.hasErrors()) {
            log.info("has error~~~~~~~~~~~");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        log.info(todoDTO);

        todoService.modify(todoDTO);
        redirectAttributes.addAttribute("tno",todoDTO.getTno());

        return "redirect:/todo/read";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam(name = "tno") Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {

        log.info("-------------remove-------------");
        log.info("tno: " + tno);

        todoService.remove(tno);

        redirectAttributes.addAttribute("page", 1);
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());

        return "redirect:/todo/list?" + pageRequestDTO.getLink();
    }
}