package com.practice.juc.locksupport;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/1
 * @Time: 21:53
 */
public class WaitAndNotifyDemo01 {
    public static void main(String[] args) throws InterruptedException {
        MyThread01 myThread01 = new MyThread01();
        synchronized (myThread01){
            try {
                myThread01.start();
                // 主线程睡眠3s
                myThread01.sleep(3000);
                System.out.println("before wait");
                // 阻塞主线程
                myThread01.wait();
                System.out.println("after wait");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
