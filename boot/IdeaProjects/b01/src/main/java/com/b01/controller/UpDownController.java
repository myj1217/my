package com.b01.controller;

import com.b01.dto.upload.UploadFileDTO;
import com.b01.dto.upload.UploadResultDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UpDownController {
    // application.properties 파일의 경로 정보를 읽어옴 - 변수의 값으로 사용
    @Value("${com.upload.path}")
    private String uploadPath; // 파일의 경로를 uploadPath라는 이름으로 쓰겠다.
    @Operation(summary = "POST 방식으로 파일 등록")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<UploadResultDTO> upload(
            @Parameter(
                    description = "Files to be uploaded",
                    content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE)
            )
            UploadFileDTO uploadFileDTO) {
        log.info(uploadFileDTO);
        // 파일이 있으면
        if (uploadFileDTO.getFiles() != null) {

            final List<UploadResultDTO> list = new ArrayList<>();

            uploadFileDTO.getFiles().forEach(multipartFile -> {
                String originalName = multipartFile.getOriginalFilename();
                log.info(originalName);

                String uuid = UUID.randomUUID().toString();

                Path savePath = Paths.get(uploadPath, uuid+"_" + originalName);

                boolean image = false;

                try {
                    // 실제 파일 저장
                    multipartFile.transferTo(savePath);
                    // 이미지 파일이라면
                    if(Files.probeContentType(savePath).startsWith("image")) {

                        image = true;

                        File thumbFile = new File(uploadPath, "s_" + uuid + "_" + originalName);
                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 200, 200);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.add(UploadResultDTO.builder()
                        .uuid(uuid)
                        .fileName(originalName)
                        .img(image)
                        .build()
                );
            }); // end each
            return list;
        } // end if

        return null;
    }

    @Operation(summary = "GET방식으로 첨부파일 조회")
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFileGET(@PathVariable String fileName) {
        // File.separator: 운영체제마다 사용하는 '/', '\' 기호가 다르기 때문에
        // 운영체제에 적합한 구분 기호를 사용하는지 확인한다.
        // C://upload\aaa.jpg
        Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);

        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();

        try {
            // Files.probeContentType : 파일의 MIME 유형 (text/plain, image/jpeg)
            // Content-Type과 toPath에 해당하는 값을 headers에 추가하겠다.
            headers.add("Content-Type", Files.probeContentType((resource.getFile().toPath())));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        // ok() : 응답 처리 200번
        return ResponseEntity.ok().headers(headers).body(resource);
    }
}
