package com.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString // 객체를 간편하게 문자열로 표현
@Service
@RequiredArgsConstructor
public class SampleService {
    @Qualifier("normal")
    private final SampleDAO sampleDAO;
}
