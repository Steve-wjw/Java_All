package com.steve.demo.designMode.proxy;

/**
 * @Author: STEVE
 * @Description: 代理（Proxy）类，提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。
 * 代理打印机类，持有真实打印机类的引用，并实现打印机接口
 * @since: 2023/11/9
 */
public class ProxyPrinter implements Printer{

    private Printer printer;

    public ProxyPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void printText(String text) {
        System.out.println("ProxyPrinter starts printing text");
        printer.printText(text);
        System.out.println("ProxyPrinter finishes printing text");
    }

    @Override
    public void printImage(String image) {
        System.out.println("ProxyPrinter starts printing image");
        printer.printImage(image);
        System.out.println("ProxyPrinter finishes printing image");
    }
}
