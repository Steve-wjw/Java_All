package com.steve.demo.designMode.builder;

/**
 * @Author: STEVE
 * @Description: 抽象建造者
 * @since: 2023/12/21
 */
public abstract class MealBuilder {

    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }

}
