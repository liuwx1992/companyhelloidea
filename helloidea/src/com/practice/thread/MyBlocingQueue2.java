package com.practice.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:模仿ArrayBlockingQueue实现阻塞队列
 * @Author: liuweixin
 * @Date: 2019/3/25
 * @Time: 18:16
 */
public class MyBlocingQueue2<E> {
    private final List<E> list;
    private final int limit;
    private final ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public MyBlocingQueue2(int limit){
        this.limit = limit;
        list = new LinkedList<>();
    }

    public void put(E element){
        lock.lock();
        try {
            while(list.size() == limit){
                notFull.await();
            }
            list.add(element);
            notEmpty.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public E take(){
        lock.lock();
        try {
            while (list.size() == 0){
                notEmpty.await();
            }
            E remove = list.remove(0);
            notFull.signalAll();
            return remove;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
