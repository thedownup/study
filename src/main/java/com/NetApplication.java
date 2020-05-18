package com;

import com.study.springboot.event.SendEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NetApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NetApplication.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        ConfigurableApplicationContext applicationContext = application.run(args);
        applicationContext.publishEvent(SendEvent.builder().msg("test").build());
    }

}
