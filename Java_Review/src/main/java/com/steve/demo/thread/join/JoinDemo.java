package com.steve.demo.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * @Author: STEVE
 * @Description: TODO
 * @since: 2023/12/6
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程线程A开始运行。。。");
        ThreadC threadC = new ThreadC();
        threadC.setName("ThreadC");
        threadC.start();

        threadC.join();

        ThreadB threadB = new ThreadB();
        threadB.setName("ThreadB");
        threadB.start();

        threadB.join();

        System.out.println("主线程线程A结束运行");
    }

    public static class ThreadB extends Thread {

        public void run() {
            System.out.println("线程：" + Thread.currentThread().getName() + "休眠:10s");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程：" + Thread.currentThread().getName() + "休眠结束");
        }

    }

    public static class ThreadC extends Thread {

        public void run() {
            System.out.println("线程：" + Thread.currentThread().getName() + "休眠:1s");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程：" + Thread.currentThread().getName() + "休眠结束");
        }

    }

}
