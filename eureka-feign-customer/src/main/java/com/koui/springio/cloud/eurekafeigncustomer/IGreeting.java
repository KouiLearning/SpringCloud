package com.koui.springio.cloud.eurekafeigncustomer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("say-hello")
public interface IGreeting {

    @GetMapping("/greeting")
    String greetings();
}
