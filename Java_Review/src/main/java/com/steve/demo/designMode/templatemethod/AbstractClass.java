package com.steve.demo.designMode.templatemethod;

/**
 * @Author: STEVE
 * @Description: 抽象类
 * @since: 2023/12/6
 */
abstract class AbstractClass {

    // 模版方法
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    // 具体方法
    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    //抽象方法1
    public abstract void abstractMethod1();

    //抽象方法2
    public abstract void abstractMethod2();

}
