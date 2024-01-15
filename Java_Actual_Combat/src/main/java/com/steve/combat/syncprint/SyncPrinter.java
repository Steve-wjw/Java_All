package com.steve.combat.syncprint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: STEVE
 * @Description: 手写多线程交替打印ABC
 * @since: 2024/1/11
 */
public class SyncPrinter implements Runnable {

    // 打印次数
    private static final int PRINT_COUNT = 10;

    private final ReentrantLock reentrantLock;
    private final Condition thisCondition;
    private final Condition nextCondition;

    private final char printChar;

    public SyncPrinter(ReentrantLock reentrantLock, Condition thisCondition, Condition nextCondition, char printChar) {
        this.reentrantLock = reentrantLock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        // 获取打印锁，进入临界区
        reentrantLock.lock();
        try {
            // 连续打印PRINT_COUNT次
            for (int i = 0; i < PRINT_COUNT; i++) {
                // 打印字符
                System.out.println(printChar);
                // 使用nextCondition唤醒下一个线程
                // 因为只有一个线程在等待，所以signal或者signalAll都可以
                nextCondition.signal();
                // 不是最后一次则通过thisCondtion等待被唤醒
                // 必须要加判断，不然虽然能够打印10次，但10次后就会直接死锁
                if (i < PRINT_COUNT - 1) {
                    try {
                        // 本线程让出锁并等待唤醒
                        thisCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
