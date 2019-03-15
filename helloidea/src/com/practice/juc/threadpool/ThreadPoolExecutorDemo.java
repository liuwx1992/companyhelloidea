package com.practice.juc.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/8
 * @Time: 12:49
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {

            }
        };

        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();

    }
}
