package com.b01.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class SampleJSONController {
    @GetMapping("/api/helloArr")
    public String[] helloArr() {
        log.info("helloArr~~~~~~");
        // 배열에 담아서 저장하지 않고 바로 String으로 출력한다. (순수한 데이터)
        // 서버에서 알아서 JSON 형태로 인식해서 출력한다.
        return new String[]{"AAA", "BBB", "CCC"};
    }
}
