package com.steve.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: STEVE
 * @Description: 使用Semaphore模拟限流操作
 * @since: 2023/11/22
 */
public class UseSemaphore {

    public static void main(String[] args) {
        ExecutorService threadPools = Executors.newFixedThreadPool(20);
        /* 同一时间只能有5个线程执行 */
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            final int token = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        /* 进行业务操作 */
                        System.out.println("获得认可，执行操作..." + token);
                        long sleepTime = (long)(Math.random() * 10000);
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }
            };
            threadPools.execute(run);
        }
        System.out.println("queue length：" + semaphore.getQueueLength());
    }

}
