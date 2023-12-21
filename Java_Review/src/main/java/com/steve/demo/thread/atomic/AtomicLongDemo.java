package com.steve.demo.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: STEVE
 * @Description: AtomicLong，20个线程并发，每个线程执行10000次
 * @since: 2023/12/6
 */
public class AtomicLongDemo {

    public static void main(String[] args) {
        AtomicLong counter = new AtomicLong(0);
        // 新建线程池
        ExecutorService pool = Executors.newFixedThreadPool(20);
        long startTime = System.currentTimeMillis();
        // 任务次数
        for (int i = 0; i < 10000; i++) {
            pool.submit(new Task(counter));
        }
        // 关闭线程池
        pool.shutdown();
        while (!pool.isTerminated()){}
        long endTime = System.currentTimeMillis();
        System.out.println(counter.get());
        System.out.println("AtomicLong完成时间："+(endTime-startTime)+"毫秒");
    }

    private static class Task implements Runnable {

        private AtomicLong count;

        public Task(AtomicLong count) {
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                count.incrementAndGet();
            }
        }
    }
}
