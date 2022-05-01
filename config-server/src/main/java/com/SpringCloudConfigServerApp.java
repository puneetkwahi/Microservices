package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApp {

    public static void main(String args[]) {
        SpringApplication.run(SpringCloudConfigServerApp.class, args);
    }
}
