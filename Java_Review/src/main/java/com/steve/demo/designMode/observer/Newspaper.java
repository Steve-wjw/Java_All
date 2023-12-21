package com.steve.demo.designMode.observer;

/**
 * @Author: STEVE
 * @Description: 报纸接口，也就是被观察者接口，包含添加、删除、通知三个动作
 * @since: 2023/12/7
 */
public interface Newspaper {

    /**
     * 添加订阅者
     * @param subscriber
     */
    void addSubscriber(Subscriber subscriber);

    /**
     * 移除订阅者
     * @param subscriber
     */
    void removeSubscriber(Subscriber subscriber);

    /**
     * 通知订阅者
     * @param message
     */
    void notifySubscribers(String message);

}
