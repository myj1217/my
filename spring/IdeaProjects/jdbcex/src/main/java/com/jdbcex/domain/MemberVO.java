package com.jdbcex.domain;

import lombok.*;

@Getter // 전부다 GET
@ToString
@Builder
@AllArgsConstructor // 모든 인자를 받는 생성자
@NoArgsConstructor
public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
    private String uuid;
}
