package com.practice.jvm.demo01;

import com.practice.jvm.demo01.Singleton;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/5
 * @Time: 17:44
 */
public class Test {
    public static void main(String[] args) {
        Singleton sin = Singleton.getInstance();
        System.out.println(sin.count01);
        System.out.println(sin.count02);
    }
}
