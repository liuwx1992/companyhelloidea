package com.practice.juc.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * @Description:ForkJoin计算累加值
 * @Author: liuweixin
 * @Date: 2019/3/30
 * @Time: 11:35
 */
public class ForkJoinTest {
    public static void main(String[] args) {
        final int SIZE = 2000;
        Integer[] numbers = new Integer[SIZE];
        for (int i = 0; i < numbers.length; i++) {
            //numbers[i] = Math.random();
            numbers[i] = i+1;
        }
        Counter counter = new Counter(numbers,0,SIZE,x -> x > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        Integer ret = counter.join();
        System.out.println(ret);
    }

    static class Counter extends RecursiveTask<Integer> {

        private static final int THREDSHOLD = 1000;
        private Integer[] values;
        private int from;
        private int to;
        private DoublePredicate filter;

        public Counter(Integer[] values,int from,int to,DoublePredicate filter){
            this.values = values;
            this.from = from;
            this.to = to;
            this.filter = filter;
        }

        @Override
        protected Integer compute() {
            int distance = from - to;
            if(distance < THREDSHOLD){
                int count = 0;
                Integer result = 0;
                for(int i = from;i < to;i++){
                    if(filter.test(values[i])){
                        result += values[i];
                        //count++;
                    }
                }
                return result;
            }else {
                int middle = (from + to)/2;
                Counter first = new Counter(values,from,middle,filter);
                Counter second = new Counter(values,middle,to,filter);
                invokeAll(first,second);
                return first.join()+second.join();
            }
        }
    }

}
