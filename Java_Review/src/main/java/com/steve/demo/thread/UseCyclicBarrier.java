package com.steve.demo.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: STEVE
 * @Description: 每个线程代表一个跑步运动员，当运动员都准备好后，才一起出发，只要有一个人没有准备好，大家都等待。
 * @since: 2023/11/22
 */
public class UseCyclicBarrier {

    /* 模拟运动员的类 */
    static class Runner implements Runnable {

        private final String name;
        private final CyclicBarrier cyclicBarrier;

        public Runner(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("运动员：" + this.name + "进行准备工作！");
                TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                System.out.println("运动员：" + this.name + "准备完成！");
                this.cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("运动员：" + this.name + "开始起跑！！！");
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorPools = Executors.newFixedThreadPool(3);

        executorPools.submit(new Thread(new Runner("张三", cyclicBarrier)));
        executorPools.submit(new Thread(new Runner("李四", cyclicBarrier)));
        executorPools.submit(new Thread(new Runner("王五", cyclicBarrier)));

        executorPools.shutdown();
    }

}
