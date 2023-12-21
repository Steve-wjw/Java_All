package com.steve.demo.designMode.factory.simpleFactory;

/**
 * @Author: STEVE
 * @Description: 该模式的核心，用来创建产品，含有一定的商业逻辑和判断逻辑
 * @Version: 1.0
 */
public class Factory {

    public BMW createBMW(int type) {
        switch (type) {
            case 320:
                return new BMW320();
            case 523:
                return new BMW523();
            default:
                break;
        }
        return null;
    }

}
