package com.steve.demo.designMode.adapter.classadapter;

/**
 * @Author: STEVE
 * @Description: 具体目标类，只提供普通功能
 * @since: 2023/12/13
 */
public class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("普通类 具有 普通功能...");
    }

}
