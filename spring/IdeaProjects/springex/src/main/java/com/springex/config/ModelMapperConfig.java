package com.springex.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 스프링 애플리케이션 컨텍스트를 설정하고, 빈을 정의하는 역할
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                // 필드 이름이 동일한 경우 자동으로 매핑해준다.
                .setFieldMatchingEnabled(true)
                // 필드 레벨을 PRIVATE으로 설정한다.
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                // STRICT한 규칙을 적용하여 필드 유형 및 이름이 정확하게 일치해야 한다.
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }
}
