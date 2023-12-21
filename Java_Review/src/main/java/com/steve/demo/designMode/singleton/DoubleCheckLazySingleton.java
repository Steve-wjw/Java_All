package com.steve.demo.designMode.singleton;

/**
 * @Author: STEVE
 * @Description: 双重检查锁 懒汉式单例
 * @Version: 1.0
 */
public class DoubleCheckLazySingleton {

    private DoubleCheckLazySingleton() {
    }

    public volatile static DoubleCheckLazySingleton doubleCheckLazySingleton = null;

    public static DoubleCheckLazySingleton getInstance() {
        if (doubleCheckLazySingleton == null) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (doubleCheckLazySingleton == null) {
                    doubleCheckLazySingleton = new DoubleCheckLazySingleton();
                }
            }
        }
        return doubleCheckLazySingleton;
    }

}
