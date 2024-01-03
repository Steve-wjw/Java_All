package com.steve.workqueue.utils;

/**
 * @Author: STEVE
 * @Description: 睡眠工具类
 * @since: 2023/12/29
 */
public class SleepUtils {

    public static void sleep(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
