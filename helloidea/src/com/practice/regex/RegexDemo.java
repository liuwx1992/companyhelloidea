package com.practice.regex;

import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/14
 * @Time: 10:41
 */
public class RegexDemo {
    public static void main(String[] args) {
        String verifyExpiryDate = "9999.02.12-2019.02.12";
        String s = verifyExpiryDate(verifyExpiryDate);
        System.out.println(s);
    }

    /**
     * 验证身份证有效期
     */
    private static String verifyExpiryDate(String expiryDate){
        if(expiryDate.contains("-")){
            String begin=expiryDate.split("-")[0];
            String end=expiryDate.split("-")[1];
            //String eL = "[0-9]{4}.[0-9]{2}.[0-9]{2}";
            String eL = "[d]{8}";
            Pattern pattern = Pattern.compile(eL);
            if(pattern.matcher(begin).matches()){
                begin=getCorrectExpiryDate(begin);
            }
            if(pattern.matcher(end).matches()){
                end=getCorrectExpiryDate(end);
            }
            expiryDate=begin+"-"+end;
        }
        return expiryDate;
    }

    /**
     * 获取正确的有效日期
     * @param date 日期
     * @return
     */
    private static String getCorrectExpiryDate(String date) {
        String year = date.substring(0, date.indexOf("."));
        String month = date.substring(date.indexOf(".") + 1, date.lastIndexOf("."));
        String day = date.substring(date.lastIndexOf(".") + 1);
        if (Integer.valueOf(month) == 2 && Integer.valueOf(day) > 28) {
            date = year + "." + month + ".28";
        } else if (Integer.valueOf(day) > 30) {
            date = year + "." + month + ".30";
        }
        return date;
    }
}
