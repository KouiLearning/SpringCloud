package com.koui.springio.cloud.eurekaribbonservicea;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
//@EnableDiscoveryClient
public class EurekaRibbonServiceAApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbonServiceAApplication.class, args);
    }

    @GetMapping("/greeting")
    public  String greet() {
        log.info("Access /greeting");

        return "Hi! This is greeting from 9001";
    }

    @GetMapping("/")
    public String home() {
        log.info("Access Home");
        return "Hi!, This is home from 9001";
    }

}
