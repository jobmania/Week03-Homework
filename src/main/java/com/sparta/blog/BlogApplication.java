package com.sparta.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing   // jpa 변하면 빠르게 제출
@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {SpringApplication.run(BlogApplication.class, args);
    }

}
