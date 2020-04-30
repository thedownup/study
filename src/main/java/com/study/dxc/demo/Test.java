package com.study.dxc.demo;

public class Test {
    public static volatile int t = 0;

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            //每个线程对t进行1000次加1的操作
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        t = t + 1;
                    }
                }
            });
            threads[i].start();
        }

        //等待所有累加线程都结束
        while (Thread.activeCount() > 1) {
        }

        //打印t的值
        System.out.println(t);
    }
}