package com.steve.demo.designMode.singleton;

/**
 * @Author: STEVE
 * @Description: 饿汉式单例类，在类初始化时，已经自行实例化，天生是线程安全的
 * @Version: 1.0
 */
public class HungrySingleton {

    private HungrySingleton() {
    }

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    // 静态工厂方法
    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

}
