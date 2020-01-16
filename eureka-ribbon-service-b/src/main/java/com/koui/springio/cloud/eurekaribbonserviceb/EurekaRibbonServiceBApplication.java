package com.koui.springio.cloud.eurekaribbonserviceb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
@EnableDiscoveryClient
public class EurekaRibbonServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbonServiceBApplication.class, args);
    }

    @GetMapping("/greeting")
    public  String greet() {
        log.info("Access /greeting");

        return "Hi! This is greeting from 9002";
    }

    @GetMapping("/")
    public String home() {
        log.info("Access Home");
        return "Hi!, This is home from 9002";
    }

}
