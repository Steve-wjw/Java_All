package com.steve.demo.designMode.proxy;

/**
 * @Author: STEVE
 * @Description: 真实的打印机类，实现打印机接口
 * 真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 * @since: 2023/11/9
 */
public class RealPrinter implements Printer{

    @Override
    public void printText(String text) {
        System.out.println("RealPrinter prints text: " + text);
    }

    @Override
    public void printImage(String image) {
        System.out.println("RealPrinter prints image: " + image);
    }
}
