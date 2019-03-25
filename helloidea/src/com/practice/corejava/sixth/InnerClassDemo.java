package com.practice.corejava.sixth;


/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/18
 * @Time: 21:59
 */
public class InnerClassDemo {

    private static String name;

    public class Inner{
        String innerName;
        public Inner(String innerName){
            System.out.println("inner init...");
            this.innerName = innerName;
            InnerClassDemo.name = "hello world";
        }
    }

    public static void main(String[] args) {
        Inner inner = new InnerClassDemo().new Inner("innerName");
        System.out.println(inner.innerName);
        System.out.println(name);
    }
}
