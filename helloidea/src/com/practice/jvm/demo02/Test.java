package com.practice.jvm.demo02;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/5
 * @Time: 17:52
 */
public class Test {
    public static void main(String[] args) {
        Singleton sin = Singleton.getInstance();
        System.out.println(sin.counter1);
        System.out.println(sin.counter2);
    }
}
