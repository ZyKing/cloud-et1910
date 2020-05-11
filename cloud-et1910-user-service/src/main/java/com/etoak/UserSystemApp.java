package com.etoak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserSystemApp {
    public static void main(String[] args) {
        SpringApplication.run(UserSystemApp.class, args);
    }

}
