package com.steve.demo.designMode.factory.abstractFactory;

/**
 * @Author: STEVE
 * @Description: 用于生产不同产品族，要创建一个产品，用户只需要使用其中一个产品进行获取，完全不需要实例化任何产品对象
 *
 * 为宝马320系列生产配件
 * @since: 2023/10/25
 */
public class FactoryBMW320 implements FactoryBMW {

    @Override
    public Engine createEngine() {
        return new EngineA();
    }

    @Override
    public Aircondition createAircondition() {
        return new AirconditionA();
    }
}
