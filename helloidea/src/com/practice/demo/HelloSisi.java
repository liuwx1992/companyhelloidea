package com.practice.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/2/18
 * @Time: 17:19
 */
public class HelloSisi {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        boolean sisi = list.add("sisi");
        System.out.println(list);

        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();//获取可用处理器数量
        System.out.println(i);
        System.out.println(runtime);*/

       /* String s = "123";
        s = changeValue(s);
        System.out.println(s);*/

       /* String ss = (String) null;
        System.out.println(ss == null);*/

        //System.out.println(Integer.parseInt(null) == 5);

        Map<String,String> map = new HashMap<>();

        map.put("1","aa");
        map.put("2","bb");
        map.put("3","cc");

        if(map.get("2") != null){
            System.out.println(map.get("5"));
        }
        System.out.println(map.get("4"));


    }

    private static String changeValue(String s) {
        s = "ss";
        return s;
    }
}
