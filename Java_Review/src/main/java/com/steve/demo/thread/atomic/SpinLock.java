package com.steve.demo.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: STEVE
 * @Description: 自旋锁演示
 * @since: 2023/12/6
 */
public class SpinLock {

    private AtomicReference<Thread> sign = new AtomicReference<>();

    // 加锁操作
    public void lock() {
        Thread current = Thread.currentThread();
        // 期待是null，如果是期望的，就将其设置为current
        while(!sign.compareAndSet(null, current)) {
            System.out.println(Thread.currentThread().getName() + "：自旋获取失败，再次尝试");
        }
    }

    // 解锁操作
    public void unlock() {
        Thread current = Thread.currentThread();
        // 期待加锁的当前线程，如果是期望的，就将其设置为为null，也就是没有持有了，就是解锁了
        sign.compareAndSet(current, null);
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始尝试获取自旋锁");
                spinLock.lock();
                System.out.println(Thread.currentThread().getName() + "：获取到了自旋锁");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    spinLock.unlock();
                    System.out.println(Thread.currentThread().getName() + "：释放了自旋锁");
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

}
