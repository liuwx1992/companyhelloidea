package com.practice.jdk;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/14
 * @Time: 17:09
 */
public class ObjectDemo {
    public static void main(String[] args) {
        Object object = new Object();
        Boolean flag = true;
        Boolean b = new Boolean("true");
        System.out.println(b);
        boolean aFalse = Boolean.parseBoolean("false");
        System.out.println(aFalse);
        Boolean aTrue = Boolean.valueOf("TRUE");//只有当传值为true时才返回true，否则都是false
        System.out.println(aTrue);

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("过客");

    }
}
