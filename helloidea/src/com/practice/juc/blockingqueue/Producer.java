package com.practice.juc.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 生产者类
 * @Author: liuweixin
 * @Date: 2019/3/13
 * @Time: 22:11
 */
public class Producer implements Runnable{

    private volatile boolean isRunning = true;//是否在运行标志
    private BlockingQueue<String> blockingQueue;
    private static AtomicInteger count = new AtomicInteger();//自动更新的值
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    //构造函数
    public Producer(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String data = null;
        Random random = new Random();
        System.out.println("启动生产者线程！");
        try {
            while(isRunning){
                System.out.println("正在生产数据...");
                Thread.sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                data = "data: " + count.getAndIncrement();
                System.out.println("将数据：" + data + "放入队列...");
                if(!blockingQueue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("放入数据失败："+data);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }finally {
            System.out.println("退出生产者线程！");
        }

    }

    public void stop(){
        isRunning = false;
    }
}
