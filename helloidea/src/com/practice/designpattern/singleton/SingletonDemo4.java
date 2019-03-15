package com.practice.designpattern.singleton;

/**
 * @Description:DCL单例
 * @Author: liuweixin
 * @Date: 2019/2/28
 * @Time: 10:41
 */
public class SingletonDemo4 {

    private SingletonDemo4(){}

    private static volatile SingletonDemo4 instance;

    public static SingletonDemo4 getInstance(){
        if(instance == null){
            synchronized (SingletonDemo4.class){
                if(instance == null){
                    instance = new SingletonDemo4();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonDemo4 instance = getInstance();
        SingletonDemo4 instance1 = getInstance();
        System.out.println(instance == instance1);
    }

}
