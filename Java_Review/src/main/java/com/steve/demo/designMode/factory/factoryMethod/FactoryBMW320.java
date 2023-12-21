package com.steve.demo.designMode.factory.factoryMethod;

/**
 * @Author: STEVE
 * @Description: 被应用程序调用以创建具体产品的对象，含有和具体业务逻辑相关的代码
 * @Version: 1.0
 */
public class FactoryBMW320 implements FactoryBMW{

    @Override
    public BMW320 createBMW() {
        return new BMW320();
    }

}
