package com.b01.dto.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UploadFileDTO {
    // list 형태로 MultipartFile API를 files의 이름으로 사용하겠다.
    private List<MultipartFile> files;
}
