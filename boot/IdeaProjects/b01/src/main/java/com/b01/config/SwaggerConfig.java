package com.b01.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi restApi() {
// 그룹별로 일반 API, REST API로 나누어서 경로를 설정하기 위함.
        return GroupedOpenApi.builder()
                .pathsToMatch("/**")
                .group("REST API")
                .build();
    }

    @Bean
    public GroupedOpenApi commonApi() {
        // 아무것도 안 준 애들
        return GroupedOpenApi.builder()
                .pathsToMatch("/*")
                .group("COMMON API")
                .build();
    }
}