package com.example.weblogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing  // 등록일,수정일 관련
@SpringBootApplication
public class WebLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebLoginApplication.class, args);
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
    // UPDATE,DELETE 관련

}
