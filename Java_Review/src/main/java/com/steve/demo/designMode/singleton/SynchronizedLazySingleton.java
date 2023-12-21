package com.steve.demo.designMode.singleton;

/**
 * @Author: STEVE
 * @Description: 懒汉式单例类，在第一次调用的时候实例化自己
 * @Version: 1.0
 */
public class SynchronizedLazySingleton {

    // 私有化构造器，避免类在外部被实例化，而是只能通过getInstance()方法获取LazySingleton的唯一实例
    private SynchronizedLazySingleton() {
    }

    private static SynchronizedLazySingleton synchronizedLazySingleton = null;

    // 加上同步机制，线程安全，但是会降低性能
    public static synchronized SynchronizedLazySingleton getInstance() {
        if(synchronizedLazySingleton == null){
            synchronizedLazySingleton = new SynchronizedLazySingleton();
        }
        return synchronizedLazySingleton;
    }

}
