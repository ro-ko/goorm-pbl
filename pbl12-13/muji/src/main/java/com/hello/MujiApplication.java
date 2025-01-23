package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MujiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MujiApplication.class, args);
    }

}
