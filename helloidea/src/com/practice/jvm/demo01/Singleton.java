package com.practice.jvm.demo01;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/5
 * @Time: 17:41
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    public  static int count01;
    public  static int count02 = 0;

    private Singleton(){
        count01++;
        count02++;
    }

    public static Singleton getInstance(){
        return singleton;
    }

}
