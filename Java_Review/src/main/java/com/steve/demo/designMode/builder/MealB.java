package com.steve.demo.designMode.builder;

/**
 * @Author: STEVE
 * @Description: 具体建造者
 * @since: 2023/12/21
 */
public class MealB extends MealBuilder{

    @Override
    public void buildFood() {
        meal.setFood("三个鸡翅");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯柠檬果汁");
    }

}
