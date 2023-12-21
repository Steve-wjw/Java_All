package com.steve.demo.designMode.strategy;

/**
 * @Author: STEVE
 * @Description: 具体策略角色(ConcreteStrategy)：包装了相关的算法或行为。
 * @since: 2023/11/9
 */
public class OperationSub implements CalculateStrategy{

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
    
}
