package com.example.SpringBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //JPA 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        // 내장 WAS 실행. Tomcat을 설치할 필요가 없음.
        SpringApplication.run(Application.class, args);

        // SpringBoot는 내장 WAS를 사용하는것을 권장한다.
    }
}