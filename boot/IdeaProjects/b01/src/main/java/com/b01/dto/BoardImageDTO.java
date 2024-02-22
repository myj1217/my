package com.b01.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardImageDTO { // BoardImage 엔티티를 처리하기 위한 DTO
    private String uuid;
    private String fileName;
    private int ord;
}
