package com.steve.combat.threadpool;

/**
 * @Author: STEVE
 * @Description: 手写线程池 - 测试
 * @since: 2024/1/9
 */
public class TestMySelfThreadPool {

    private static final int TASK_NUM = 50; // 任务的个数

    public static void main(String[] args) {
        MySelfThreadPool myPool = new MySelfThreadPool(3, 50);
        for (int i = 0; i < TASK_NUM; i++) {
            myPool.execute(new MyTask("task_" + i));
        }
    }

    static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task:" + name + "end...");
        }

        @Override
        public String toString() {
            return "name=" + name;
        }
    }

}
