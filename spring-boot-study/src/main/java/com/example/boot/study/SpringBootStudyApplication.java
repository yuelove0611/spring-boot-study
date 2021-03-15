package com.example.boot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:beans.xml")
@ImportAutoConfiguration
public class SpringBootStudyApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootStudyApplication.class, args);
    }

}
