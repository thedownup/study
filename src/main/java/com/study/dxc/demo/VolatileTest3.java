//package com.net.dxc.demo;
//
///**
// * @description:
// * @author: zjt
// * @date: 2020-04-06 19:43
// */
//public class VolatileTest3 {
//
//    private long count = 0;
//
//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            new Thread(VolatileTest3::getAndIncrement).start();
//        }
//
//        System.out.println(count);
//    }
//
//}