package com.steve.demo.designMode.factory.abstractFactory;

/**
 * @Author: STEVE
 * @Description: 抽象工厂，定义了接口，这个接口包含了一组方法用来生产产品，所有的具体工厂都必须实现此接口
 * @Version: 1.0
 */
public interface FactoryBMW {

    // 制造发动机
    Engine createEngine();

    // 制造空调
    Aircondition createAircondition();

}
