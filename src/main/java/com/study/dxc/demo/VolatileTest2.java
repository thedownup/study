package com.study.dxc.demo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @description:
 * @author: zjt
 * @date: 2020-04-06 19:39
 */
public class VolatileTest2 {

//    static volatile long count = 0;
//
//    private static synchronized void set(long sum) {
//        count = sum;
//    }
//
//    private static synchronized long get() {
//        return count;
//    }
//
//    private static synchronized void getAndIncrement() {
//        long temp = get();
//        temp += 1L;
//        set(temp);
//    }

    static long count = 0;

    private static void set(long num) {
        count = num;
    }

    private static void getAndIncrement() {
        count++;
    }

    private static long get() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j <  1000; j++) {
                    VolatileTest2.getAndIncrement();
                }
            });
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(get());
    }

}