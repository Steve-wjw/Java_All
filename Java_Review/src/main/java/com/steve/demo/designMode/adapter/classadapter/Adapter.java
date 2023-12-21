package com.steve.demo.designMode.adapter.classadapter;

/**
 * @Author: STEVE
 * @Description: 适配器类，继承了被适配类，同时实现标准接口
 * @since: 2023/12/13
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        super.specificRequest();
    }

}
