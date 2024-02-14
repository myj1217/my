package com.b01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// 진입점 부분에 꼭 추가가 되어야 작동함
@EnableJpaAuditing
public class B01Application {

	public static void main(String[] args) {
		SpringApplication.run(B01Application.class, args);
	}

}
