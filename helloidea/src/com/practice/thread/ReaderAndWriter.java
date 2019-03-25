package com.practice.thread;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:在Java中Lock接口比synchronized块的优势是什么？
 *         你需要实现一个高效的缓存，它允许多个用户读，但只允许一个用户写，以此来保持它的完整性，你会怎样去实现它？
 *
 *         整体上来说Lock是synchronized的扩展版，Lock提供了无条件的、可轮询的(tryLock方法)、定时的(tryLock带参方法)、可中断的(lockInterruptibly)、
 *         可多条件队列的(newCondition方法)锁操作。另外Lock的实现类基本都支持非公平锁(默认)和公平锁，synchronized只支持非公平锁，
 *         当然，在大部分情况下，非公平锁是高效的选择。
 *
 *         public interface Lock {
 *
 *              void lock();
 *
 *              void lockInterruptibly() throws InterruptedException;
 *
 *              boolean tryLock();
 *
 *              boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
 *
 *              void unlock();
 *
 *              Condition newCondition();
 *
 *       }
 *
 *      public interface ReadWriteLock {
 *
 *          Lock readLock();
 *
 *          Lock writeLock();
 *
 *     }
 *     ReadWriteLock是对Lock的运用，具体的实现类是 ReentrantReadWriteLock ，下面用这个类来实现读写类型的高效缓存：
 *
 * @Author: liuweixin
 * @Date: 2019/3/22
 * @Time: 15:59
 */
public class ReaderAndWriter<K,V> {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private final Map<K,V> map;

    public ReaderAndWriter(Map<K, V> map) {
        this.map = map;
    }

    /*************   这是用lock()方法写的   ********************/
    public V putByLock(K key,V value){
        writeLock.lock();
        try {
            return map.put(key, value);
        }finally {
            writeLock.unlock();
        }
    }

    public V getByLock(K key){
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }
    }


    /**
     * 这是用tryLock()方法写的
     *
     * */
    public V putByTryLock(K key,V value){
        while (true){
            if(writeLock.tryLock()){
                try {
                    System.out.println("put "+ key +" = " + value);
                    return map.put(key,value);
                }finally {
                    writeLock.unlock();
                }
            }
        }
    }

    public V getByTryLock(K key){
        while (true){
            if(readLock.tryLock()){
                try {
                    V value = map.get(key);
                    System.out.println("get "+ key +" = " + value);
                    return value;
                }finally {
                    readLock.unlock();
                }
            }
        }
    }

    /********************    下面是测试区       *********************************/
    public static void main(String[] args) {
        ReaderAndWriter readerAndWriter = new ReaderAndWriter(new HashMap<>());
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new TestRunnable(readerAndWriter));
        }
        executorService.shutdown();
    }

    static class TestRunnable implements Runnable{

        private final ReaderAndWriter<String, Integer> readerAndWriter;
        private final String KEY = "X";

        public TestRunnable(ReaderAndWriter readerAndWriter){
            this.readerAndWriter = readerAndWriter;
        }

        @Override
        public void run() {
            Random random = new Random();
            int ranInt = random.nextInt(100);
            //生成随机数，小于30的写入缓存，大于等于30则读取数字
            if(ranInt < 30){
                readerAndWriter.putByTryLock(KEY,ranInt);
            }else {
                readerAndWriter.getByTryLock(KEY);
            }
        }
    }

}
