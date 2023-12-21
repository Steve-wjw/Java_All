package com.steve.demo.designMode.adapter.classadapter;

/**
 * @Author: STEVE
 * @Description: 已存在的、具有特殊功能、但不符合我们既有的标准接口的类，需要适配的类
 * @since: 2023/12/13
 */
public class Adaptee {

    public void specificRequest() {
        System.out.println("被适配类 具有 特殊功能...");
    }

}