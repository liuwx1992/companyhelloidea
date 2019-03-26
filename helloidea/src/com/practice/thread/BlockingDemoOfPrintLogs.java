package com.practice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:创建四个线程，打印16个日志对象，使用队列的方式。
 * @Author: liuweixin
 * @Date: 2019/3/26
 * @Time: 14:02
 */
public class BlockingDemoOfPrintLogs {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(16);
        for(int i = 0;i < 4;i++){
            new Thread(() -> {
               while(true){
                   String logs;
                   try {
                       logs = queue.take();
                       BlockingDemoOfPrintLogs.parseLog(logs);
                   }catch (InterruptedException e){
                       e.printStackTrace();
                   }
               }
            }).start();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> {
            while(true){
                String logs;
                try {
                    logs = queue.take();
                    BlockingDemoOfPrintLogs.parseLog(logs);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        for (int i = 0;i < 16;i++){
            final String logs = ""+(i+1);
            try {
                queue.put(logs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void parseLog(String log){
        System.out.println(log+":"+(System.currentTimeMillis()/1000));
    }
}
