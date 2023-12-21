package com.steve.demo.designMode.strategy;

/**
 * @Author: STEVE
 * @Description: 抽象策略角色(Strategy)：这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。
 * @since: 2023/11/9
 */
public interface CalculateStrategy {

    int doOperation(int num1, int num2);

}
