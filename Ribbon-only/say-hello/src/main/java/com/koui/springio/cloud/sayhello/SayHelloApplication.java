package com.koui.springio.cloud.sayhello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class SayHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SayHelloApplication.class, args);
    }


    @GetMapping("/greeting")
    public  String greet() {
        log.info("Access /greeting");

        return "Hi! This is greeting from 8890";
    }

    @GetMapping("/")
    public String home() {
        log.info("Access Home");
        return "Hi!, This is home from 8890";
    }
}
