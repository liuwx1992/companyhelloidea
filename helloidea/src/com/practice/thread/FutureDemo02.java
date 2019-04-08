package com.practice.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/27
 * @Time: 10:12
 */
public class FutureDemo02 {
    public static void main(String[] args) {
        FutureDemoCounter futureDemoCounter = new FutureDemoCounter();
        FutureTask<Integer> task = new FutureTask<>(futureDemoCounter);
        Thread t = new Thread(task);
        t.start();
        try {
            Integer ret = task.get();
            System.out.println(ret);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
