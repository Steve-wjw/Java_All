package com.steve.demo.designMode.singleton;

/**
 * @Author: STEVE
 * @Description: 静态内部类，利用类加载机制来保证初始化instance时只有一个线程，所以也是线程安全的，同时没有性能损耗，比另两种方法都好一些
 * @Version: 1.0
 */
public class InnerClassLazySingleton {

    private static class LazyHolder {
        private static final InnerClassLazySingleton instance = new InnerClassLazySingleton();
    }

    private InnerClassLazySingleton() {
    }

    public static final InnerClassLazySingleton getInstance() {
        return LazyHolder.instance;
    }

}
