package org.example.dtoPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing //jpa auditing 어노테이션을 모두 활성화할수 있도록 하는 어노테이션
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(org.example.dtoPractice.Application.class, args);
    }
}
