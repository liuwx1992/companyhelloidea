package com.practice.juc.locksupport;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/1
 * @Time: 22:33
 */
public class WaitAndNotifyDemo02 {
    public static void main(String[] args) throws InterruptedException {
        MyThread01 myThread01 = new MyThread01();
        myThread01.start();
        Thread.sleep(3000);
        synchronized (myThread01){
            try {
                System.out.println("before wait");
                myThread01.wait();
                System.out.println("after wait");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
