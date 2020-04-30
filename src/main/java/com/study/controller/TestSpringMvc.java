package com.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zjt
 * @date: 2020-04-08 20:49
 */
@RestController
public class TestSpringMvc {

    @RequestMapping("test1")
    public String test1(String name) {
        return name + "test";
    }

    @RequestMapping("test2")
    public String test2(String name) {
        return name + "test";
    }

}