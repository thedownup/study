package com.study.web;

import com.study.annotation.LimitNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zjt
 * @date: 2020-04-25 21:06
 */
@RestController
@RequestMapping("test")
public class TestController {


    @RequestMapping("testLimitNumber")
    @LimitNumber(limitThreadNum = 3, acquireNum = 3)
    public String testLimitNumber(@RequestBody Map map) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(5);
        return new Date().toLocaleString();
    }

}