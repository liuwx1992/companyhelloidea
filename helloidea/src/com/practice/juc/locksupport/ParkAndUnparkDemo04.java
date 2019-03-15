package com.practice.juc.locksupport;

import javax.net.ssl.SSLSession;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description:，在先调用unpark，再调用park时，仍能够正确实现同步，不会造成由wait/notify调用顺序不当所引起的阻塞。
 *                因此park/unpark相比wait/notify更加的灵活。
 * @Author: liuweixin
 * @Date: 2019/3/2
 * @Time: 10:47
 */
public class ParkAndUnparkDemo04 {
    public static void main(String[] args) {
        MyThread04 myThread04 = new MyThread04(Thread.currentThread());
        myThread04.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");

    }
}
