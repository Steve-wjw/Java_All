package com.steve.demo.designMode.factory.factoryMethod;

/**
 * @Author: STEVE
 * @Description: TODO
 * @Version: 1.0
 */
public class FactoryBMW523 implements FactoryBMW{

    @Override
    public BMW523 createBMW() {
        return new BMW523();
    }

}
