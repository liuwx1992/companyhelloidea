package com.practice.corejava.sixth;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/18
 * @Time: 22:04
 */
public class Test {
    public static void main(String[] args) {
        Object value = new Object();
        TranceHandler handler = new TranceHandler(value);
        Class[] interfaces = new Class[]{Comparable.class};
        Proxy.newProxyInstance(null, interfaces, handler);

        Object[] elements = new Object[1000];
        // fill elements with proxies for the integers 1 . . . 1000
       /* for (int i = 0; i < elements.length; i ++) {
            Integer value = i + 1;
            elements[i] = Proxy.newProxylnstance(null, interfaces, handler); // proxy for value;
        }
        // construct a random integer
        Integer key = new RandomO.nextlnt(elements.length) + 1;
        // search for the key
        int result = Arrays.binarySearch(elements, key) ;
        // print match if found
        if (result >= 0) System.out.println(elements[result]);*/

    }
}
