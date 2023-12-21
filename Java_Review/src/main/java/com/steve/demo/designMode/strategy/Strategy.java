package com.steve.demo.designMode.strategy;

/**
 * @Author: STEVE
 * @Description: TODO
 * @since: 2023/11/9
 */
public class Strategy {

    public static void main(String[] args) {
        int a = 4, b = 2;
        CalculatorContext context1 = new CalculatorContext(new OperationAdd());
        System.out.println("a + b = " + context1.executeStrategy(a, b));
        CalculatorContext context2 = new CalculatorContext(new OperationSub());
        System.out.println("a - b = " + context2.executeStrategy(a, b));
        CalculatorContext context3 = new CalculatorContext(new OperationMul());
        System.out.println("a * b = " + context3.executeStrategy(a, b));
        CalculatorContext context4 = new CalculatorContext(new OperationDiv());
        System.out.println("a / b = " + context4.executeStrategy(a, b));
    }

}
