package com.practice.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/6
 * @Time: 16:53
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.contains(11));
        list.add(12);
        list.add(17);
        list.add(15);
        list.add(13);
     /*   Collections.sort(list);
        System.out.println(list);
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println(max);
        System.out.println(min);*/

        castType(list);
    }



    public static void castType(List list){
        List<Integer> list1 = (List<Integer>)list;
        for (Integer integer : list1){
            System.out.println(integer);
        }
    }
}
