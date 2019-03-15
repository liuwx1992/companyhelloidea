package com.practice.juc.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/8
 * @Time: 12:25
 */
public class LockSupportDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run(){
            synchronized (u){
                System.out.println("in "+getName());
                LockSupport.park();//阻塞线程
                //System.out.println("unpark"+getName());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(3000);
        t2.start();
        LockSupport.unpark(t1);//唤醒
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }

}
