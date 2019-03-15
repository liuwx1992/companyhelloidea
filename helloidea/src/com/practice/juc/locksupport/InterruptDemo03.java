package com.practice.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description:，在主线程调用park阻塞后，在myThread线程中发出了中断信号，此时主线程会继续运行，也就是说明此时interrupt起到的作用与unpark一样。
 * @Author: liuweixin
 * @Date: 2019/3/2
 * @Time: 10:43
 */
public class InterruptDemo03 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        MyThread03 myThread03 = new MyThread03(thread);
        myThread03.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo03");
        System.out.println("after park");
    }
}
