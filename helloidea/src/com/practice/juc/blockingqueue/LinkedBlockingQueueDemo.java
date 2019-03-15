package com.practice.juc.blockingqueue;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/13
 * @Time: 22:01
 */
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // 声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(10);

        //new了三个生产者和一个消费者
        Producer producer01 = new Producer(queue);
        Producer producer02 = new Producer(queue);
        Producer producer03 = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // 借助Executors
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 启动线程
        executorService.submit(producer01);
        executorService.submit(producer02);
        executorService.submit(producer03);
        executorService.submit(consumer);

        // 执行10s
        Thread.sleep(10*1000);
        producer01.stop();
        producer02.stop();
        producer03.stop();

        Thread.sleep(2000);
        // 退出Executor
        executorService.shutdown();

    }
}
