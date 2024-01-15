package com.steve.combat.blockqueue;

/**
 * @Author: STEVE
 * @Description: 测试 - 手写阻塞队列
 * @since: 2024/1/11
 */
public class TestBlockQueue {

    public static void main(String[] args) {
        BlockQueue queue = new BlockQueue(5);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.add(i);
                System.out.println("塞入" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (; ; ) {
                System.out.println("消费" + queue.take());
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }

}
