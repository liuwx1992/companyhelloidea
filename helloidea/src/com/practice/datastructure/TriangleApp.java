package com.practice.datastructure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/16
 * @Time: 17:15
 */
public class TriangleApp {
    static int number;

    public static void main(String[] args) {
        number = getInt();
        System.out.println("number is :"+ number);
        int answer = triangle(number);
        System.out.println("triangle answer = " + answer);
    }

    private static int triangle(int theNumber) {
        int result = 0;
        if(theNumber <= 1){
            result = 1;
        }else {
            result = triangle(theNumber - 1) + theNumber;
        }
        return result;
    }

    private static String getString() {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStream);
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    private static int getInt() {
        String input = getString();
        return Integer.parseInt(input);
    }

}
