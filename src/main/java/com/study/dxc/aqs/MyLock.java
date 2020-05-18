package com.study.dxc.aqs;


import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: zjt
 * @date: 2020-05-03 20:36
 */
public class MyLock extends AbstractQueuedSynchronizer {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println("lock = " + lock);
        lock.unlock();
    }

}