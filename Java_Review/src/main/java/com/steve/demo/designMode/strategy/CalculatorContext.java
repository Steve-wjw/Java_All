package com.steve.demo.designMode.strategy;


/**
 * @Author: STEVE
 * @Description: 环境角色(Context)：持有一个策略类的引用，提供给客户端使用。
 * @since: 2023/11/9
 */
public class CalculatorContext {

    private CalculateStrategy calculateStrategy;

    public CalculatorContext(CalculateStrategy calculateStrategy) {
        this.calculateStrategy = calculateStrategy;
    }

    public int executeStrategy(int num1, int num2) {
        return calculateStrategy.doOperation(num1, num2);
    }

}
