package com.practice.sortdemo;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/2/28
 * @Time: 10:08
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{11,2,4,3,9,65,8,6,5,7};
        bubbleSort(array);
        for (int i= 0;i < array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void bubbleSort(int[] array){
        if(array == null){
            return;
        }
        int length = array.length;
        for (int i = 0;i < length - 1;i++){
            for (int j = 0; j < length - 1- i;j++){
                if(array[j] > array[j+1]){
                    SortUtil.swap(array,j,j+1);
                }
            }
        }
    }
}
