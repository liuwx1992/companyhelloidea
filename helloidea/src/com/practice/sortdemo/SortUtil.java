package com.practice.sortdemo;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/2/27
 * @Time: 22:48
 */
public class SortUtil {
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
