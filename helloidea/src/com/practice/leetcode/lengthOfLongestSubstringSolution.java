package com.practice.leetcode;

import java.util.*;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/16
 * @Time: 14:19
 */
public class lengthOfLongestSubstringSolution {
    public static void main(String[] args) {
        String s = "abcde123fahaygklk";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int getlengthOfLongestSubstring(String ss){
        List<Integer> list= new ArrayList<>();
        int length = 0;
        if(ss != null && ss.length() > 0){
            for (int i = 0;i < ss.length();i++){
                for (int j = i+1;j < ss.length();j++){
                    if(ss.charAt(i) == ss.charAt(j)){
                        length = j - i;
                    }else {
                        continue;
                    }
                }
                list.add(length);
                length = 0;
            }
            //Collections.sort(list);
            //return list.get(list.size()-1);
            Optional<Integer> max = list.stream().max(Integer::compareTo);
            return max.get();
        }
        return 0;
    }

    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;
        for (int i = 0;i < length;i++){
            for (int j = i+1;j < s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    length = j - i;
                }
            }
            if(length > max){
                max = length;
            }
        }
        return max;
    }

}
