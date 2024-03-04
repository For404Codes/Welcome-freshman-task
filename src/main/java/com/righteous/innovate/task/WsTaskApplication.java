package com.righteous.innovate.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class WsTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsTaskApplication.class, args);
    }

}
