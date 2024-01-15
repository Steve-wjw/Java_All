package com.steve.combat.blockqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: STEVE
 * @Description: 手写阻塞队列
 * @since: 2024/1/10
 */
public class BlockQueue {

    private List<Integer> container = new ArrayList<>();

    private volatile int size;
    private volatile int capacity;

    private Lock lock = new ReentrantLock();
    private final Condition isNull = lock.newCondition();
    private final Condition isFull = lock.newCondition();

    BlockQueue(int capacity) {
        this.capacity = capacity;
    }

    public void add(int data) {
        try {
            lock.lock();
            try {
                while (size >= capacity) {
                    System.out.println("阻塞队列满了");
                    isFull.await();
                }
            } catch (Exception e) {
                isFull.signal();
                e.printStackTrace();
            }
            ++size;
            container.add(data);
            isNull.signal();
        } finally {
            lock.unlock();
        }
    }

    public int take() {
        try {
            lock.lock();
            try {
                while (size == 0) {
                    System.out.println("阻塞队列空了");
                    isNull.await();
                }
            } catch (Exception e) {
                isNull.signal();
                e.printStackTrace();
            }
            --size;
            int res = container.get(0);
            container.remove(0);
            isFull.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

}
