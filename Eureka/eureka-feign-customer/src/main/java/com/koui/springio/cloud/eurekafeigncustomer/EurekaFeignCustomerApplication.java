package com.koui.springio.cloud.eurekafeigncustomer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class EurekaFeignCustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignCustomerApplication.class, args);
    }

    @Autowired
    IGreeting greetings;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "defaultHI") String name) {
        String greeting = greetings.greetings();
        return String.format("%s, %s", greeting, name);
    }
}
