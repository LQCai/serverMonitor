package com.luoqincai;

import com.luoqincai.annotation.Register;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@Register
public class ThriftClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThriftClientApplication.class, args);
    }
}
