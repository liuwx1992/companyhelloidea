package com.practice.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/2
 * @Time: 10:46
 */
public class MyThread04 extends Thread{

    private Object object;

    public MyThread04(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");
        // 释放许可
        LockSupport.unpark((Thread) object);
        System.out.println("after unpark");
    }
}
