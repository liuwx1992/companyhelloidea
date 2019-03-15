package com.practice.demo;

/**
 * @Description:数组的数组---二维数组的每一个元素是一个一维数组
 *
 * 定义格式
 * 数据类型[][] 数组名 = new 数据类型[二维数组的长度/包含的一维数组的个数][每个一维数组的长度];
 *
 * int[][] arr = new int[3][5];---定义了一个整型的二维数组，其中包含3个一维数组，每个一维数组可以存储5个整数
 *
 * arr[0]---下标为0的位置上的一维数组
 *
 * arr[1][3]---如果要获取具体的元素需要两个下标
 *
 * 二维数组的应用
 * 二维数组的长度：数组名.length ---每个一维数组：数组名[下标].length
 *
 * 二维数组的遍历---两重for循环
 *
 * for(int i = 0; i < arr.length; i++){ //遍历二维数组，遍历出来的每一个元素是一个一维数组
 * for(int j = 0; j < arr[i].length; j++){ //遍历对应位置上的一维数组
 * System.out.println(arr[i][j]);
 * }
 * }
 * 二维数组的反转---头尾交换
 *
 * for(int start = 0, end = arr.length -1; start < end; start++,end--){
 * int[] temp = arr[start];
 * arr[start] = arr[end];
 * arr[end] = temp;
 * }
 * @Author: liuweixin
 * @Date: 2019/3/2
 * @Time: 15:21
 */
public class DoubleArrayDemo {
    public static void main(String[] args) {
        int[][] doubleArray = new int[5][10];
        int[] array01 = new int[10];
        doubleArray[0][0] = 2;
        int[] int00 = new int[19];
        int00[0] = 10;
        doubleArray[0] = int00;
        doubleArray[1] = array01;
        //System.out.println(doubleArray[0][0]);

        for(int i = 0; i < doubleArray.length; i++){ //遍历二维数组，遍历出来的每一个元素是一个一维数组
            for(int j = 0; j < doubleArray[i].length; j++){ //遍历对应位置上的一维数组
                System.out.println(doubleArray[i][j]);
            }
        }
    }
}
