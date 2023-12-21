package com.steve.demo.designMode.factory.simpleFactory;

/**
 * @Author: STEVE
 * @Description: 将创建宝马的操作细节都放到了工厂里，而客户直接使用工厂的创建方法，传入想要的宝马型号就行了，而不必知道创建的细节
 * 缺点是
 * 每次添加新产品就需要修改工厂类，在产品类型较多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展维护，
 * 并且工厂类集中了所有产品的创建逻辑，一旦不能正常工作，整个系统都要收到影响
 * @Version: 1.0
 */
public class Customer {

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.createBMW(320);
        factory.createBMW(523);
    }

}
