package com.study.dxc.demo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: zjt
 * @date: 2020-04-06 19:31
 */
public class VolatileTest {

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
        int sum = 2;
//        CountDownLatch countDownLatch = new CountDownLatch(sum);

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(0, 20, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), (ThreadFactory) r -> {
            Thread t = new Thread(r);
//            System.out.println("t = " + t.getName());
            return t;
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("rejectedExecution ");
            }
        });


        for (int j = 0; j < sum; j++) {
            executorService.execute(() -> {
                for (int i = 0; i < sum; i++) {
                    count++;
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
        while(true){
            if(executorService.isTerminated()){
                System.out.println("所有的子线程都结束了！");
                break;
            }
            Thread.sleep(1000);
        }
        executorService.execute(() -> {
            for (int i = 0; i < sum; i++) {
                count++;
            }
            System.out.println(Thread.currentThread().getName());
        });
        System.out.println(count);

    }

}