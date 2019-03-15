package com.practice.juc.locksupport;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/1
 * @Time: 21:42
 */
public class MyThread01 extends Thread{

    @Override
    public void run(){
        synchronized (this){
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}
