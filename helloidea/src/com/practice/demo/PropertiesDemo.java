package com.practice.demo;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/5
 * @Time: 22:55
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(new File("E:\\code\\ideaproject\\helloidea\\src\\com\\practice\\resources\\properties"));
        Properties props = new Properties();
        props.load(inputStream);
        for (Map.Entry<Object,Object> entry : props.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }
}
