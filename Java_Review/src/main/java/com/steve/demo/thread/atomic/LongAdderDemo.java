package com.steve.demo.thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: STEVE
 * @Description: TODO
 * @since: 2023/12/6
 */
public class LongAdderDemo {

    // 主函数
    public static void main(String[] args) {
        LongAdder counter = new LongAdder();

        //新建线程池
        ExecutorService pool = Executors.newFixedThreadPool(20);
        long startTime = System.currentTimeMillis();

        //任务次数
        for (int i = 0; i < 10000; i++) {
            pool.submit(new Task(counter));
        }
        //关闭线程池
        pool.shutdown();
        while (!pool.isTerminated()){
        }
        long endTime = System.currentTimeMillis();
        System.out.println(counter.sum());
        System.out.println("LongAdder完成时间："+(endTime-startTime)+"毫秒");
    }

    private static class Task implements Runnable {
        private LongAdder count;

        public Task(LongAdder count) {
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                count.increment();//自增
            }
        }
    }
}
