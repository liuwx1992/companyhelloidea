package com.practice.thread;

import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/27
 * @Time: 10:13
 */
public class FutureDemoCounter implements Callable<Integer> {

    /**
     * 执行任务，可返回结果
     *
     * */
    @Override
    public Integer call() throws Exception {
        try (Scanner in = new Scanner(System.in)){
            System.out.print("Enter parameter1:");
            String parameter1 = in.nextLine();
            System.out.print("Enter parameter2:");
            String parameter2 = in.nextLine();
            Integer ret = Integer.parseInt(parameter1) * Integer.parseInt(parameter2);
            return ret;
        }
    }
}
