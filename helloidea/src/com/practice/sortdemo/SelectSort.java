package com.practice.sortdemo;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

/**
 * @Description:选择排序是一种直观简单的排序算法，它每次从待排序的数据元素中选出最小(或者最大)元素存放到序列的起始位置，
 *              直到全部待排序的数据元素排完。注意，选择排序并不是稳定的排序。
 * @Author: liuweixin
 * @Date: 2019/2/27
 * @Time: 22:39
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{11,2,4,3,9,65,8,6,5,7};
        selectSort(array);
        //IntStream stream = Arrays.stream(array);
        for (int i= 0;i < array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    /*public static void selectSort(int[] array){
        int length = array.length;
        for(int i = 0;i < length - 1;i++){
            int min = i;
            for(int j = i + 1;j < length;j++){
                if(array[min] > array[j]){
                    min = j;
                }
            }
            SortUtil.swap(array,i,min);
        }
    }*/

    public static void selectSort(int[] array){
        if(array == null){
            return;
        }
        int length = array.length;
        for (int i = 0;i < length - 1;i++){
            int min = i;
            for (int j = i + 1;j < length;j++){
                if(array[min] > array[j]){
                    min = j;
                }
            }
            SortUtil.swap(array,min,i);
        }
    }
}
