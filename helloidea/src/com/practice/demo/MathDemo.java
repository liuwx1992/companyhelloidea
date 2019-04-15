package com.practice.demo;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/4/15
 * @Time: 9:39
 */
public class MathDemo {
    public static void main(String[] args) {
        double d = 1.234;
        Integer ceil = getValueUpNumber(d);
        double floor = Math.floor(d);
        System.out.println(ceil);
        System.out.println(floor);
    }

    /**
     * double值向上取整后的整数值
     *
     * */
    private static Integer getValueUpNumber(double doublePeriod) {
        String stringMiddlePeriod = Math.ceil(doublePeriod) + "";
        String[] array = stringMiddlePeriod.split("\\.");
        if(array == null || array.length == 0){
            return 0;
        }
        Integer period = Integer.parseInt(array[0]);
        return period;
    }
}
