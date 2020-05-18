package com.study.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @description:
 * @author: zjt
 * @date: 2020-05-01 21:27
 */

public class MyRunListener implements SpringApplicationRunListener {

    private String name;

    public MyRunListener(SpringApplication application, String[] args) {
        this.name = name;
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("environmentPrepared = " + environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("contextPrepared = " + context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("contextLoaded = " + context);
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("started = " + context);
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("running = " + context);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("failed = " + context);
    }

    @Override
    public void starting() {
        System.out.println("starting");
    }
}