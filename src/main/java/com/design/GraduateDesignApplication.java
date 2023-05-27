package com.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.design")
public class GraduateDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduateDesignApplication.class, args);
    }

}
