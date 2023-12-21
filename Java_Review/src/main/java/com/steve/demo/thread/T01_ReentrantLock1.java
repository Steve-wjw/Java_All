package com.steve.demo.thread;


import java.util.concurrent.TimeUnit;

/**
 * @Author: STEVE
 * @Description: synchronized是可重入锁的一种，意思就是我锁了一下还可以对同样这把锁再锁一下
 * @since: 2023/11/2
 */
public class T01_ReentrantLock1 {

    synchronized void m1() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) m2();
        }
    }

    synchronized void m2() {
        System.out.println("m2...");
    }

    public static void main(String[] args) {
        T01_ReentrantLock1 r1 = new T01_ReentrantLock1();
        new Thread(r1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
