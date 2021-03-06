package com.koui.springio.cloud.eurekaribboncustomer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RestController
//@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker
public class EurekaRibbonCustomerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbonCustomerApplication.class, args);
    }


    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "reliable")
    public String hi(@RequestParam(value="name", defaultValue = "defaultHI") String name) {
        String greeting = this.restTemplate.getForObject("http://say-hello/greeting", String.class);

        return String.format("%s, %s", greeting, name);
    }

    public String reliable(@RequestParam(value="name", defaultValue = "defaultHI") String name) {
        return "This is reliable method, currently Hi function can't be used, try again please";
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/customer/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName (@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
