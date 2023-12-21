package com.steve.demo.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: STEVE
 * @Description: 演示AtomicInteger的基本用法，并对比非原子类的线程安全问题
 * @since: 2023/12/6
 */
public class AtomicIntegerDemo implements Runnable {

    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private static final AtomicInteger atomicInteger2 = new AtomicInteger();

    // 原子类型自增
    public void atomicIncrement() {
        atomicInteger.getAndIncrement();
    }

    // 原子类型 getAndAdd()
    public void atomicAdd() {
        atomicInteger2.getAndAdd(4);
    }

    private static volatile int basicCount = 0;

    // 普通类型自增
    public void basicIncrement() {
        basicCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            atomicIncrement();
            basicIncrement();
            atomicAdd();
        }
    }

    // 主函数
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerDemo aid = new AtomicIntegerDemo();
        Thread thread1 = new Thread(aid);
        Thread thread2 = new Thread(aid);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("原子类的结果：" + atomicInteger.get());
        System.out.println("普通变量值：" + basicCount);
        System.out.println("getAndAdd的结果：" + atomicInteger2.get());
    }

}
