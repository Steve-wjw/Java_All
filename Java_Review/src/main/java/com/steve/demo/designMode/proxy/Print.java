package com.steve.demo.designMode.proxy;

/**
 * @Author: STEVE
 * @Description: TODO
 * @since: 2023/11/9
 */
public class Print {

    public static void main(String[] args) {
        RealPrinter realPrinter = new RealPrinter();
        ProxyPrinter proxyPrinter = new ProxyPrinter(realPrinter);
        proxyPrinter.printText("Hello World");
        proxyPrinter.printImage("Java.img");
    }

}
