package com.steve.combat.syncprint;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: STEVE
 * @Description: 测试 - 手写多线程交替打印ABC
 * @since: 2024/1/11
 */
public class TestSyncPrinter {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread printA = new Thread(new SyncPrinter(lock, conditionA, conditionB, 'A'));
        Thread printB = new Thread(new SyncPrinter(lock, conditionB, conditionC, 'B'));
        Thread printC = new Thread(new SyncPrinter(lock, conditionC, conditionA, 'C'));
        printA.start();
        Thread.sleep(100);
        printB.start();
        Thread.sleep(100);
        printC.start();
    }

}
