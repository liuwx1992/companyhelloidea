package com.practice.demo;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/9
 * @Time: 10:34
 */
public class Double2IntDemo {
    public static void main(String[] args) {
        double d = 1.234;
        int i = (int)d;
        System.out.println(i);

        Integer i1 = (int)Double.parseDouble("1.23");//转型报错
        System.out.println(i1);

        String s = "11.2";
        String[] split = s.split("\\.");//正则要转义
        System.out.println(split[0]);
    }
}
