package com.practice.demo;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/5
 * @Time: 17:27
 */
public class OuterClass {

    //内部类
    private static class InnerClass{
        public InnerClass(){
            System.out.println("innerCLass create");
        }
    }

    public OuterClass(){
        InnerClass innerClass = new InnerClass();
        System.out.println("OuterClass create");
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = new InnerClass();
    }
}
