package com.edu.tutor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.edu.tutor.dao")
public class TutorApplication {
    public static void main(String[] args) {
        SpringApplication.run(TutorApplication.class,args);
    }
}
