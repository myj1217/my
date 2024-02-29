package com.b01.controller;

import com.b01.dto.*;
import com.b01.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    @Value("${com.upload.path}")
    private String uploadPath;
    private final BoardService boardService;
    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
//        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        PageResponseDTO<BoardListAllDTO> responseDTO = boardService.listWithAll(pageRequestDTO);
        log.info(responseDTO);
        model.addAttribute("responseDTO", responseDTO);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/register")// register에 USER라는 권한을 가진 사용자가 접근 가능.
    public void registerGET(){

    }

    @PostMapping("/register")
    public String registerPost(@Valid BoardDTO boardDTO, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        log.info("board POST register-----------------");

        if(bindingResult.hasErrors()){
            log.info("has error~~~~~~~~~~~~~~");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/board/register";
        }

        log.info(boardDTO);

        Long bno = boardService.register(boardDTO);

        redirectAttributes.addFlashAttribute("result", bno);

        return "redirect:/board/list";
    }

    // PreAuthorize:사용자의 권한을 검사
    @PreAuthorize("isAuthenticated()")//isAuthenticated: 인증된 사용자만 액세스 할수 있다. 반환값은 인증되었을때는 true, 안되면 false
    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam(name ="bno") Long bno, PageRequestDTO pageRequestDTO, Model model){

        BoardDTO boardDTO = boardService.readOne(bno);

        log.info(boardDTO);

        model.addAttribute("dto", boardDTO);
    }
    // 게시물 수정은 현재 로그인한 사용자와 게시물의 작성자가 정보와 일치할때만 삭제할수 있어야 한다.
    @PreAuthorize("principal.username == #boardDTO.writer")
    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO, @Valid @ModelAttribute("boardDTO") BoardDTO boardDTO,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("board modify post_______" + boardDTO);
        if(bindingResult.hasErrors()){
            log.info("has errors~~~~~~~~~~~~");
            String link = pageRequestDTO.getLink();
            redirectAttributes.addFlashAttribute("errors",
                    bindingResult.getAllErrors());
            redirectAttributes.addAttribute("bno", boardDTO.getBno());
            return "redirect:/board/modify?"+link;
        }
        boardService.modify(boardDTO);
        redirectAttributes.addFlashAttribute("result", "modified");
        redirectAttributes.addAttribute("bno", boardDTO.getBno());
        return "redirect:/board/read";
    }
    @PreAuthorize("principal.username == #boardDTO.writer")
    @PostMapping("/remove")
    public String remove(@ModelAttribute("boardDTO") BoardDTO boardDTO, RedirectAttributes redirectAttributes) {
        Long bno  = boardDTO.getBno();
        log.info("remove post.. " + bno);
        boardService.remove(bno);
        //게시물이 삭제되었다면 첨부 파일 삭제
        log.info(boardDTO.getFileNames());
        List<String> fileNames = boardDTO.getFileNames();
        if(fileNames != null && fileNames.size() > 0){
            removeFiles(fileNames);
        }

        redirectAttributes.addFlashAttribute("result", "removed");
        return "redirect:/board/list";
    }
    public void removeFiles(List<String> files){
        for (String fileName:files) {
            Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);
            String resourceName = resource.getFilename();

            try {
                String contentType = Files.probeContentType(resource.getFile().toPath());
                resource.getFile().delete();
                //섬네일이 존재한다면
                if (contentType.startsWith("image")) {
                    File thumbnailFile = new File(uploadPath + File.separator + "s_" + fileName);
                    thumbnailFile.delete();
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }//end for
    }
}