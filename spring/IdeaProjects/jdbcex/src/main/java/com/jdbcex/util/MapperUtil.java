package com.jdbcex.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

public enum MapperUtil {
    INSTANCE;
    // JVM이 상수처리해서 어디서나 접근할 수 있도록 한다 - 싱글톤 객체
    // DTO -> VO, 또는 VO -> DTO 할 때마다 편하게 불러서 사용할 예정

    private ModelMapper modelMapper;

    // 모두가 공통으로 사용하는 것은 'util'에 저장
    // 회사의 공통된 규칙들(개발자끼리의 회의를 통해 결정된)은 'service'에 저장

    // 보통 이러한 틀로 만들어짐
    // modelMapper의 규약
    MapperUtil() {
        this.modelMapper = new ModelMapper();
        // getConfiguration() : 뒤에 것을 사용하기 위해 먼저 접근해야함 - 선행퀘스트

        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
                // PRIVATE: 숨겨라
                // STRICT: 타입과 이름이 엄격해야 한다.
    }
    public ModelMapper get() {
        return modelMapper;
    }
}
