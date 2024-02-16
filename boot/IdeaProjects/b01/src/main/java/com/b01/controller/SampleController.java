package com.b01.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class SampleController {
    @Operation(summary = "hello") // openAPI 때문에 추가
    @GetMapping("/hello")
    public void hello(Model model) {
        log.info("hello~~~~~~");
        model.addAttribute("msg", "HELLO WORLD");
    }
}
