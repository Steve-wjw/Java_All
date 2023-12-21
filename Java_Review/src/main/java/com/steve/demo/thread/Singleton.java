package com.steve.demo.thread;

/**
 * @Author: STEVE
 * @Description: 双重校验锁实现懒汉式单例模式
 * @since: 2023/11/2
 */
public class Singleton {

    private volatile static Singleton instance = null; //禁止指令重排

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null){ //减少加锁的损耗
            synchronized (Singleton.class) {
                if (instance == null) //确认是否初始化完成
                    instance = new Singleton();
            }
        }
        return instance;
    }

}
