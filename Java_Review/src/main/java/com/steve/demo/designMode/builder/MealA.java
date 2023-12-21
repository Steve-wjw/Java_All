package com.steve.demo.designMode.builder;

/**
 * @Author: STEVE
 * @Description: 具体建造者
 * @since: 2023/12/21
 */
public class MealA extends MealBuilder{

    @Override
    public void buildFood() {
        meal.setFood("一盒薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }

}
