package com.practice.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/28
 * @Time: 18:48
 */
public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int andIncrement = atomicInteger.getAndIncrement();
    }
}
