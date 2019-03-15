package com.practice.jvm.demo02;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/5
 * @Time: 17:48
 */
public class Singleton {
    public static int counter1;
    public static int counter2 = 2;
    private static Singleton sin = new Singleton();

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return sin;
    }
}
