package com.practice.juc.locksupport;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/2
 * @Time: 10:36
 */
public class MyThread03 extends Thread{
    private Object object;

    public MyThread03(Object object) {
        this.object = object;
    }

    @Override
    public void run(){
        System.out.println("before interrupt");
        try {
            // 休眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = (Thread) object;
        // 中断线程
        thread.interrupt();
        System.out.println("after interrupt");
    }

}
