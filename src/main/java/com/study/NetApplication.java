package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NetApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE)
        ;
        application.run(args);
    }


}
