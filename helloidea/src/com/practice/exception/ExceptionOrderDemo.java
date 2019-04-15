package com.practice.exception;

/**
 * @Description:异常打印顺序
 * @Author: liuweixin
 * @Date: 2019/4/9
 * @Time: 15:06
 */
public class ExceptionOrderDemo {
    public static void main(String[] args) {
        method01();
    }

    private static void method01() {
        method02();
    }

    private static void method02() {
        method03();
    }

    private static void method03() {
        System.out.println(1/0);
    }
}
