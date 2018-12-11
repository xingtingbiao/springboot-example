package com.example.gradlespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GradleSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleSpringbootApplication.class, args);
    }
}
