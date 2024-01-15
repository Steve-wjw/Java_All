package com.steve.combat;

/**
 * @Author: STEVE
 * @Description: 手写单例，双检锁
 * @since: 2024/1/9
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
