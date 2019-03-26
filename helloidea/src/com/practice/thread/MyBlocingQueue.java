package com.practice.thread;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: liuweixin
 * @Date: 2019/3/25
 * @Time: 16:32
 */
public class MyBlocingQueue<E> {

    private final List<E> list;
    private final int limit;//有大小限制的

    public MyBlocingQueue(int limit){
        this.limit = limit;
        list = new ArrayList<E>();
    }

    public void put(E element){
        while (true){
            synchronized (list){
                if(list.size() < limit){
                    System.out.println("list : " + list.toString());
                    System.out.println("put : " + element);
                    list.add(element);

                }
            }
        }
    }

    public E take(){
        while (true){
            synchronized (list){
                if(list.size() > 0){
                    System.out.println("list : " + list.toString());
                    E remove = list.remove(0);
                    System.out.println("take : " + remove);
                    return remove;
                }
            }
        }
    }

    public synchronized void putByWaitAndNotify(E e){
        while (list.size() == limit){
            try {
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("list : " + list.toString());
        System.out.println("put : " + e);
        list.add(e);
        notifyAll();
    }

    public synchronized E takeByWaitAndNotify(){
        while (list.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("list : " + list.toString());
        E remove = list.remove(0);
        System.out.println("take : " + remove);
        notifyAll();
        return remove;
    }

    /********************    下面是测试区       *********************************/
    public static void main(String[] args) {
        final MyBlocingQueue<Integer> myBlocingQueue = new MyBlocingQueue(10);

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            System.out.println("------------------");
            exec.execute(new TestRunnable(myBlocingQueue));
        }

        exec.shutdown();
    }

    static class TestRunnable implements Runnable{

        private final MyBlocingQueue<Integer> myBlocingQueue;

        TestRunnable(MyBlocingQueue<Integer> myBlocingQueue) {

            this.myBlocingQueue = myBlocingQueue;

        }

        @Override
        public void run() {
            Random random = new Random();
            int r = random.nextInt(100);
            //生成随机数,按照一定比率读取或者放入，可以更改！！！
            if (r < 30){
                myBlocingQueue.put(r);
            } else {
                myBlocingQueue.take();
            }
        }
    }

}
