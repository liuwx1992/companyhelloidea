package com.practice.corejava.ninth;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/20
 * @Time: 22:39
 */
public class EasyFindMaxDemo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0;i < 5;i++){
            list1.add(""+i);
        }
        for (int i = 2;i < 7;i++){
            list2.add(""+i);
        }
        getIntersection(list1,list2);
    }

    public static int findMax(Integer[] array){
        if(array == null || array.length == 0){
            throw new NoSuchElementException("数组为空");
        }
        Integer max = array[0];
        for (int i = 0;i < array.length;i++){
            if(max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }

    public static void getIntersection(List<String> list1,List<String> list2){
        boolean b = list1.retainAll(list2);
        System.out.println(list1);
    }
}
