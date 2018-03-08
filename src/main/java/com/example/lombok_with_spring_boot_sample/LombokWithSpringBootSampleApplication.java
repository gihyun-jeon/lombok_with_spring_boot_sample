package com.example.lombok_with_spring_boot_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.lombok_with_spring_boot_sample")
public class LombokWithSpringBootSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(LombokWithSpringBootSampleApplication.class, args);
    }
}
