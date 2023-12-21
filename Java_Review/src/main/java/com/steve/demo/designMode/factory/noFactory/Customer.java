package com.steve.demo.designMode.factory.noFactory;

/**
 * @Author: STEVE
 * @Description: 不使用工厂，用户将自己创建宝马车
 * 用户需要知道如何创建一款车，这样子客户和车就紧密耦合在一起了，为了降低耦合，出现了简单工厂模式
 * @Version: 1.0
 */
public class Customer {

    public static void main(String[] args) {
        BMW320 bmw320 = new BMW320();
        BMW523 bmw523 = new BMW523();
    }

}
