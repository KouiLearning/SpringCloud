package com.koui.springio.cloud.configcustomer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigCustomerApplication {

    @Value("${version}")
    private String version;

    @RequestMapping("/getVersion")
    public String getVersion() {
        return this.version;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigCustomerApplication.class, args);
    }


}
