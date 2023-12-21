package com.steve.demo.designMode.adapter.objectadapter;

import com.steve.demo.designMode.adapter.classadapter.Adaptee;
import com.steve.demo.designMode.adapter.classadapter.ConcreteTarget;
import com.steve.demo.designMode.adapter.classadapter.Target;

/**
 * @Author: STEVE
 * @Description: TODO
 * @since: 2023/12/13
 */
public class Client {

    public static void main(String[] args) {
        // 使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        // 使用特殊功能类，即适配类
        // 需要先创建一个被适配类的对象作为对象
        Target adapter = new Adapter(new Adaptee());
        adapter.request();
    }

}
