package com.practice.thread;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/26
 * @Time: 11:30
 */
public class FinalDemo {

    private static final String name = "12";
    private static final int[] array = {1,2,3};

    public static void setField(){
        System.out.println(name);
        array[2] = 12;
    }
    public static void main(String[] args) {
        setField();
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i]+" ,");
        }
    }
}
