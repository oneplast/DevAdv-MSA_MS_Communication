package org.example.comdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ComDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComDemoApplication.class, args);
    }

}
