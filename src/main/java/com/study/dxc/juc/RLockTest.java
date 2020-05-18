package com.study.dxc.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: zjt
 * @date: 2020-05-16 22:25
 */
public class RLockTest {

    public static void main(String[] args) throws InterruptedException {
//
//        ReentrantLock reentrantLock = new ReentrantLock(true);
//
//        reentrantLock.lock();
//        reentrantLock.unlock();


        Semaphore semaphore = new Semaphore(2);
        semaphore.acquire(2);
        semaphore.release(2);

        CountDownLatch countDownLatch = new CountDownLatch(2);
        countDownLatch.countDown();
        countDownLatch.await();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        countDownLatch.countDown();

        cyclicBarrier.reset();
    }

}