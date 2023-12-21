package com.steve.demo.designMode.adapter.classadapter;

/**
 * @Author: STEVE
 * @Description: 测试类
 * @since: 2023/12/13
 */
public class Client {

    public static void main(String[] args) {
        // 使用普通功能类
        ConcreteTarget concreteTarget = new ConcreteTarget();
        concreteTarget.request();
        // 使用特殊功能类，即适配类
        Target adapter = new Adapter();
        adapter.request();
    }

}
