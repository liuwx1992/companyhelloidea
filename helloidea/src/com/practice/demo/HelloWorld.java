package com.practice.demo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: DELL7020
 * @Date: 2019/2/18
 * @Time: 17:07
 */
public class HelloWorld {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < 10;i++){
            list.add(i);
        }
        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }

    public static double getValue(int value,int num){

        return 0;
    }
}
