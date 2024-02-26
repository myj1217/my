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
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@Log4j2
public class UpDownController {
    // application.properties 파일의 경로 정보를 읽어옴 - 변수의 값으로 사용
    @Value("${com.upload.path}") // 경로를 c/upload로 해놓은거
    private String uploadPath; // 파일의 경로를 uploadPath라는 이름으로 쓰겠다.

    // 파일을 업로드하는 메서드
    @Operation(summary = "POST 방식으로 파일 등록")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<UploadResultDTO> upload(
            @Parameter(
                    description = "Files to be uploaded",
                    content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE)
            )
            UploadFileDTO uploadFileDTO) {
        // 업로드할 파일 정보를 로그에 기록
        log.info(uploadFileDTO);
        // 파일이 있으면
        if (uploadFileDTO.getFiles() != null) {
            // 업로드 결과를 저장할 리스트 생성
            final List<UploadResultDTO> list = new ArrayList<>();
            // 각 파일에 대해 처리
            uploadFileDTO.getFiles().forEach(multipartFile -> {
                // 업로드된 파일의 원본 이름 획득
                String originalName = multipartFile.getOriginalFilename();
                log.info(originalName);
                // 파일마다 고유한 식별자 생성
                String uuid = UUID.randomUUID().toString();
                // 파일을 저장할 경로 설정
                Path savePath = Paths.get(uploadPath, uuid+"_" + originalName);
                // 이미지 여부 확인을 위한 변수
                boolean image = false;
                try {
                    // 실제 파일 저장
                    multipartFile.transferTo(savePath);
                    // 저장된 파일의 MIME 타입을 확인하여 이미지인지 판단
                    if(Files.probeContentType(savePath).startsWith("image")) {
                        // 이미지일 경우 섬네일 생성을 위해 플래그 설정
                        image = true;
                        // 섬네일 파일 생성
                        File thumbFile = new File(uploadPath, "s_" + uuid + "_" + originalName);
                        Thumbnailator.createThumbnail(savePath.toFile(), thumbFile, 200, 200);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 업로드 결과 DTO를 리스트에 추가
                list.add(UploadResultDTO.builder()
                        .uuid(uuid)
                        .fileName(originalName)
                        .img(image)
                        .build()
                );
            }); // end each
            return list; // 처리된 파일들의 업로드 결과를 반환
        } // end if
        return null; // 업로드할 파일이 없는 경우 null 반환
    }

    // 파일을 조회하는 메서드
    @Operation(summary = "GET방식으로 첨부파일 조회")
    @GetMapping("/view/{fileName}")
    public ResponseEntity<Resource> viewFileGET(@PathVariable(name = "fileName") String fileName) {
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

    // 파일을 삭제하는 메서드
    @Operation(summary = "DELETE 방식으로 파일 삭제")
    @DeleteMapping("/remove/{fileName}")
    public Map<String, Boolean> removeFile(@PathVariable(name = "fileName") String fileName) {
        // 파일의 경로와 이름을 이용하여 resource 객체 생성
        Resource resource = new FileSystemResource(uploadPath + File.separator + fileName);
        // resource 객체에서 파일 이름 얻어옴
        String resourceName = resource.getFilename();
        // 삭제 결과를 저장할 resultMap 객체 생성
        Map<String, Boolean> resultMap = new HashMap<>();
        // 삭제 여부 초기값 설정
        boolean removed = false;

        try {
            // 파일의 MIME 타입 확인
            String contentType = Files.probeContentType(resource.getFile().toPath());
            removed = resource.getFile().delete();

            // 섬네일이 존재한다면
            if (contentType.startsWith("image")){
                // 섬네일 파일 객체 삭제
                File thumbnailFile = new File(uploadPath + File.separator + "s_" + fileName);
                thumbnailFile.delete();
            }
        } catch (Exception e) {
            // 예외 발생 시 로그 출력
            log.error(e.getMessage());
        }
        // 삭제 결과를 resultMap에 저장
        resultMap.put("result", removed); // 지우고 수정해라
        // 삭제 결과 resultMap 반환
        return resultMap;
    }
}
