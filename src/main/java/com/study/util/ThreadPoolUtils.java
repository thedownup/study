package com.study.util;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zjt
 * @date: 2020-05-16 17:16
 */
public class ThreadPoolUtils {

    public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());


    public static ThreadPoolExecutor getThreadPool() {
        return threadPoolExecutor;
    }


}