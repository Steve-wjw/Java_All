package com.steve.demo.designMode.templatemethod;

/**
 * @Author: STEVE
 * @Description: TODO
 * @since: 2023/12/6
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }

}
