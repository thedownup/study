package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;

/**
 * @description:
 * @author: zjt
 * @date: 2020-05-01 20:51
 */
public class TestInherited extends NetApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NetApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

}