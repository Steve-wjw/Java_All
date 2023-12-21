package com.steve.demo.designMode.proxy;

/**
 * @Author: STEVE
 * @Description: 打印机接口
 * 抽象主题（Subject）类：通过接口或抽象类声明真实主题和代理对象实现的业务方法
 * @since: 2023/11/9
 */
public interface Printer {

    void printText(String text);

    void printImage(String image);

}
