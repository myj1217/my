package com.b01.controller;

import com.b01.security.dto.MemberJoinDTO;
import com.b01.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/login")
    public void loginGET(@RequestParam(name = "error", required = false) String error,
                         @RequestParam(name = "logout", required = false) String logout) {
        log.info("login get ......");
        log.info("logout: " + logout);

        if (logout != null) {
            log.info("user logout......");
        }
    }
    @GetMapping("/join")
    public void joinGET() {
        log.info("join get...");
    }
    @PostMapping("/join") // RedirectAttributes : 리다이렉트 후에도 데이터를 유지하고 전달하는데 사용.
    public String joinPOST(MemberJoinDTO memberJoinDTO, RedirectAttributes redirectAttributes) {
        log.info("join post...");
        log.info(memberJoinDTO);

        try {
            memberService.join(memberJoinDTO);
        } catch (MemberService.MidExistException e) {
            redirectAttributes.addFlashAttribute("error", "mid");
            return "redirect:/member/join";
        }

        redirectAttributes.addFlashAttribute("result", "success");

        return "redirect:/member/login"; // 회원가입 후 로그인
    }
}
