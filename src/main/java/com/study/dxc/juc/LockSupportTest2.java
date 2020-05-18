package com.study.dxc.juc;

import com.study.util.ThreadPoolUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: zjt
 * @date: 2020-05-15 21:29
 */
public class LockSupportTest2 {

    public static void main(String[] args) throws InterruptedException {
        int num = 5;
        Thread thread = Thread.currentThread();
        System.out.println("thread = " + thread.getName());
        Work work = new Work(thread);
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread = " + thread.getName());
            LockSupport.unpark(thread);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Date date = (Date) LockSupport.getBlocker(thread);
            System.out.println("date = " + date.toLocaleString());
        }).start();
        LockSupport.park(new Date());

    }


}

class Work implements Runnable {

    private Thread thread;

    public Work(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {

        System.out.println("thread = " + thread.getName());
        Date date = (Date) LockSupport.getBlocker(thread);
        System.out.println("date = " + date.toLocaleString());
    }
}