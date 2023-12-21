package com.steve.demo.designMode.builder;

/**
 * @Author: STEVE
 * @Description: 测试类
 * @since: 2023/12/21
 */
public class Client {

    public static void main(String[] args) {
        // 服务员
        Waiter waiter = new Waiter();
        // 套餐A
        MealA a = new MealA();
        // 服务员准备套餐A
        waiter.setMealBuilder(a);
        // 获得套餐
        Meal mealA = waiter.construct();

        System.out.println("套餐A的组成部分：");
        System.out.println(mealA.getFood() + "---" + mealA.getDrink());
    }

}
